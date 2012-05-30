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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kth.DTO.DateAvailabilityDTO;

/**
 * The implementation of the <class>DateAvailabilities</class> constraint 
 *  annotation.
 * 
 * @author Mikael Nilsson
 */
public class DateAvailabilitiesValidator 
    implements ConstraintValidator<DateAvailabilities, List<DateAvailabilityDTO>> {

    
    private static final Logger logger = Logger.getLogger(DateAvailabilitiesValidator.class);
    
    /**
     * Does nothing.
     * @param a Not used.
     */
    @Override
    public void initialize(DateAvailabilities a) {}

    /**
     * Validates availability dates. From may not be larger than to. Both from 
     * and to must be functional dates, e.g. not February 31st.
     * @param dateAvailabilities the list of date availabilities.
     * @param cvc Not used.
     * @return Whether the list was valid or not.
     */
    @Override
    public boolean isValid(List<DateAvailabilityDTO> dateAvailabilities, ConstraintValidatorContext cvc) {
        for (DateAvailabilityDTO dadto : dateAvailabilities) {
            if (!validateDateAvailability(dadto)) {
                return false;
            } 
        }
        
        return true;
    }
    
    private boolean validateDateAvailability(DateAvailabilityDTO dadto) {
        try {
            String from = dadto.getStartDateString();
            String to = dadto.getEndDateString();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
            Date fromDate = sdf.parse(from);
            Date toDate = sdf.parse(to);
            if (fromDate.compareTo(toDate) <= 0) {
                String parsedTo = sdf.format(toDate);
                String parsedFrom = sdf.format(fromDate);
                if (to.equals(parsedTo) && from.equals(parsedFrom)) {
                    return true;
                } 
            }
        } catch (ParseException ex) 
        {
            logger.log(Level.ERROR, ex.toString() + ex.getMessage());
        }
        
        return false;
    }   
}
