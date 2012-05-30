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
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.kth.DTO.EntityTimePeriodDTO;

/**
 * Entity class for the timeperiod table. Relational bound using hibernate.
 * 
 * The set methods will not write to database. Proper hibernate syntax has to 
 * be used for this to work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "timeperiod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timeperiod.findAll", query = "SELECT t FROM Timeperiod t"),
    @NamedQuery(name = "Timeperiod.findByTpId", query = "SELECT t FROM Timeperiod t WHERE t.tpId = :tpId"),
    @NamedQuery(name = "Timeperiod.findByStartDate", query = "SELECT t FROM Timeperiod t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "Timeperiod.findByEndDate", query = "SELECT t FROM Timeperiod t WHERE t.endDate = :endDate"),
    @NamedQuery(name = "Timeperiod.findByJobSeeker", query = "SELECT t FROM Timeperiod t WHERE t.jobSeeker = :jobSeeker")})
public class Timeperiod implements Serializable, EntityTimePeriodDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tp_id")
    private Long tpId;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @ManyToOne
    @JoinColumn(name="jobSeeker")
    private Jobseeker jobSeeker;

    /**
     * Refrain from calling this constructor directly. Use the proper hibernate syntax
     * instead.
     */
    public Timeperiod() {
    }

    /**
     * Create a new timeperiod object using with an explicit Id. 
     * Refrain from using this constructor, use the proper hibernate syntax instead.
     * @param tpId 
     */
    public Timeperiod(Long tpId) {
        this.tpId = tpId;
    }

    /**
     * Get the id of a timeperiod object.
     * @return the id of this timeperiod.
     */
    public Long getTpId() {
        return tpId;
    }

    /**
     * Set the primary id.
     * @param tpId The id to set.
     */
    public void setTpId(Long tpId) {
        this.tpId = tpId;
    }

    /**
     * Get the start date of this time period object/row.
     * @return the start date of this time period.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of this timeperiod object/row.
     * @param startDate The date to set.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the end date of this timeperiod object/row.
     * @return the ned date
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Get the jobseeker tied to this timeperiod.
     * @return An jobseeker entity tied to this class
     */
    public Jobseeker getJobSeeker() {
        return jobSeeker;
    }

    /**
     * Set the jobseeker tied to this object. Refrain from using this method.
     * @param jobSeeker the job seeker to set.
     */
    public void setJobSeeker(Jobseeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
    
    /**
     * Get the start date as a stirng.
     * TODO: prettier strings.
     * @return The start date as a proper string
     */
    @Override
    public String getStartDateString(){
        return (this.startDate.getYear() + 1900) + "-" + (this.startDate.getMonth() + 1) + "-" + this.startDate.getDate();
    }
    
    /**
     * Get the end date as a string
     * @return The end date as a properly formatted string.
     */
    @Override
    public String getEndDateString(){
        return (this.endDate.getYear() + 1900) + "-" + (this.endDate.getMonth() + 1) + "-" + this.endDate.getDate();
    }

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpId != null ? tpId.hashCode() : 0);
        return hash;
    }

    /**
     * Returns true if this is equal to object. 
     * 
     * NOTE: this method wont work in case the id fields are not set.
     * @param object the Object to compare to.
     * @return whether it was equal or not.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Timeperiod)) {
            return false;
        }
        Timeperiod other = (Timeperiod) object;
        if ((this.tpId == null && other.tpId != null) || (this.tpId != null && !this.tpId.equals(other.tpId))) {
            return false;
        }
        return true;
    }

    /**
     * Creates a string representation of this object.
     * @return A string representation of this object.
     */
    @Override
    public String toString() {
        return "org.kth.model.database.Timeperiod[ tpId=" + tpId + " ]";
    }
    
}
