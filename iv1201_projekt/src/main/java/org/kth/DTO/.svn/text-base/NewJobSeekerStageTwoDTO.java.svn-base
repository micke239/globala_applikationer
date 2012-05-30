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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import org.kth.model.database.Competence;
import org.kth.model.database.Competencecategory;
import org.kth.validation.NoDuplicateCompetence;

/**
 * This objects holds the temporary data in the stage two process of the 
 * job application
 * 
 * @author Mikael Nilsson
 */
public class NewJobSeekerStageTwoDTO {
    
    //The current list of competences, automatically varified by beans validation
    @NoDuplicateCompetence
    private List<Competence> competences = new LinkedList<Competence>();

    /**
     * Removes an entered competence from the current working list
     * @param index The index to remove
     */
    public void removeCompetence(int index) {
        competences.remove(index);
    }

    /**
     * Returns the complete list of entered competences.
     * @return A List of competence objects
     */
    public List getCompetenceList() {
    
        return competences;
    }
    
    /**
     * Returns the complete list of entered competences.
     * @return A List of competence objects
     */
    public List getLocaleCompetenceList() {
    
        List<EntityCompetenceDTO> newList = new ArrayList<EntityCompetenceDTO>();
        ResourceBundle bundle = ResourceBundle.getBundle("properties.category", 
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
        for (EntityCompetenceDTO c : this.competences)
            //n months, comment, n months
        {
            CompetenceDTO comp = new CompetenceDTO(bundle.getString(c.getCategoryName())
                    ,c.getComment(),c.getNumberOfMonths());
            newList.add(comp);
        }
        
        return newList;
    }

    /**
     * Adds a new competence to the working list.
     * @param category The Category of the competence
     * @param comment An optional comment
     * @param numberOfMonths An integer withte amount of months of experience with this competence.
     */
    public void addCompetence(String category, String comment, int numberOfMonths) {
        Competence competence = new Competence();
        competence.setCategory(new Competencecategory(category));
        competence.setComment(comment);
        competence.setNumberOfMonths(new BigInteger(numberOfMonths + ""));
        competences.add(competence);
    }

    /**
     * Removes the last added competence
     */
    public void removeLastCompetence() {
        removeCompetence(competences.size()-1);
    }
}
