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

package org.kth.view;

import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import org.apache.log4j.Logger;
import org.kth.DTO.DateAvailabilityDTO;
import org.kth.DTO.NewJobSeekerStageOneDTO;
import org.kth.DTO.NewJobSeekerStageThreeDTO;
import org.kth.DTO.NewJobSeekerStageTwoDTO;
import org.kth.controller.NewJobSeekerController;
import org.kth.controller.StatefulController;


/**
 * JobSeekerBean is responsible for the jobseeker pagees and its process
 * 
 * All beans are made to contain as little code as possible, and mearly act as an
 * interface to the jsf page from the rest of the application.
 */
@Named(value = "jobSeeker")
@RequestScoped
public class JobSeekerBean {
    private static final Logger logger = Logger.getLogger(JobSeekerBean.class);

    @Inject private StatefulController controller;
    @Inject private NewJobSeekerController nJobSeekerController;
    
    private String competenceCategory = "";
    private int numberOfMonths = 0;
    private int fromYear = 0;
    private String fromMonth = "";
    private int fromDay = 0;
    private int toYear = 0;
    private String toMonth = "";
    private int toDay = 0;

    /**
     * Get the strart day as an int
     * @return An int representing that start day
     */
    public int getFromDay() {
        return fromDay;
    }

    /**
     * Set the start day
     * @param fromDay the day to set
     */
    public void setFromDay(int fromDay) {
        this.fromDay = fromDay;
    }

    /**
     * Get the starting month
     * @return a Month as a string representation
     */
    public String getFromMonth() {
        return fromMonth;
    }

    /**
    * set the staring month. String is the locale displayed to the user.
    * @param fromMonth The month to set.
    */
    public void setFromMonth(String fromMonth) {
        this.fromMonth = toMonthKey(fromMonth);
    }

    /**
     * Get the starting year.
     * @return an int with the starting year (yyyy).
     */
    public int getFromYear() {
        return fromYear;
    }

    /**
     * Set the starting yeat
     * @param fromYear A year on the format YYYY
     */
    public void setFromYear(int fromYear) {
        this.fromYear = fromYear;
    }

    /**
     * Get the ending day. as an int between 1-31
     * @return the "to day".
     */
    public int getToDay() {
        return toDay;
    }

    /**
     * set the ending day.
     * @param toDay An int representing the day to set.
     */
    public void setToDay(int toDay) {
        this.toDay = toDay;
    }

    /**
     * Get the ending month as a string
     * @return the end month string
     */
    public String getToMonth() {
        return toMonth;
    }

    /**
     * Set the ending month
     * @param toMonth 
     */
    public void setToMonth(String toMonth) {
        this.toMonth = toMonthKey(toMonth);
    }

    /**
     * Get the ending year
     * @return an Int on the format YYYY
     */
    public int getToYear() {
        return toYear;
    }

    /**
     * set the ending year
     * @param toYear An int representing a year on the format YYYY
     */
    public void setToYear(int toYear) {
        this.toYear = toYear;
    }

    /**
     * Get the string representation of the current competence category.
     * @return the competence category currently selected.
     */
    public String getCompetenceCategory() {
        return competenceCategory;
    }

    public void setCompetenceCategory(String competenceCategory) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle categoryBundle = ResourceBundle.getBundle("properties.category",
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
        ResourceBundle validationBundle = ResourceBundle.getBundle("ValidationMessages",
                FacesContext.getCurrentInstance().getViewRoot().getLocale());

        boolean broke = false;

        for (String key : categoryBundle.keySet()) {
            if (categoryBundle.getString(key).equals(competenceCategory)) {
                competenceCategory = key;
                broke = true;
                break;
            }
        }

        if (!broke) {
            fc.validationFailed();
            FacesMessage message = new FacesMessage(validationBundle.getString("invalid_competence"));
            fc.addMessage("validationErrors", message);
        }

        this.competenceCategory = competenceCategory;
    }

