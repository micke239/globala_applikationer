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
package org.kth.controller;


import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.kth.DTO.*;
import org.kth.model.AccountManager;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 *
 * A temporary help controller for the job application creation process
 * This class exists to ensure higher cohesion in the StatefulController
 * 
 * Non of the methods makes any changes to the database
 * 
 * @author Mikael Nilsson
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class NewJobSeekerController {
    @Inject
    private AccountManager accountManager;
    
    private NewJobSeekerStageOneDTO nJobSeekerOne = new NewJobSeekerStageOneDTO();
    private NewJobSeekerStageTwoDTO nJobSeekerTwo = new NewJobSeekerStageTwoDTO();
    private NewJobSeekerStageThreeDTO nJobSeekerThree = new NewJobSeekerStageThreeDTO();
   
    
    /**
     * Setter for first name.
     * @param firstName The first name of the job seeker.
     */
    public void setFirstName(String firstName) {
        nJobSeekerOne.setFirstName(firstName);
    }
    
    /**
     * Setter for last name.
     * @param lastName The last name of the job seeker.
     */
    public void setLastName(String lastName) {
        nJobSeekerOne.setLastName(lastName);
    }
    
    /**
     * Setter for e-mail.
     * @param eMail The E-Mail of the job seeker.
     */
    public void setEMail(String eMail) {
        nJobSeekerOne.setEMail(eMail);
    }
    
    /**
     * Getter of e-mail
     * @return The E-Mail of the job seeker.
     */
    public String getEMail() {
        return nJobSeekerOne.getEMail();
    }
    
    /**
     * Getter for last name.
     * @return The last name of the job seeker.
     */
    public String getLastName() {
        return nJobSeekerOne.getLastName();
    }
    
    /**
     * Getter for first name.
     * @return  The first name of the job seeker.
     */
    public String getFirstName() {
        return nJobSeekerOne.getFirstName();
    }

    /**
     * Removes a competence from the temporary data structure
     * @param index The index to remove
     */
    public void removeCompetence(int index) {
        nJobSeekerTwo.removeCompetence(index);
    }

    /**
     * @return The current working list of competences
     */
    public List<EntityCompetenceDTO> getCompetenceList() {
        return nJobSeekerTwo.getLocaleCompetenceList();
    }

    /**
     * Adds a new competence to the working list of competences
     * @param competenceCategory The category of the competence
     * @param comment An optional comment about the competence
     * @param numberOfMonths The number of months of experience
     * 
     */
    public void addCompetence(String competenceCategory, String comment, int numberOfMonths) {
        nJobSeekerTwo.addCompetence(competenceCategory, comment, numberOfMonths);
    }

    /**
     * @return The list of date pairs when the job applicant can work
     */
    public List<DateAvailabilityDTO> getDateAvailabilityList() {
        return nJobSeekerThree.getDateAvailabilityList();
    }

    /**
     * Adds a new date availability time period to the working set of data
     * @param availability 
     */
    public void addDateAvailability(DateAvailabilityDTO availability) {
        nJobSeekerThree.addDateAvailability(availability);
    }
    
    /**
     * Removes a data avialability with the given index
     * @param index The index to remove
     */
    public void removeDateAvailability(int index) {
        nJobSeekerThree.removeDateAvailability(index);
    }
    
    /**
     * Removes the lateast entered date availability 
     */
    public void removeLatestDateAvailability() {
        nJobSeekerThree.removeLatestDateAvailability();
    }
    
    /**
     * Validation method using Bean validation
     * Validates the data entered in stage one
     * @return A set with the results of the validation
     */
    public Set<ConstraintViolation<NewJobSeekerStageOneDTO>> validateStageOne() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
      
        return validator.validate(nJobSeekerOne);
    }
    
    /**
     * Validation method using Bean validation
     * Validates the data entered in stage two
     * @return A set with the results of the validation
     */
    public Set<ConstraintViolation<NewJobSeekerStageTwoDTO>> validateStageTwo() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
      
        return validator.validate(nJobSeekerTwo); 
    }
    
    /**
     * Validation method using Bean validation
     * Validates the data entered in stage two
     * @return A set with the results of the validation
     */
    public Set<ConstraintViolation<NewJobSeekerStageThreeDTO>> validateStageThree() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
      
        return validator.validate(nJobSeekerThree); 
    }
    
    /**
     * Removes the last competence from the temporary list of competences
     */
    public void removeLastCompetence() {
        nJobSeekerTwo.removeLastCompetence();
    }


    /**
     * Adds a job seeker to the model.
     * @return Whether the operation was successful or not.
     */
    public boolean addJobSeeker() 
    {
        return accountManager.addJobSeeker(nJobSeekerOne, nJobSeekerTwo, nJobSeekerThree);
    }

    public void clearDTO() {
        nJobSeekerOne = new NewJobSeekerStageOneDTO();
        nJobSeekerTwo = new NewJobSeekerStageTwoDTO();
        nJobSeekerThree = new NewJobSeekerStageThreeDTO();
    }
}
