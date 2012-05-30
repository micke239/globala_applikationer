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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * A Date DTO for entering data into the system.
 * 
 * @author Mikael Nilsson
 */
public class DateAvailabilityDTO {
    private String from;
    private String to;
    
    private static final Logger logger = Logger.getLogger(DateAvailabilityDTO.class);
    
    /**
     * Standard and only constructor
     * @param from The starting date on the format "yyyy-MMM-dd"
     * @param to The ending date on the format "yyyy-MMM-dd"
     */
    public DateAvailabilityDTO (String from, String to) {
        this.from = from;
        this.to = to;
    }
      
    /**
     * Retruns the start date string as provided in the constructor
     * @return A string with the start date
     */
    public String getStartDateString() {
        return from;
    }
    
    /**
     * Returns the end date string as provided in the constructor
     * @return A string with the end date
     */
    public String getEndDateString() {
        return to;
    }
    
    /**
     * Get the end date as a Date object instead of a string
     * @return The end date Date object
     */
    public Date getEndDateAsDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        Date returnDate = null;
        
        try {
            returnDate = sdf.parse(to);
        } catch (ParseException pe) {
            logger.log(Level.ERROR, pe.toString() + pe.getMessage());
            throw new RuntimeException(pe);
        }
        
        return returnDate;
    }
    
    /**
     * Get the start date as a Date object
     * @return The start date date object.
     */
    public Date getStartDateAsDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        Date returnDate = null;
        
        try {
            returnDate = sdf.parse(from);
        } catch (ParseException pe) {
            logger.log(Level.ERROR, pe.toString() + pe.getMessage());
            throw new RuntimeException(pe);
        }
        
        return returnDate;        
    }
}
