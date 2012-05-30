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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Tis objects holds all the parameters for a search. Used to provid a cleaner
 * public interface.
 * @author lallarN
 */
public class SearchParameters implements Serializable {
    
    private Date startDate;
    private Date endDate;
    private Date regDate;
    private String competence;
    private String firstName;
    private String lastName;
    
    private static final Logger logger = Logger.getLogger(SearchParameters.class);


    /**
     * Create a new set of search parameters, arguments can be null or 0.
     * @param startDateDay
     * @param startDateMonth
     * @param startDateYear
     * @param endDateDay
     * @param endDateMonth
     * @param endDateYear
     * @param regDateDay
     * @param regDateMonth
     * @param regDateYear
     * @param competence
     * @param firstName
     * @param lastName 
     */
    public SearchParameters(int startDateDay, String startDateMonth, int startDateYear, int endDateDay, String endDateMonth, int endDateYear, int regDateDay, String regDateMonth, int regDateYear, String competence, String firstName, String lastName) {
        
        try{
        if(startDateDay != 0 && startDateMonth != null && startDateYear != 0){
            startDate = new SimpleDateFormat("MMMMMMMM", Locale.ENGLISH).parse(startDateMonth);
            startDate.setDate(startDateDay);
            startDate.setYear(startDateYear);
        } else {
            this.startDate = null;
        }
        
        if(endDateDay != 0 && endDateMonth != null && endDateYear != 0){
            endDate = new SimpleDateFormat("MMMMMMMM", Locale.ENGLISH).parse(endDateMonth);
            endDate.setDate(endDateDay);
            endDate.setYear(endDateYear);
        } else {
            this.endDate = null;
        }
        
        if(regDateDay != 0 && regDateMonth != null && regDateYear != 0){
            regDate = new SimpleDateFormat("MMMMMMMM", Locale.ENGLISH).parse(regDateMonth);
            regDate.setDate(regDateDay);
            regDate.setYear(regDateYear);
        } else {
            this.regDate = null;
        }
        } catch(ParseException e){
            logger.log(Level.ERROR, e.toString() + " " + e.getMessage());
        }
        
        this.competence = competence;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the competence selected for this searchparameter
     * @return The competence selected for this searchparameter
     */
    public String getCompetence() {
        return competence;
    }

    /**
     * returns the first name of this search parameter
     * Can be an empty string
     * @return The first name search parameter
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of this search parameter
     * Can be an empty string
     * @return The last name search parameter
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the start date as a DAte object
     * @return The start date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Get the registration date of this search parameter
     * @return The registration date
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * Returns the start date of this search parameter
     * @return The start date of this search parameter.
     */
    public Date getStartDate() {
        return startDate;
    }

    
    
    
}
