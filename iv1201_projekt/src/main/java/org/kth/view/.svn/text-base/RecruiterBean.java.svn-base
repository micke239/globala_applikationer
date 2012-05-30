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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import org.kth.DTO.ApplicationRowDTO;
import org.kth.DTO.FullJobapplicationDTO;
import org.kth.controller.StatefulController;

/**
 * The bean in charge of the recruiter_stage1 and recruiter_stage2-pages.
 *
 * @author Nikolai Padyukov
 */
@Named(value = "recruiter")
@RequestScoped
public class RecruiterBean {

    @Inject
    private StatefulController controller;
    private boolean startDateEnabled;
    private int startDateDay;
    private String startDateMonth;
    private int startDateYear;
    private boolean endDateEnabled;
    private int endDateDay;
    private String endDateMonth;
    private int endDateYear;
    private boolean regDateEnabled;
    private int regDateDay;
    private String regDateMonth;
    private int regDateYear;
    private final int MAX_ITEMS_SHOWN = 100;
    private int itemsShown = 10;
    private String chosenUser;
    private int maxPageCount;
    private String competence;
    private String firstName;
    private String lastName;
    private List<String> dayList = new ArrayList<String>();
    private List<String> monthList = new ArrayList<String>();
    private List<String> yearList = new ArrayList<String>();
    private List<String> competenceList;

    /**
     * @return  (String) the current Competence
     */
    public String getCompetence() {
        return competence;
    }

    /** 
     * @param competence    New 'competence' value taken from 'competenceList'
     */
    public void setCompetence(String competence) {
        this.competence = competence;
    }

    /**
     * @param competenceList    New 'competenceList' to use when displaying the
     * competence list in the JSF page
     */
    public void setCompetenceList(List<String> competenceList) {
        this.competenceList = competenceList;
    }

    /**
     * @return      (String) the firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName    New First Name from JSF page
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return (String) the lastName field
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName  new Last Name from JSF page
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return  integer value of RegDateDay
     */
    public int getRegDateDay() {
        return regDateDay;
    }

    /**
     * @param regDateDay    new Registration Date Day
     */
    public void setRegDateDay(int regDateDay) {
        this.regDateDay = regDateDay;
    }

    /**
     * @return (String) value of RegDateMonth 
     */
    public String getRegDateMonth() {
        return regDateMonth;
    }

    /**
     * @param regDateMonth  new Registration Date Month
     */
    public void setRegDateMonth(String regDateMonth) {
        this.regDateMonth = regDateMonth;
    }

    /**
     * @return integer value of RegDateYear
     */
    public int getRegDateYear() {
        return regDateYear;
    }

    /**
     * @param regDateYear   new Registration Year Month
     */
    public void setRegDateYear(int regDateYear) {
        this.regDateYear = regDateYear;
    }

    /**
     * @return integer value of EndDateDay
     */
    public int getEndDateDay() {
        return endDateDay;
    }

    /**
     * @param endDateDay    new End Date Day
     */
    public void setEndDateDay(int endDateDay) {
        this.endDateDay = endDateDay;
    }

    /**
     * @return (String) value of EndDateMonth
     */
    public String getEndDateMonth() {
        return endDateMonth;
    }

    /**
     * @param endDateMonth new End Date Month
     */
    public void setEndDateMonth(String endDateMonth) {
        this.endDateMonth = endDateMonth;
    }

    /**
     * @return  integer value of EndDateYear
     */
    public int getEndDateYear() {
        return endDateYear;
    }

    /**
     * @param endDateYear new End Date Year
     */
    public void setEndDateYear(int endDateYear) {
        this.endDateYear = endDateYear;
    }

    /**
     * @return integer value of Start Date Day
     */
    public int getStartDateDay() {
        return startDateDay;
    }

    /**
     * @param startDateDay new value of Start Date Day
     */
    public void setStartDateDay(int startDateDay) {
        this.startDateDay = startDateDay;
    }

    /**
     * @return (String) value of StartDateMonth
     */
    public String getStartDateMonth() {
        return startDateMonth;
    }

    /**
     * @param startDateMonth new value of Start Date Month
     */
    public void setStartDateMonth(String startDateMonth) {

        this.startDateMonth = startDateMonth;
    }

