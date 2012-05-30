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
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Automatically generated entity class.
 * The set methods will not write to database. Proper hibernate syntax has to 
 * be used for this to work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByUserName", query = "SELECT a FROM Account a WHERE a.userName = :userName"),
    @NamedQuery(name = "Account.findByUserPassword", query = "SELECT a FROM Account a WHERE a.userPassword = :userPassword"),
    @NamedQuery(name = "Account.findByPerson", query = "SELECT a FROM Account a WHERE a.person = :person")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPassword")
    private String userPassword;
    @OneToOne
    @JoinColumn(name="person")
    private Person person;
 
    @OneToOne(mappedBy="account", optional=true)
    private Recruiter recruiter;
    
    @OneToOne(mappedBy="account", optional=true)
    private Jobseeker jobSeeker;

    /**
     * Get the jobSeeker tied to this acount (if present).
     * @return A Jobseeker object.
     */
    public Jobseeker getJobSeeker() {
        return jobSeeker;
    }

    /**
     * Set the job seeker tied to this account
     * 
     * NOTE: An account should only have on reference to
     * either a rectruiter or a job seeker, not both
     * 
     * @param jobSeeker The job seeker to set.
     */
    public void setJobSeeker(Jobseeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
    
    /**
     * Get the rectruiter tied to this account (if present)
     * @return A rectruiter object.
     */
    public Recruiter getRecruiter() {
        return recruiter;
    }

    /**
     * Set the rectruiter object tied to this account
     * 
     * NOTE: An account should only have on reference to
     * either a rectruiter or a job seeker, not both
     * 
     * @param recruiter The rectruiter to set.
     */
    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    /**
     * Standard constructor used to create a new accout for entry into the database.
     */
    public Account() {
    }

    /**
     * Create a new accout specifying the username of the account, must be unique.
     * @param userName The initial unsername for this acount
     */
    public Account(String userName) {
        this.userName = userName;
    }

    /**
     * Get the username of this entity object.
     * @return THe username of the account as a string.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set a new username for this account. Refrian from using this method since it
     * is the primary key of the table.
     * @param userName The username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the password for this account
     * @return The password stored in hte database.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
    * Sets the password for this account
    * @param userPassword A user provided password.
    */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Get the person tied to this account
     * @return The person entity tied to this.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Set a new person tied to this entity class.
     * 
     * Note: Don't use this, delete the old person and create a new account instead.
     * @param person 
     */
    public void setPerson(Person person) {
        this.person = person;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    /**
     * Returns true if this is equal to object.
     * @param object The object to compare
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    /**
     * Creates and returns a string representation of this object.
     * @return The string representation of this object.
     */
    @Override
    public String toString() {
        return "org.kth.model.database.Account[ userName=" + userName + " ]";
    }
    
}
