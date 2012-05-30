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

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *  A data keeping object for the registration of a new job seeker. Stage one.
 * 
 * @author Mikael Nilsson
 */
public class NewJobSeekerStageOneDTO {
    @Pattern(regexp = "^[A-ZÅÄÖ].*", message = "{name_capital_error_message}")
    @Size(max = 255, message = "{size_255_message}")
    private String firstName = "";
    
    @Pattern(regexp = "^[A-ZÅÄÖ].*", message = "{surname_capital_error_message}")
    @Size(max = 255, message = "{size_255_message}")
    private String lastName = "";
    
    @Pattern(regexp = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$",
            message = "{invalid_mail}")
    private String eMailAddress = "";

    /**
     * Sets the firstname of the new job seeker.
     * @param firstName  the firstname of the new job seeker.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the lastname of the new job seeker.
     * @param lastName  the lastname of the new job seeker.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the e-mail of the new job seeker.
     * @param eMail  the e-mail of the new job seeker.
     */
    public void setEMail(String eMail) {
        this.eMailAddress = eMail;
    }

    /**
     * Getter for the e-mail of the new job seeker.
     * @return the e-mail of the new job seeker.
     */
    public String getEMail() {
        return eMailAddress;
    }

    /**
     * Getter for the last name of the new job seeker.
     * @return the last name of the new job seeker.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for the last name of the new job seeker.
     * @return the last name of the new job seeker.
     */
    public String getFirstName() {
        return firstName;
    }
    
    
}