    /**
     * @return integer value of StartDateYear
     */
    public int getStartDateYear() {
        return startDateYear;
    }

    /**
     * @param startDateYear new value of Start Date Year
     */
    public void setStartDateYear(int startDateYear) {
        this.startDateYear = startDateYear;
    }

    /**
     * @return String username of the currently chosen user. 
     */
    public String getChosenUser() {
        return chosenUser;
    }

    /**
     * Sets the currently chosen user.
     * @param chosenUser String username of the user to be chosen. Sent by commadnlink from JSF-page.
     */
    public void setChosenUser(String chosenUser) {
        this.chosenUser = chosenUser;
    }

    /**
     * @return value of itemsShown field.
     */
    public int getItemsShown() {
        return this.itemsShown;
    }

    /**
     * Sets the itemsShown field.
     * @param itemsShown    items to be show. Will not accept anything larger than MAX_ITEMS_SHOWN
     */
    public void setItemsShown(int itemsShown) {
        if (0 < itemsShown && itemsShown < MAX_ITEMS_SHOWN) {
            this.itemsShown = itemsShown;
        } else if (itemsShown > MAX_ITEMS_SHOWN) {
            this.itemsShown = MAX_ITEMS_SHOWN;
        }

    }

    /**
     * @return boolean flag. True if EndDate is enabled, false if disabled.
     */
    public boolean getEndDateEnabled() {
        return endDateEnabled;
    }

    /**
     * Sets the endDateEnabled flag.
     * @param endDateEnabled bool, true for enabled, false for disabled
     */
    public void setEndDateEnabled(boolean endDateEnabled) {
        this.endDateEnabled = endDateEnabled;
    }

    /**
     * @return boolean flag. True if RegDate is enabled, false if disabled.
     */
    public boolean getRegDateEnabled() {
        return regDateEnabled;
    }

    /**
     * Sets the regDateEnabled flag.
     * @param regDateEnabled bool, true for enabled, false for disabled
     */
    public void setRegDateEnabled(boolean regDateEnabled) {
        this.regDateEnabled = regDateEnabled;
    }

    /**
     * @return boolean flag. True if StartDate is enabled, false if disabled.
     */
    public boolean getStartDateEnabled() {
        return startDateEnabled;
    }

    /**
     * Sets the startDateEnabled flag.
     * @param startDateEnabled bool, true for enabled, false for disabled
     */
    public void setStartDateEnabled(boolean startDateEnabled) {
        this.startDateEnabled = startDateEnabled;
    }

    /**
     * Returns value of the current page int he search-index. Held by controller.
     * @return int value, index of page in search.
     */
    public int getPageCounter() {
        return this.controller.getSearchPageCounter();
    }

    /**
     * Returns the maximum page count that is allowed. This is to
     * stop the view from loading search-results that do not exist.
     * @return  Maximum allowed page count.
     */
    public int getMaxPageCount() {
        return this.maxPageCount;
    }

    /**
     * Returns a list of Competences. Loads the list from the controller
     * (unless it is already loaded) and adds the "All" element to it.
     * @return List of Competences for JSF menu.
     */
    public List<String> getCompetenceList() {
            this.competenceList = controller.getAllCompetenceCategories();
            this.competenceList.add(0, "All");
        
        return competenceList;
    }

    /**
     * @return List of integer values to represent the date of the month.
     */
    public List getDayList() {
        if (this.dayList.isEmpty()) {
            for (int i = 1; i < 32; i++) {
                this.dayList.add(String.valueOf(i));
            }
        }
        return this.dayList;
    }

