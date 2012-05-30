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
import java.util.List;
import javax.inject.Inject;
import org.kth.DTO.ApplicationRowDTO;
import org.kth.DTO.FullJobapplicationDTO;
import org.springframework.stereotype.Service;

/**
 * The helper class for managing seraches.
 * 
 * In charge of taking user input, and transforming it into valid
 * arguments for the DAO search method. This contains alot of logic.
 * @author Nikolai PAdyukov
 */
@Service
public class SearchManager implements Serializable{
    @Inject DAO dao;
    
    /**
     * Do a search based on the parameters in the provided SearchParameteres
     * object.
     * 
     * Note that because we are using the deprecated DateFormat that has month-values from 0-11, we need to manually increment these.
     * 
     * @param search The serach parameters to search for
     * @return A list of matching applications.
     */
    public List<ApplicationRowDTO> conductSearch(SearchParameters search) {

        String arg1;
        String arg2;
        String arg3;
        String arg4;
        String arg5;
        String arg6;
        
        
        if(search.getStartDate() == null){
            arg1 = "true";
        } else {
            arg1 = "tp.startDate <= '" + search.getStartDate().getYear() + "-"
                    + (search.getStartDate().getMonth() + 1) + "-"
                    + search.getStartDate().getDate() + "'";
        }
        
        if(search.getEndDate() == null){
            arg2 = "true";
        } else {
            arg2 = "tp.endDate >= '" + search.getEndDate().getYear() + "-"
                    + (search.getEndDate().getMonth() + 1) + "-"
                    + search.getEndDate().getDate() + "'";
        }
        
        if(search.getRegDate() == null){
            arg3 = "true";
        } else {
            arg3 = "ja.dateOfRegistration = '" + search.getRegDate().getYear() + "-"
                    + (search.getRegDate().getMonth() + 1) + "-"
                    + search.getRegDate().getDate() + "'";
        }
        
        if(search.getFirstName() == null){
            arg4 = "true";
        } else if(search.getFirstName().isEmpty()){
            arg4 = "true";
        } else {
            arg4 = "p.firstName = '" +  search.getFirstName() + "'";
        }
        
        if(search.getLastName() == null){
            arg5 = "true";
        } else if(search.getLastName().isEmpty()){
            arg5 = "true";
        } else {
            arg5 = "p.lastName = '" + search.getLastName() + "'";
        }
        
        if(search.getCompetence().equals("All")){
            arg6 = "true";
        } else {
            arg6 = "cp.category = '" + search.getCompetence() + "'";
        }
        System.err.println("Arg1:" + arg1);
        System.err.println("Arg2:" + arg2);
        System.err.println("Arg3:" + arg3);
        System.err.println("Arg4:" + arg4);
        System.err.println("Arg5:" + arg5);
        System.err.println("Arg6:" + arg6);
        
        return dao.getSearchedApplications(arg1, arg2, arg3, arg4, arg5, arg6);
    }
    
    /**
     * Returns a application based only on the username 
     * @param userName The username to search for.
     * @return The application that balongs to the provided user.
     */
    public FullJobapplicationDTO getApplicationByUsername(String userName){
        return dao.getApplicationByUsername(userName);
    }
}
