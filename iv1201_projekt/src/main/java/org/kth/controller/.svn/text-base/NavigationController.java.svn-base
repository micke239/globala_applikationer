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

import java.io.IOException;
import javax.faces.context.FacesContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * 
 * The navigation controller contains all hardcoded redirctes needed by the controller
 * This class is instead of navigation rules, and ALL navigation is done through 
 * this class.
 * If pages are added or renamned, changes has to be made in this class
 * 
 * TODO: Add hard linking, => Put all xhtml files in one folder.
 * @author Johan Schedin Jigland
 */
public class NavigationController
{
    private static final Logger logger = Logger.getLogger(NavigationController.class);
    
    /**
     * Creates a new NavigationController
     * This is our alternative to navigation rules
     */
    public NavigationController()
    { }
    
    /**
     * Redirct run when the user specifies the worng unsername/password combination
     * at the login screen
     */
    public void directWrongPass()
    {
        try
        {
           FacesContext.getCurrentInstance().getExternalContext().redirect("wrong_pass.xhtml");    
        } catch (IOException ex)
        {
        logger.log(Level.ERROR, ex.getMessage() + ex.toString());       
        }
    }
    
    /**
     * Redirects back to index from the jobseeker and recruiter pages
     */
    public void directIndex()
    {
         try
        {
           FacesContext.getCurrentInstance().getExternalContext().redirect("../page_login.xhtml");    
        } catch (IOException ex)
        {
            logger.log(Level.ERROR, ex.getMessage() + ex.toString());
        }
    }
    
    /**
     * REdirect to start the recruiting process.
     */
    public void directRecruiterStart()
    {
        try
        {
           FacesContext.getCurrentInstance().getExternalContext().redirect("recruiter/recruiter_stage1.xhtml");    
        } catch (IOException ex)
        {
            logger.log(Level.ERROR, ex.getMessage() + ex.toString());
        }
    }
    
    /**
     * Recirects the user to the second stage of the recruiters viewing process
     */
    public void directRecruiterApplicationView()
    {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("recruiter_stage2.xhtml");

        } catch (IOException ex) {
            logger.log(Level.ERROR, ex.getMessage() + ex.toString());
        }
    }

    /**
     * Directs the user to the initial stage of the add application process
     */
    public void directJobSeekerStart()
    {
        try
        {
        FacesContext.getCurrentInstance().getExternalContext().redirect("jobseeker/jobseeker_stage1.xhtml");        
        } catch (IOException ex)
        {
            logger.log(Level.ERROR, ex.getMessage() + ex.toString());
        }
    }
    
    /**
     * Directs the user to the final page in the jobseeker process.
     */
    public void directJobSeekerDone()
    {
        try
        {
        FacesContext.getCurrentInstance().getExternalContext().redirect("jobseeker_done.xhtml");        
        } catch (IOException ex)
        {
            logger.log(Level.ERROR, ex.getMessage() + ex.toString());
        }
    }
    
    /**
     * Directs the user to the different job seeker stages
     * @param stage The stage to go to, an int between 1 and 4
     * if an invalid parameter is provided, nothing happens.
     */
    public void directJobSeekerStage(int stage)
    {
        try
        {
            switch (stage)
                    {
                case 1:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("jobseeker_stage1.xhtml");
                    break;
                case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("jobseeker_stage2.xhtml");
                    break;
                case 3:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("jobseeker_stage3.xhtml");
                    break;
                case 4:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("jobseeker_stage4.xhtml");
                    break;
                default:
                    break;
            }      
        } catch (IOException ex)
        {
            logger.log(Level.ERROR, ex.getMessage() + ex.toString());
        }
    }
    
    
}

