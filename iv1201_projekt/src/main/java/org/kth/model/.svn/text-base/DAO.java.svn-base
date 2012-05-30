/**
 * Mikael Nilsson
 * Johan Schedin Jigland
 * Nikolai Padyukov
 * Arkitektur och design av globala applikationer, IV1201
 * 
 * 2011-03-02
 *
 * This software is provided 'as-is', without any express or implied
 * warranty.  In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must not
 *    claim that you wrote the original software. If you use this software
 *    in a product, an acknowledgment in the product documentation would be
 *    appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be
 *    misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */
package org.kth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kth.DTO.ApplicationRowDTO;
import org.kth.DTO.EntityCompetenceDTO;
import org.kth.DTO.EntityTimePeriodDTO;
import org.kth.DTO.FullJobapplicationDTO;
import org.kth.model.database.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The DAO acts as an interface to the database. All database calls from the
 * business logic classes has to pass through the dao. The dao uses Hibernate
 * to talk with database.
 * 
 * Transactions 
 * @author kolkol
 */
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true)
public class DAO implements Serializable {

    @Inject
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(DAO.class);

    /**
     * Checks the database if the provided username and password are valid.
     * If they are, the method returns true, else false.
     * @param username A user provided username
     * @param pass A user provided password.
     * @return True is a valid combination of username/password.
     */
    public boolean loginRecruiter(String username, String pass) {
        boolean retval = false;
        Account acc = (Account) sessionFactory.getCurrentSession().get(Account.class, username);

        if (acc != null) {
            Recruiter r = acc.getRecruiter();
            if (r != null) {
                if (acc.getUserPassword().equals(pass)) {
                    retval = true;
                }
            }
        }
        return retval;
    }

    /**
     * Get a jobseeker based on the jobseekers id
     * 
     * TODO: error control and logging
     * @param id
     * @return A jobseeker object with the specified id
     */
    public Jobseeker getJobSeeker(long id) {
        return (Jobseeker) sessionFactory.getCurrentSession().get(Jobseeker.class, id);
    }

    /**
     * Returns the real name of a user based on the users account name.
     * @param userName The account username
     * @return The real name of the person tied to this account.
     */
    public String getUserRealName(String userName) {
        Account c = (Account) sessionFactory.getCurrentSession().get(Account.class, userName);
        Person p = c.getPerson();
        return p.getFirstName() + " " + p.getLastName();
    }

    /**
     * The method that will search the database for job applications according to
     * the provided arguments
     * 
     * The arguments MUST be valid. Never call this method directly
     * 
     * Only called through the SearchManager class.
     * @param startDateArg The start date search parameter
     * @param endDateArg The ned date search parameter
     * @param regDateArg The registration date parameter
     * @param firstNameArg The first name searhc paramenter
     * @param lastNameArg The last name search parameter
     * @param compArg The competence search parameter
     * @return A list of matching Applications as ApplicationRowDTO objects
     */
    public List<ApplicationRowDTO> getSearchedApplications(String startDateArg,
            String endDateArg, String regDateArg, String firstNameArg,
            String lastNameArg, String compArg) {
        String textQuery = "SELECT DISTINCT a.userName, p.firstName, p.lastName, ja.dateOfRegistration "
                + "FROM Account a, Person p, Jobapplication ja, Jobseeker js, Timeperiod tp, Competence cp "
                + "WHERE a.person = p.p_id AND js.account = a.userName "
                + "AND ja.jobseeker = js.js_id AND tp.jobseeker = js.js_id "
                + "AND cp.jobseeker = js.js_id AND " + startDateArg + " "
                + "AND " + endDateArg + " AND " + regDateArg + " "
                + "AND " + firstNameArg + " AND " + lastNameArg + " "
                + "AND " + compArg;
        List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(textQuery).list();
        List<ApplicationRowDTO> returnList = new ArrayList<ApplicationRowDTO>();
        for (int i = 0; i < list.size(); i++) {
            String uname = (String) list.get(i)[0];
            String fname = (String) list.get(i)[1];
            String lname = (String) list.get(i)[2];
            Date dor = (Date) list.get(i)[3];
            returnList.add(new ApplicationRowDTO(uname, fname, lname, ((dor.getYear() + 1900) + "-" + (dor.getMonth() + 1) + "-" + dor.getDate())));
        }

        return returnList;
    }

    /**
     * Returns a lest of all competence category keys from the database.
     * These keys should correspont to hashmap-key values in the Category.properties file
     * @return A list of all competence category keys.
     */
    public List<Competencecategory> getAllCompetenceCategories() {
        return sessionFactory.getCurrentSession().getNamedQuery("Competencecategory.findAll").list();
    }

    /**
     * REturns a Full job application based on the username of the person that
     * did the application.
     * @param userName The username of the account tied to this application
     * @return A Job application DTO with ALL data from a job application
     */
    public FullJobapplicationDTO getApplicationByUsername(String userName) {

        Account account = (Account) sessionFactory.getCurrentSession().get(Account.class, userName);
        Person person = account.getPerson();

        Jobseeker js = account.getJobSeeker();
        Jobapplication ja = js.getJobApp();

        Set<EntityTimePeriodDTO> tps = js.getTimePeriods();
        List<EntityTimePeriodDTO> tp = new ArrayList<EntityTimePeriodDTO>(tps);

        Set<EntityCompetenceDTO> cps = js.getCompetences();
        List<EntityCompetenceDTO> cp = new ArrayList<EntityCompetenceDTO>(cps);
        Date date = ja.getDateOfRegistration();
        String accepted = "No";
        if (ja.getAccepted()) {
            accepted = "Yes";
        }

        FullJobapplicationDTO app = new FullJobapplicationDTO(account.getUserName(), person.getFirstName(), person.getLastName(), person.getEmailAdress(), (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate(), accepted, tp, cp);


        return app;
    }

    /**
     * Add a new Job seeker application to the database.
     * 
     * Transactions are used and operations is hence safe should something go wrong
     * @param person A Person object, with personal information
     * @param acc The account connected to the person
     * @param js A Jobseeker
     * @param ja A job application object with additional information.
     * @param competences A list of competences
     * @param tps A list of time periofs 
     */
    @Transactional(rollbackFor = Exception.class)
    public void addJobSeeker(Person person, Account acc, Jobseeker js, Jobapplication ja, List<Competence> competences, List<Timeperiod> tps) {
        Session session = sessionFactory.getCurrentSession();

        session.save(person);
        acc.setPerson(person);
        session.save(acc);

        session.save(js);

        ja.setJobSeeker(js);
        session.save(ja);

        for (Competence comp : competences) {
            comp.setJobSeeker(js);
            session.save(comp);
        }

        for (Timeperiod tp : tps) {
            tp.setJobSeeker(js);
            session.save(tp);
        }
        logger.log(Level.INFO, "New Jobs application entered: " + person);
    }

    /**
     * Approves the jobSeeker and sets a flag in the database to true
     * @param userName 
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean setApproveJobSeeker(String userName, Boolean status) {
        Session session = sessionFactory.getCurrentSession();
        Account acc = (Account) session.get(Account.class, userName);

        Jobseeker job = acc.getJobSeeker();
        Jobapplication jobApp = job.getJobApp();
        jobApp.setAccepted(status);
        session.saveOrUpdate(jobApp);
        return true;
    }
}
