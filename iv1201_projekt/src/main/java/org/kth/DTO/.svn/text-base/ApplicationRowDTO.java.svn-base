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


/**
 * A data transfor object for transefering application rows from the database 
 * to the search view. The DTO class only has read methods
 * 
 * @author Nikolai Padyukov
 */
public class ApplicationRowDTO {
    private String uName;
    private String fName;
    private String lName;
    private String dor;

    public ApplicationRowDTO(String userName, String firstName, String lastName, String dateOfRegistration) {
        this.uName = userName;
        this.fName = firstName;
        this.lName = lastName;
        this.dor = dateOfRegistration;
    }

    
    /**
     * Returns the date of registration
     * @return The date of registration for this application row
     */
    public String getDateOfRegistration() {
        return dor;
    }

    /**
     * Returns the first name of the person of this application
     * @return A string with the first name of the user
     */
    public String getFName() {
        return fName;
    }

    /**
     * Returns the last name of the person of this application
     * @return A string with the last name of the user
     */
    public String getLName() {
        return lName;
    }
    
    /**
     * Returns the first name of the person of this application
     * @return A string with the user name of the user
     */
    public String getUName() {
        return uName;
    }

    /**
     * A string representation of this object.
     * @return A string
     */
    @Override
    public String toString(){
        return "Username: " + this.uName + ", First Name: " + this.fName + ", Last Name " + this.lName + ", Date of registration: " + this.dor;
    }
   
}
