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
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.kth.model.database.Competencecategory;
import org.springframework.stereotype.Service;

/**
 * A helping class in the model for retriving all the competence catefories from
 * the database.
 * 
 * @author lallarN
 */
@Service
public class CompetenceManager implements Serializable{
    
    @Inject private DAO dao;

    /**
     * Get a list of all the competence categories in the database. This list is
     * a number of keys that are supposed to be translated against the propertie
     * files in order to display correctly.
     * 
     * 
     * @return A List of strings with the keys of all available competences.
     */
    public List<String> getAllCompetenceCategories() {
        List<Competencecategory> categoryList = dao.getAllCompetenceCategories();
        List<String> list  = new LinkedList<String>();
        for (Competencecategory category : categoryList) {
            ResourceBundle bundle = ResourceBundle.getBundle("properties.category", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            list.add(bundle.getString(category.getName()));
        }
        return list;
    }
    
}
