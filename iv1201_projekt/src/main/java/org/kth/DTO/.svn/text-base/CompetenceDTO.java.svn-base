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

/**
 * Class needed to translate competences into the the proper localized language
 * @author Johan Schedin Jigland
 */
public class CompetenceDTO implements EntityCompetenceDTO
{
    private String categoryName;
    private String comment;
    private BigInteger numberOfMonths;
    
    /**
     * Creates a new Competence DTO from an EntityDTO interface.
     * @param data 
     */
    public CompetenceDTO(EntityCompetenceDTO data)
    {
        this.categoryName = data.getCategoryName();
        this.comment = data.getComment();
        this.numberOfMonths = data.getNumberOfMonths();
    }
    
    /**
     * Creates a new competenceDTO from scratch
     * @param categoryName The category key name for the competence
     * @param comment Optinal comment
     * @param numberOfMonths an int with the number of months experience with this 
     * competence.
     */
    public CompetenceDTO(String categoryName, String comment, BigInteger numberOfMonths)
    {
        this.categoryName = categoryName;
        this.comment = comment;
        this.numberOfMonths = numberOfMonths;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * @return the comment
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * @return the numberOfMonths
     */
    public BigInteger getNumberOfMonths()
    {
        return numberOfMonths;
    }
}