    /**
     * Getter for thte number of months jsf tag
     * @return an int representing the number of months
     */
    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    /**
     * Sets the number of months of the corrosponding jsf tag.
     * @param numberOfMonths an int between 1 and 12.
     */
    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    /**
     * Gets the email adress tied to the corrosponding jsf field.
     * @return An email adress as a string
     */
    public String geteMailAddress() {
        return nJobSeekerController.getEMail();
    }

    /**
     * Sets the email adress connected to the jsf field 
     * @param eMailAddress An email adress as a string
     */
    public void seteMailAddress(String eMailAddress) {
        nJobSeekerController.setEMail(eMailAddress);
    }

    /**
     * Get the first name connected to a jsf field.
     * @return the first name of this application.
     */
    public String getFirstName() {
        return nJobSeekerController.getFirstName();
    }

    public void setFirstName(String firstName) {

        nJobSeekerController.setFirstName(firstName);
    }

    public String getLastName() {
        return nJobSeekerController.getLastName();
    }

    public void setLastName(String lastName) {
        nJobSeekerController.setLastName(lastName);
    }

    public void removeCompetence(int index) {
        nJobSeekerController.removeCompetence(index);
    }

    public List getCompetenceList() {
        List a = nJobSeekerController.getCompetenceList();
    
        return nJobSeekerController.getCompetenceList();
    }

