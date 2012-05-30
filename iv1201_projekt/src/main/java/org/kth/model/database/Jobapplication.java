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

/**
 * The entity class representing the job application table. The set methods
 * will not write to database. Proper hibernate syntax has to be used for this to
 * work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "jobapplication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobapplication.findAll", query = "SELECT j FROM Jobapplication j"),
    @NamedQuery(name = "Jobapplication.findByJaId", query = "SELECT j FROM Jobapplication j WHERE j.jaId = :jaId"),
    @NamedQuery(name = "Jobapplication.findByJobSeeker", query = "SELECT j FROM Jobapplication j WHERE j.jobSeeker = :jobSeeker"),
    @NamedQuery(name = "Jobapplication.findByDateOfRegistration", query = "SELECT j FROM Jobapplication j WHERE j.dateOfRegistration = :dateOfRegistration"),
    @NamedQuery(name = "Jobapplication.findByAccepted", query = "SELECT j FROM Jobapplication j WHERE j.accepted = :accepted")})
public class Jobapplication implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ja_id")
    private Long jaId;
    @OneToOne
    @JoinColumn(name="jobSeeker")
    private Jobseeker jobSeeker;
    @Column(name = "dateOfRegistration")
    @Temporal(TemporalType.DATE)
    private Date dateOfRegistration;
    @Column(name = "accepted")
    private Boolean accepted;

    /**
     * Empty constructor used to create a new entity for creation of a new row in
     * the database
     */
    public Jobapplication() {
    }

    /**
     * Creates a new Job application entity specifying the primary key.
     * @param jaId The id to use, must be unique.
     */
    public Jobapplication(Long jaId) {
        this.jaId = jaId;
    }

    /**
     * Get the primary key of this object.
     * @return The primary key.
     */
    public Long getJaId() {
        return jaId;
    }
    
    /**
     * Set the primary key for this object
     * Note: refrain from using this object. Delete this application and create
     * a new one instead.
     * @param jaId The Id to set.
     */
    public void setJaId(Long jaId) {
        this.jaId = jaId;
    }

    /**
     * Get the job seeker object connected to this entity.
     * @return A job seeker object.
     */
    public Jobseeker getJobSeeker() {
        return jobSeeker;
    }

    /**
     * Set the jobseeker connected to this  job application.
     * @param jobSeeker The jobseeker to set.
     */
    public void setJobSeeker(Jobseeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    /**
     * Get the date of registration for this applivcation
     * @return The date of registration.
     */
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    /**
     * Set the date of registration in this entity
     * NOTE: this should not be used.
     * @param dateOfRegistration  the date to set.
     */
    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    /**
     * Get the flag if this jobapplication is accepted or not.
     * @return The accepted flag.
     */
    public Boolean getAccepted() {
        return accepted;
    }

    /**
     * Set the accepted status 
     * @param accepted 
     */
    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jaId != null ? jaId.hashCode() : 0);
        return hash;
    }

    /**
     * Compare  this to object
     * @param object The object to compare
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobapplication)) {
            return false;
        }
        Jobapplication other = (Jobapplication) object;
        if ((this.jaId == null && other.jaId != null) || (this.jaId != null && !this.jaId.equals(other.jaId))) {
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
        return "org.kth.model.database.Jobapplication[ jaId=" + jaId + " ]";
    }
    
}
