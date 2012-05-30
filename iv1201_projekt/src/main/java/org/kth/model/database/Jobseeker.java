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
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The set methods will not write to database. Proper hibernate syntax has to 
 * be used for this to work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "jobseeker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobseeker.findAll", query = "SELECT j FROM Jobseeker j"),
    @NamedQuery(name = "Jobseeker.findByJsId", query = "SELECT j FROM Jobseeker j WHERE j.jsId = :jsId"),
    @NamedQuery(name = "Jobseeker.findByAccount", query = "SELECT j FROM Jobseeker j WHERE j.account = :account")})
public class Jobseeker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "js_id")
    private Long jsId;
    @OneToOne
    @JoinColumn(name = "account")
    private Account account;
    
    @OneToMany(mappedBy = "jobSeeker", fetch=FetchType.EAGER)
    private Set<Competence> competences;
    
    @OneToMany(mappedBy = "jobSeeker", fetch=FetchType.EAGER)
    private Set<Timeperiod> timePeriods;
    
    @OneToOne(mappedBy = "jobSeeker", fetch=FetchType.EAGER)
    private Jobapplication jobApp;

    /**
     * Det the job application tied to this job sekker.
     * @return A jobAapplication object.
     */
    public Jobapplication getJobApp() {
        return jobApp;
    }

    /**
     * Set the job application tied to this jobseeker
     * @param jobApp The job application to set.
     */
    public void setJobApp(Jobapplication jobApp) {
        this.jobApp = jobApp;
    }

    /**
     * get a set of available time periods from this jobseeker
     * @return A Set of time period objects.
     */
    public Set getTimePeriods() {
        return timePeriods;
    }

    /**
     * set the time period objects for this entity.
     * @param timePeriods A Set of timperiods to set.
     */
    public void setTimePeriods(Set<Timeperiod> timePeriods) {
        this.timePeriods = timePeriods;
    }

    /**
     * Get the set of competences of this jobseeker
     * @return A set of competence entity objects.
     */
    public Set getCompetences() {
        return competences;
    }

    /**
     * Set the competences of this jobseeker.
     * @param competences A set of competences.
     */
    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }
    
    /**
     * Empty constructor for creating the initial object for entry of new 
     * jobseeker into the database.
     */
    public Jobseeker() {
    }

    /**
     * Create a new jobSeeker with a predifened primary key
     * 
     * @param jsId The key to set.
     */
    public Jobseeker(Long jsId) {
        this.jsId = jsId;
    }

    /**
     * Gets the primary id of this jobseeker.
     * @return The primary key of this entity class.
     */
    public Long getJsId() {
        return jsId;
    }

    /**
     * Sets the primary id column of this jobseeker entity. 
     * Note: don't use this, delete the jobseeker and recreated it instead.
     * @param jsId The id to set.
     */
    public void setJsId(Long jsId) {
        this.jsId = jsId;
    }

    /**
     * Get the account tied to this job seeker.
     * @return An account object tied to this job seeker.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set the account tied to this jobseeker.
     * @param account Án account object to tie to this jobseeker.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jsId != null ? jsId.hashCode() : 0);
        return hash;
    }

    /**
     * Compares this to object.
     * @param object the object to compare.
     * @return True if equals, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobseeker)) {
            return false;
        }
        Jobseeker other = (Jobseeker) object;
        if ((this.jsId == null && other.jsId != null) || (this.jsId != null && !this.jsId.equals(other.jsId))) {
            return false;
        }
        return true;
    }

    /**
     * Creates and returns a string representation of this entity object.
     * @return A string representation of this.
     */
    @Override
    public String toString() 
    {
        return "org.kth.model.database.Jobseeker[ jsId = " + jsId + "Account = " + account + "]";
    }
    
}
