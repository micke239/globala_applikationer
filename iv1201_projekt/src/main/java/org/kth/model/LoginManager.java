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
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 * The Login manager handles login and authorization
 * @author Johan Schedin Jigland
 */
@Service
public class LoginManager implements Serializable{
 
    @Inject DAO dao;
    /**
     * Tries to authenticate the current session-user as a Recruiter.
     */
    public boolean login(String user, String pass) {
        return dao.loginRecruiter(user, pass);
    }
    
    /**
     * Get th erealname of a user from an account name
     * @param user The username
     * @return The real name of the provided user.
     */
    public String getUserRealName(String user){
        return dao.getUserRealName(user);
    }
}
