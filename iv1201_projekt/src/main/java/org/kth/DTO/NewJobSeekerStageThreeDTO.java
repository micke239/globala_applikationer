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

import java.util.LinkedList;
import java.util.List;
import org.kth.validation.DateAvailabilities;

/**
 * This objects holds the temporary data in the stage three process of the 
 * job application
 * 
 * @author Mikael Nilsson
 */
public class NewJobSeekerStageThreeDTO {
    
    @DateAvailabilities //validation annotation
    private List<DateAvailabilityDTO> dateAvailabilities = new LinkedList<DateAvailabilityDTO>();

    /**
     * Returns the current date availability List.
     * @return the current list of date availabilities.
     */
    public List<DateAvailabilityDTO> getDateAvailabilityList() {
        return dateAvailabilities;
    }

    /**
     * Adds a new date availability period to the list of avaialbe periods
     * @param dadto The date to add
     */
    public void addDateAvailability(DateAvailabilityDTO dadto) {
        dateAvailabilities.add(dadto);
    }

    /**
     * Removes the most recent entered date object from the list
     */
    public void removeLatestDateAvailability() {
        removeDateAvailability(dateAvailabilities.size()-1);
    }

    /**
     * Removes a date from the list at the specified index
     * @param index The index to remove
     */
    public void removeDateAvailability(int index) {
        dateAvailabilities.remove(index);
    }
    
}
