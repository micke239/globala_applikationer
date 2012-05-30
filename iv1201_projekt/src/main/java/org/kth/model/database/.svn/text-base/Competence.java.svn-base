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

package org.kth.model.database;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.kth.DTO.EntityCompetenceDTO;

/**
 * The entityclass representing a row in the table competence in the database.
 * The set methods will not write to database. Proper hibernate syntax has to 
 * be used for this to work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "competence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"),
    @NamedQuery(name = "Competence.findByCId", query = "SELECT c FROM Competence c WHERE c.cId = :cId"),
    @NamedQuery(name = "Competence.findByCategory", query = "SELECT c FROM Competence c WHERE c.category = :category"),
    @NamedQuery(name = "Competence.findByComment", query = "SELECT c FROM Competence c WHERE c.comment = :comment"),
    @NamedQuery(name = "Competence.findByNumberOfMonths", query = "SELECT c FROM Competence c WHERE c.numberOfMonths = :numberOfMonths"),
    @NamedQuery(name = "Competence.findByJobSeeker", query = "SELECT c FROM Competence c WHERE c.jobSeeker = :jobSeeker")})
public class Competence implements Serializable, EntityCompetenceDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_id")
    private Long cId;
    @ManyToOne
    @JoinColumn(name="category")
    private Competencecategory category;
    @Column(name = "comment")
    private String comment;
    @Column(name = "numberOfMonths")
    private BigInteger numberOfMonths;
    @ManyToOne
    @JoinColumn(name="jobSeeker")
    private Jobseeker jobSeeker;
    
    /**
     * Creates an empty Competence.
     */
    public Competence() { }

    /**
     * Creates a competence with a given id.
     * @param cId the id.
     */
    public Competence(Long cId) {
        this.cId = cId;
    }
    
    /**
     * Getter for id.
     * @return the id.
     */
    public Long getCId() {
        return cId;
    }
    
    /**
     * Setter for id.
     * @param cId the id.
     */
    public void setCId(Long cId) {
        this.cId = cId;
    }
    
    /**
     * Getter for category.
     * @return the Competencecategory
     */
    public Competencecategory getCategory() {
        return category;
    }

    /**
     * Setter for category.
     * @param category the Competencecategory
     */
    public void setCategory(Competencecategory category) {
        this.category = category;
    }

    /**
     * Getter for comment.
     * @return the comment.
     */
    @Override
    public String getComment() {
        return comment;
    }

    /**
     * Setter for comment.
     * @param comment the comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter for number of months.
     * @return number of months.
     */
    @Override
    public BigInteger getNumberOfMonths() {
        return numberOfMonths;
    }

    /**
     * Setter for number of months.
     * @param numberOfMonths the number of months.
     */
    public void setNumberOfMonths(BigInteger numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    /**
     * Getter for job seeker.
     * @return the job seeker.
     */
    public Jobseeker getJobSeeker() {
        return jobSeeker;
    }

    /**
     * Setter for job seeker.
     * @param jobSeeker the job seeker.
     */
    public void setJobSeeker(Jobseeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    /**
     * Creates and returns a string representation of this object. 
     * @return A string representation of this object.
     */
    @Override
    public String toString() {
        return "org.kth.model.database.Competence[ cId=" + cId + " ]";
    }

    /**
     * Getter for category name.
     * @return the category name.
     */
    @Override
    public String getCategoryName(){
        return category.getName();
    }
    
}
