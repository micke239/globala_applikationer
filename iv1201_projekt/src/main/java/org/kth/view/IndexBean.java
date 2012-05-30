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

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.kth.controller.StatefulController;

/**
 * Handles requests for the application home page.
 * 
 * Handles all login logout logic
 */
@Named(value = "index")
@RequestScoped
public class IndexBean {
    
    @Inject
    private StatefulController controller;
    private String username;
    private String password;

    /**
     * Get the password field
     * @return The password field
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * set password field
     * @param password the password to set.
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Gets the username
     * @return the username.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Set the username, used by JSF for input
     * @param username 
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * Used to check if the user is logged in or not
     * @return true if user is logged in as a recruiter, false otherwise
     */
    public boolean getIsloggedin()
    {
        return controller.isLoggedInAsRecruiter();
    }
    
    /**
     * Used by the login system. 
     * @return the real name of the currently logged in user.
     */
    public String getRealname()
    {
        return controller.getRealName();
    }
    
    /**
     * Logs in a recruiter using the undername and password specified
     */
    public void doLogin()
    {
        controller.login(username, password);
    }
    
    /**
     * Logs out the user if logged in
     */
    public void doLogout()
    {
        controller.logOut();
    }
    
    /**
     * Run when use clicks the command link to go to the create application screen
     */
    public void createApplication()
    {
        controller.createApplication();
    }

}