    /**
     * @return List of month
     */
    public List<String> getMonthList() {
        ResourceBundle bundle = ResourceBundle.getBundle("properties.months", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
        if (monthList.isEmpty()) {
            this.monthList.add(bundle.getString("Jan"));
            this.monthList.add(bundle.getString("Feb"));
            this.monthList.add(bundle.getString("Mar"));
            this.monthList.add(bundle.getString("Apr"));
            this.monthList.add(bundle.getString("May"));
            this.monthList.add(bundle.getString("Jun"));
            this.monthList.add(bundle.getString("Jul"));
            this.monthList.add(bundle.getString("Aug"));
            this.monthList.add(bundle.getString("Sep"));
            this.monthList.add(bundle.getString("Oct"));
            this.monthList.add(bundle.getString("Nov"));
            this.monthList.add(bundle.getString("Dec"));
        }

        return monthList;
    }

    /**
     * @return list of integer values representing years.
     */
    public List getYearList() {
        if (this.yearList.isEmpty()) {
            for (int i = 0; i < 50; i++) {
                this.yearList.add(String.valueOf(1980 + i));
            }
        }
        return this.yearList;
    }

    /**
     * Returns a list of app
     * 
     * @return list of applicationRowDTOs to show in current view.
     */
    public List<ApplicationRowDTO> getApplicationList() {

        List applicationList = controller.getApplications();

        this.maxPageCount = applicationList.size() / this.itemsShown;
        if (applicationList.size() <= this.itemsShown) {
            return applicationList;
        } else {
            int pageCount = this.controller.getSearchPageCounter();
            List<ApplicationRowDTO> returnList;
            if (pageCount == this.maxPageCount) {
                returnList = applicationList.subList(this.itemsShown * pageCount, applicationList.size());
            } else {
                returnList = applicationList.subList(this.itemsShown * pageCount, this.itemsShown * pageCount + this.itemsShown);
            }
            return returnList;
        }
    }

    /**
     * @return a fullJobApplicationDTO that contains all information needed by recruiter_stage2
     */
    public FullJobapplicationDTO getCurrentApplication() {
        return this.controller.getCurrentApplication();
    }

    /**
     * Method called by commandButton "previousPage". Calls controller-method
     * to decrementSearchPageCounter. Page will automatically reload and load
     * previous results, if any.
     */
    public void previousPage() {
        this.controller.decrementSearchPageCounter();
    }

    /**
     * Method called by commandButton "nextPage". Calls controller-method to 
     * incrementSearchPageCounter provided that the page count does not exceed
     * this.maxPageCount.
     */
    public void nextPage() {
        if (this.controller.getSearchPageCounter() != this.maxPageCount) {
            this.controller.incrementSearchPageCounter();
        }

    }

    /**
     * Method called by commandButton "conductSearch". Calls controller-method
     * to conduct a search with parameters from the JSF page.
     */
    public void conductSearch() {

        //Conduct checks to see if dates should be enabled.
        if (!this.startDateEnabled) {
            this.startDateDay = 0;
            this.startDateMonth = null;
            this.startDateYear = 0;
        }

        if (!this.endDateEnabled) {
            this.endDateDay = 0;
            this.endDateMonth = null;
            this.endDateYear = 0;
        }

        if (!this.regDateEnabled) {
            this.regDateDay = 0;
            this.regDateMonth = null;
            this.regDateYear = 0;
        }

        this.controller.conductSearch(startDateDay, startDateMonth, startDateYear, endDateDay, endDateMonth, endDateYear, regDateDay, regDateMonth, regDateYear, competence, firstName, lastName);

    }

    /**
     * Method called by clicking on a Name in the search results. Will cause a
     * redirect to recruiter_stage2 with that user as the chosen applicant.
     */
    public void chooseApplication() {
        this.controller.chooseApplication(this.chosenUser);
    }

    /**
     * Method called by commandButton "PDF". Generates a PDF-file of the application in recruiter_stage2 
     * TODO: better generated file name. 
     * @throws IOException 
     */
    public void downloadPdf() throws IOException {

        //Create the pdf
        byte[] pdfData = controller.createPdf();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        // Initialize response.
        response.reset();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=\"applicationReport.pdf\"");

        // Write file to response.
        OutputStream output = response.getOutputStream();
        output.write(pdfData);
        output.close();

        // Inform JSF to not take the response in hands.
        facesContext.responseComplete();
    }

    /**
     * toggles approval of the current jobSeeker in recruiterStage2. 
     */
    public void approveJobSeeker() {

        this.controller.approveJobSeeker(this.chosenUser);
    }

    public void unApproveJobSeeker() {
        this.controller.unApproveJobSeeker(this.chosenUser);
    }

    /**
     * Indicates if stage 1 in the recruiter process is done
     * Used to control the flow in the recruiter process.
     * @return True if stage 1 is done, false otherwise.
     */
    public boolean getDonestage1() {
        return controller.isRecruiterStage1Done();
    }
}
