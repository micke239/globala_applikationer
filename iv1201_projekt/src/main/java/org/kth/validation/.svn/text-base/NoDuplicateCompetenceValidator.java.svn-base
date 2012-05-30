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

package org.kth.validation;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.kth.model.database.Competence;

/**
 * The implementation of the NoDuplicateCompetence constraint annotation.
 * 
 * @author Mikael Nilsson
 */
public class NoDuplicateCompetenceValidator 
                implements ConstraintValidator<NoDuplicateCompetence, List<Competence>>{

    /**
     * Does nothing at all.
     * @param a Not needed, not used.
     */
    @Override
    public void initialize(NoDuplicateCompetence a) {}

    /**
     * Checks whether the given competence list is valid or not.
     * @param competences Your list of competences.
     * @param cvc Needed because of the interface, not used.
     * @return Whether the competencelist is valid or not.
     */
    @Override
    public boolean isValid(List<Competence> competences, ConstraintValidatorContext cvc) {
        for (int i = 0; i < competences.size(); i++) {
            for (int j = i+1; j < competences.size(); j++) {
                if (competences.get(i).getCategory()
                        .equals(competences.get(j).getCategory())) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
