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
 * The recruiter entitty class. representing a row in the table recruiter in the 
 * relational database tied to this application.
 * 
 * The set methods will not write to database. Proper hibernate syntax has to 
 * be used for this to work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "recruiter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recruiter.findAll", query = "SELECT r FROM Recruiter r"),
    @NamedQuery(name = "Recruiter.findByAccount", query = "SELECT r FROM Recruiter r WHERE r.account = :account")})
public class Recruiter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account")
    private String userName;
    
    //specifies relational mappings via hibernate.
    @OneToOne
    @JoinColumn(name="account")
    private Account account;
    
    /**
     * Standard constructor used to create a new rectruiter entity
     * (for entering new data into the database).
     */
    public Recruiter() {
    }

    /**
     * Creates a new recruiter with the specified primary account key object.
     * @param account The account to bind to this recruiter.
     */
    public Recruiter(Account account) {
        this.account = account;
    }

    /**
     * Get the username in this object/row. This also act as the primary key.
     * @return The username of this recruiter.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username. Be careful updating this since it has a relation to the
     * account username column.
     * @param userName The new unique username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the account tied to this rectruiter
     * @return The account object of this rectruiter.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set the account tied to this rectruiter object.
     * @param account The account to set.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (account != null ? account.hashCode() : 0);
        return hash;
    }

    /**
     * Equals tru if this is equal to to object, Hibernate auto generated method.
     * @param object The object to compare
     * @return True if equals, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recruiter)) {
            return false;
        }
        Recruiter other = (Recruiter) object;
        if ((this.account == null && other.account != null) || (this.account != null && !this.account.equals(other.account))) {
            return false;
        }
        return true;
    }

    /**
     * Creates and returns a string representation of this object.
     * @return the string representation of this object.
     */
    @Override
    public String toString() {
        return "org.kth.model.database.Recruiter[ account=" + account + " ]";
    }
    
}