    /**
     * Adds a competende to the working set of data. Also validates the input.
     * 
     * Will display error messages to the user if something is worng.
     */
    public void addCompetence() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!fc.isValidationFailed()) {
            nJobSeekerController.addCompetence(this.competenceCategory, "", this.numberOfMonths);
            Set<ConstraintViolation<NewJobSeekerStageTwoDTO>> violations =
                    nJobSeekerController.validateStageTwo();

            for (ConstraintViolation<NewJobSeekerStageTwoDTO> validation : violations) {
                fc.validationFailed();

                fc.addMessage("validationErrors", new FacesMessage(validation.getMessage()));
            }

            if (fc.isValidationFailed()) {
                nJobSeekerController.removeLastCompetence();
            }
        }

        this.competenceCategory = "";
        this.numberOfMonths = 0;
    }

    /**
     * Get all the competence gategorys from the database. Used to populate the
     * combobox.
     * @return A list with all competenceCatagories as strings.
     */
    public List<String> getAllCompetenceCategories() {
        return controller.getAllCompetenceCategories();
    }

    /**
     * Returns the chooseable years. Used to populate the combobox.
     * @return a list of years spanning from the current year and ten years ahead.
     */
    public int[] getYears() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date());
        int currentYear = gc.get(Calendar.YEAR);
        
        int[] years = new int[10];
        for (int i = 0; i < 10; i++) {
            years[i] = i + currentYear;
        }
        
        return years;
    }

    /**
     * Createas a local version of months names.  Used to populate the comboboxes.
     * @return A string array with localized month names.
     */
    public String[] getMonths() {
        ResourceBundle bundle = ResourceBundle.getBundle("properties.months", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
        String[] monthList = new String[12];
        monthList[0] = bundle.getString("Jan");
        monthList[1] = bundle.getString("Feb");
        monthList[2] = bundle.getString("Mar");
        monthList[3] = bundle.getString("Apr");
        monthList[4] = bundle.getString("May");
        monthList[5] = bundle.getString("Jun");
        monthList[6] = bundle.getString("Jul");
        monthList[7] = bundle.getString("Aug");
        monthList[8] = bundle.getString("Sep");
        monthList[9] = bundle.getString("Oct");
        monthList[10] = bundle.getString("Nov");
        monthList[11] = bundle.getString("Dec");

        return monthList;
    }

    /**
     * Get an array of the numbers 1-31. Used to populate the day comboboxes.
     * @return an int array
     */
    public int[] getDates() {
        int[] dates = new int[31];
        for (int i = 1; i <= 31; i++) {
            dates[i - 1] = i;
        }

        return dates;
    }

    public List<DateAvailabilityDTO> getDateAvailabilityList() {
        return nJobSeekerController.getDateAvailabilityList();
    }

    /**
     * Adds and validate a Data avilability period to the working set of data.
     * 
     * Displays error messages if something is entered incorrectly.
     */
    public void addDateAvailability() {
        FacesContext fc = FacesContext.getCurrentInstance();

        String from = toDateString(fromYear, fromMonth, fromDay);
        String to = toDateString(toYear, toMonth, toDay);
        DateAvailabilityDTO dadto = new DateAvailabilityDTO(from, to);

        nJobSeekerController.addDateAvailability(dadto);

        Set<ConstraintViolation<NewJobSeekerStageThreeDTO>> violations =
                nJobSeekerController.validateStageThree();

        for (ConstraintViolation<NewJobSeekerStageThreeDTO> validation : violations) {
            fc.validationFailed();

            fc.addMessage("validationErrors", new FacesMessage(validation.getMessage()));
        }

        if (fc.isValidationFailed()) {
            nJobSeekerController.removeLatestDateAvailability();
        }

        fromYear = 0;
        fromMonth = "";
        fromDay = 0;
        toYear = 0;
        toMonth = "";
        toDay = 0;
    }

    /**
     * Removes an entered date avialability with the given index.
     * @param index The index to remove.
     */
    public void removeDateAvailability(int index) {
        nJobSeekerController.removeDateAvailability(index);
    }

    /**
     * Accepts the working set. Method calls made to save information to database.
     */
    public void accept() {

        nJobSeekerController.addJobSeeker();
        if (!FacesContext.getCurrentInstance().isValidationFailed()) {
            controller.jobSeekerDone();
            nJobSeekerController.clearDTO();
        }
    }

    /**
     * Validation method for stepping through the different parts of the job 
     * application process.
     * @param stage The stage to test. 
     */
    public void goToStage(long stage) {
        FacesContext fc = FacesContext.getCurrentInstance();

        if (stage >= 2) {
            Set<ConstraintViolation<NewJobSeekerStageOneDTO>> violations =
                    nJobSeekerController.validateStageOne();

            for (ConstraintViolation<NewJobSeekerStageOneDTO> validation : violations) {
                fc.validationFailed();

                fc.addMessage("validationErrors", new FacesMessage(validation.getMessage()));
            }
        } else if (stage >= 3) {
            Set<ConstraintViolation<NewJobSeekerStageTwoDTO>> violations =
                    nJobSeekerController.validateStageTwo();

            for (ConstraintViolation<NewJobSeekerStageTwoDTO> validation : violations) {
                fc.validationFailed();

                fc.addMessage("validationErrors", new FacesMessage(validation.getMessage()));
            }
        } else if (stage >= 4) {
            Set<ConstraintViolation<NewJobSeekerStageThreeDTO>> violations =
                    nJobSeekerController.validateStageThree();

            for (ConstraintViolation<NewJobSeekerStageThreeDTO> validation : violations) {
                fc.validationFailed();

                fc.addMessage("validationErrors", new FacesMessage(validation.getMessage()));
            }
        }

        if (!fc.isValidationFailed()) {
            controller.goToStage((int) stage);
        }
    }

    /**
     * Get if the user is logged in as a job seeker, meaning that the job seeker
     * has properly started the application process.
     * @return True if logged in, false otherwise.
     */
    public boolean getLoggedin() {
        return controller.isLoggedInAsJobSeeker();
    }

    
    private String toDateString(int year, String month, int day) {
        String sDay = Integer.toString(day);

        if (day < 10) {
            sDay = "0" + sDay;
        }

        return Integer.toString(year) + "-" + month + "-" + sDay;
    }
    
    private String toMonthKey(String month) {
        ResourceBundle bundle = ResourceBundle.getBundle("properties.months", 
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
        for (String key : bundle.keySet()) {
            if (bundle.getString(key).equals(month)) {
                return key;
            }
        }
        
        throw new RuntimeException("Month invalid!!!");
    }
}
