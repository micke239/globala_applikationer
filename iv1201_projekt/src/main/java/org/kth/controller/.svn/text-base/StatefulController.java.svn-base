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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.kth.DTO.ApplicationRowDTO;
import org.kth.DTO.FullJobapplicationDTO;
import org.kth.model.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * The stateful controller is the main facade against the model and business
 * classes. It is sessing scoped meaning that THIS class holds variables
 * that define state for each user. Each user has its own instance of
 * the stateful controller.
 * 
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class StatefulController implements Serializable{
    @Inject private LoginManager loginManager;
    @Inject private CompetenceManager competenceManager;
    @Inject private AccountManager accountManager;
    @Inject private SearchManager searchManager;
    
    
    private boolean loggedInAsRecruiter;
    private boolean loggedInAsJobSeeker;
    
    private int jobSeekerStage = 0;
    private boolean recruiterStage1Done = false;
    
    private String loggedInRecruiter = "Not logged in";
    
    private SearchParameters currentSearch;
    private List<ApplicationRowDTO> searchResults = new ArrayList<ApplicationRowDTO>();
    private int searchPageCounter = 0;
    private FullJobapplicationDTO chosenApplication = new FullJobapplicationDTO();
    
    private NavigationController navigator = new NavigationController();
    
    /**
     * Adds a recruiter to the model.
     * @return Whether the operation was successful or not.
     */
    public boolean addRecruiter() {
        return true;
    }
    
    /**
     * Tries to authenticate the current session-user as a Recruiter.
     */
    public void login(String user, String pass) {
        boolean retval;
        retval = loginManager.login(user, pass);

            if (retval)
            {
                this.navigator.directRecruiterStart();
                this.loggedInRecruiter = user;
                this.loggedInAsRecruiter = true;
            }
            else
            {
                this.navigator.directWrongPass();
            }      
    }
    
    /**
     * Check if someone is logged in as a recruiter
     * @return true if logged in false otherwise
     */
    public boolean isLoggedInAsRecruiter()
    {
        return this.loggedInAsRecruiter;
    }
    
    /**
     * Chech to see if someone is logged in as a jobSeeker
     * @return true if logged in, false otherwise
     */
    public boolean isLoggedInAsJobSeeker()
    {
        return this.loggedInAsJobSeeker;
    }
    
    /**
     * Logs out the user, ending the current session.
     */
    public void logOut() 
    {
        this.loggedInAsRecruiter = false;
        this.loggedInAsJobSeeker = false;
    
        this.jobSeekerStage = 0;
        this.recruiterStage1Done = false;
    
        this.loggedInRecruiter = "Not logged in";
    
        this.currentSearch = null;
        this.searchResults = new ArrayList<ApplicationRowDTO>();
        this.searchPageCounter = 0;

        //TODO: fixa to a real security solution
        this.chosenApplication = new FullJobapplicationDTO();
        this.navigator.directIndex();
    }

    /**
     * Returns the keys for all the competence catagories from database
     * These keys should be used together with the porpertie files to ensure
     * correct language is displayed.
     * @return A list of keys that should be mapped against a property
     */
    public List<String> getAllCompetenceCategories() {        
        return competenceManager.getAllCompetenceCategories();
    }
    
    /**
     * Searches the database based on the provided parameters
     * Saves the most recent state in this controller itself.
     * This searchresult is kept until a new search is done.
     * Results can be retrived with the method getApplications()
     * 
     * @param startDateDay The start Date day
     * @param startDateMonth That start Date month
     * @param startDateYear The start Date Year
     * @param endDateDay The end Date day
     * @param endDateMonth The end Date month
     * @param endDateYear The end Date your
     * @param regDateDay The date of registration day
     * @param regDateMonth the date of registration month
     * @param regDateYear The date of registration year
     * @param competence The competence you are looking for
     * @param firstName Search for specific application using first name
     * @param lastName  Search for specific application using last name
     */
    public void conductSearch(  int startDateDay, String startDateMonth, int startDateYear,
                                int endDateDay, String endDateMonth, int endDateYear, 
                                int regDateDay, String regDateMonth, int regDateYear, 
                                String competence, String firstName, String lastName){
        
        
        this.currentSearch = new SearchParameters(startDateDay, startDateMonth, startDateYear,
                                endDateDay, endDateMonth, endDateYear, 
                                regDateDay, regDateMonth, regDateYear, 
                                competence, firstName, lastName);
         
        
        this.searchResults = this.searchManager.conductSearch(currentSearch);
        this.searchResults.add(new ApplicationRowDTO("", "", "End of list!", ""));
    }
    
    /**
     * increments the page counter to keep track of the results view
     * Used when user presses next on the results view
     */
    public void incrementSearchPageCounter(){
        this.searchPageCounter++;
    }
    
    /**
     * decrements the page counter to keep track of the results view
     * Used when the user presses pervious on the results view.
     */
    public void decrementSearchPageCounter(){
        if(this.searchPageCounter > 0){
            this.searchPageCounter--;
        }
    }
    
    /**
     * Returns the page counter that belongs to the recruiter bean
     * @return The current page
     */
    public int getSearchPageCounter(){
        return this.searchPageCounter;
    }

    /**
     * Initally this list is empty
     * @return The current list of search applications
     */
    public List<ApplicationRowDTO> getApplications(){
        return this.searchResults;
    }

    /**
     * Returns the real name of a logged in Recruiter
     * @return The real name of a recruiter
     */
    public String getRealName()
    {
        return loginManager.getUserRealName(this.loggedInRecruiter);
    }

    /**
     * Method called to start the application creation process.
     */
    public void createApplication()
    {
        this.loggedInAsJobSeeker = true;
        this.jobSeekerStage++;
        this.navigator.directJobSeekerStart();
    }

    /**
     * @return the jobSeekerStage
     */
    public int getJobSeekerStage()
    {
        return jobSeekerStage;
    }

    /**
     * Navigation wrapper method to different job seeker stages
     * @param stage an int between 1-4
     * 
     * TODO: Error control, for invalid stages + refactor name
     */
    public void goToStage(int stage)
    {
        this.jobSeekerStage = stage;
        this.navigator.directJobSeekerStage(stage);
    }
    
    /**
     * Method run when an application is chosen from list of applications
     * The chosen application is saved in the StatefulController  
     * @param userName The username of the chosen application
     */
    public void chooseApplication(String userName){
        this.chosenApplication = this.searchManager.getApplicationByUsername(userName);
        this.recruiterStage1Done = true;
        this.navigator.directRecruiterApplicationView();
    }
    
    /**
     * Create a pdf from the currently selected application selected
     * @return a byte array containing the bytes of the created pdf.
     */
    public byte[] createPdf()
    {
        PDFManager pdf = new PDFManager(this.getCurrentApplication());
        return pdf.createPdf();
    }
    
    /**
     * 
     * @return The currently chosen
     */
    public FullJobapplicationDTO getCurrentApplication(){
        return this.chosenApplication;
    }

    /**
     * Used to avoid hard linking to recruiter stage 2
     * 
     * @return the recruiterStage1Done
     */
    public boolean isRecruiterStage1Done()
    {
        return recruiterStage1Done;
    }

    /**
     * Mothed called when a job application is finished. Logs out the "user"
     * and redirects the user to the finished page.
     */
    public void jobSeekerDone() {
        loggedInAsJobSeeker = false;
        this.navigator.directJobSeekerDone();
    }

    public void unApproveJobSeeker(String chosenUser)
    {
        if (accountManager.unApproveJobSeeker(chosenUser))
        {
            //update data.
            this.chosenApplication = this.searchManager.getApplicationByUsername(chosenUser);
        }
    }
    
    /**
     * Approves a JobSeeker..
     */
    public void approveJobSeeker(String userName) {
        if (accountManager.approveJobSeeker(userName))
        {
            //update data.
            this.chosenApplication = this.searchManager.getApplicationByUsername(userName);
        }
        
    }
}
