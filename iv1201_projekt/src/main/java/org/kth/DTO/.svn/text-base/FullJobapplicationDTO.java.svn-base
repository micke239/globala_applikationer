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

package org.kth.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;


/**
 * Data Object that contains all information required for displaying a users 
 * full application
 * 
 * @author Nikolai Padyukov
 */
public class FullJobapplicationDTO {
    
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfRegistration;
    private String accepted;
    private List<EntityTimePeriodDTO> timePeriods;
    private List<EntityCompetenceDTO> competenceList;
    
    
    /**
     * Empty Constructor
     */
    public FullJobapplicationDTO(){
        
    }
    
    /**
     * Default constructor for FullJobApplicationDTO
     * @param userName              String                  the users username
     * @param firstName             String                  the users first name
     * @param lastName              String                  the users last name
     * @param email                 String                  the users email
     * @param dateOfRegistration    String                  the users date of registration as a String
     * @param accepted              String                  the state of the users application. "Yes" if accepted, "No" if not.
     * @param timePeriods           List<TimePeriodDTO>     a list of the users available timeperiods.
     * @param competenceList        List<CompetenceDTO>     a list of the users competence
     */
    public FullJobapplicationDTO(String userName, String firstName, String lastName, String email, String dateOfRegistration, String accepted, List<EntityTimePeriodDTO> timePeriods, List<EntityCompetenceDTO> competenceList) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfRegistration = dateOfRegistration;
        this.accepted = accepted;
        this.timePeriods = timePeriods;
        this.competenceList = competenceList;
    }
    
    /**
     * @return      state of users application. "Yes" if accepted, "No" if not.
     */
    public String getAccepted() {
        return accepted;
    }

    /**
     * @return      list of users competence.
     */
    public List<EntityCompetenceDTO> getCompetenceList() {
        return competenceList;
    }
    
    /**
     * @return      list of users competence translated correctly
     */
    public List<EntityCompetenceDTO> getLocaleCompetenceList() {
        
        List<EntityCompetenceDTO> newList = new ArrayList<EntityCompetenceDTO>();
        ResourceBundle bundle = ResourceBundle.getBundle("properties.category", 
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
        for (EntityCompetenceDTO c : this.competenceList)
            //n months, comment, n months
        {
            CompetenceDTO comp = new CompetenceDTO(bundle.getString(c.getCategoryName())
                    ,c.getComment(),c.getNumberOfMonths());
            newList.add(comp);
        }
        
        return newList;
    }

    /**
     * @return      users dateOfRegistration in "yyyy-mm-dd" format.
     */
    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    /**
     * @return      users email-adress
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return      users first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return      users last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return      list of users available time periods
     */
    public List<EntityTimePeriodDTO> getTimePeriods() {
        return timePeriods;
    }

    /**
     * @return      Users username
     */
    public String getUserName() {
        return userName;
    }
}
