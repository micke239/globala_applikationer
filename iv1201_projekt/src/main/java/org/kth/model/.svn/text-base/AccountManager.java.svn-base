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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kth.DTO.DateAvailabilityDTO;
import org.kth.DTO.NewJobSeekerStageOneDTO;
import org.kth.DTO.NewJobSeekerStageThreeDTO;
import org.kth.DTO.NewJobSeekerStageTwoDTO;
import org.kth.model.database.*;
import org.springframework.stereotype.Service;

/**
 * TODO: possible namechange of this class / split into several managers.
 * The AccountManager is responsible for packading and adding new "Accounts" to the
 * system. An Account is either a rectruiter or a JobSeeker which will get a
 * temporary account tied to the data associated with that job seeker
 * @author Johan Schedin Jigland
 */
@Service
public class AccountManager implements Serializable
{
    @Inject private DAO dao;
    private static final Logger logger = Logger.getLogger(AccountManager.class);
    /**
     * Adds a new Jobseeker to the database, through the DAO
     * @param nJobSeekerOne The information from the first stage in the 
     * application information entering process
     * @param nJobSeekerTwo The information from the second stange in the application
     * information entering process
     * @param nJobSeekerThree The information from the third stage in the application
     * information 
     * @return True is all data is VALID and validates correctly. False if something
     * is wrong. Data will only be entered into the database if this returns true.
     */
    public boolean addJobSeeker(
            NewJobSeekerStageOneDTO nJobSeekerOne,
            NewJobSeekerStageTwoDTO nJobSeekerTwo, 
            NewJobSeekerStageThreeDTO nJobSeekerThree) {
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<NewJobSeekerStageOneDTO>> errorsOne = validator.validate(nJobSeekerOne);
        Set<ConstraintViolation<NewJobSeekerStageTwoDTO>> errorsTwo = validator.validate(nJobSeekerTwo);
        Set<ConstraintViolation<NewJobSeekerStageThreeDTO>> errorsThree = validator.validate(nJobSeekerThree);
        
        if (errorsOne.isEmpty() && errorsTwo.isEmpty() && errorsThree.isEmpty()) {
        
            Person person = new Person();
            person.setEmailAdress(nJobSeekerOne.getEMail());
            person.setFirstName(nJobSeekerOne.getFirstName());
            person.setLastName(nJobSeekerOne.getLastName());

            Account acc = new Account();
            acc.setUserName(person.getFirstName()+person.getLastName()+(long)(Math.random()*Long.MAX_VALUE));
            acc.setUserPassword((long)(Math.random()*Long.MAX_VALUE) + "" + (long)(Math.random()*Long.MAX_VALUE)+ "" + (long)(Math.random()*Long.MAX_VALUE));     

            Jobseeker js = new Jobseeker();
            js.setAccount(acc);

            Jobapplication ja = new Jobapplication(); 
            ja.setAccepted(false);
            ja.setDateOfRegistration(new Date());
            
            List<Competencecategory> realCompetencecategories = dao.getAllCompetenceCategories(); 
            
            List<Competence> competences = nJobSeekerTwo.getCompetenceList();
            for (Competence comp : competences) {
                for (Competencecategory cat : realCompetencecategories) {
                    if (comp.getCategoryName().equals(cat.getName())) {
                        comp.setCategory(cat);
                        break;
                    }
                }
            }

            List<Timeperiod> tps = new LinkedList<Timeperiod>();

            for (DateAvailabilityDTO da : nJobSeekerThree.getDateAvailabilityList()) {
                Timeperiod tp = new Timeperiod();
                tp.setEndDate(da.getEndDateAsDate());
                tp.setStartDate(da.getStartDateAsDate());

                tps.add(tp);
            }

            dao.addJobSeeker(person, acc, js, ja, competences, tps);


            return true;
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.validationFailed();
            
            for (ConstraintViolation<NewJobSeekerStageOneDTO> error : errorsOne) {
                fc.addMessage("validationErrors", new FacesMessage(error.getMessage()));
            }
            
            for (ConstraintViolation<NewJobSeekerStageTwoDTO> error : errorsTwo) {
                fc.addMessage("validationErrors", new FacesMessage(error.getMessage()));
            }
            
            for (ConstraintViolation<NewJobSeekerStageThreeDTO> error : errorsThree) {
                fc.addMessage("validationErrors", new FacesMessage(error.getMessage()));
            }
            
            logger.log(Level.INFO, "Validation failed");
            return false;
        }
    }
    
    /**
     * Approves a jobseeker, setting the jobapplication status flag to true.
     * @param userName the jobseeker to set.
     * @return true if successful.
     */
    public boolean approveJobSeeker(String userName)
    {
        return dao.setApproveJobSeeker(userName, Boolean.TRUE);
    }
    
    /**
     * Us approves a jobseekerm setting the job application status flag to false
     * @param userName The user to set.
     * @return True if success ful.
     */
    public boolean unApproveJobSeeker(String userName)
    {
        return dao.setApproveJobSeeker(userName, Boolean.FALSE);
    }
}
