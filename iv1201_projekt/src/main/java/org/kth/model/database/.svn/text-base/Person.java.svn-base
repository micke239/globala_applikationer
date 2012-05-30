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
 * The set methods will not write to database. Proper hibernate syntax has to 
 * be used for this to work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPId", query = "SELECT p FROM Person p WHERE p.pId = :pId"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person.findByEmailAdress", query = "SELECT p FROM Person p WHERE p.emailAdress = :emailAdress")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_id")
    private Long pId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "emailAdress")
    private String emailAdress;
    
    @OneToOne(mappedBy="person")
    private Account account;

    
    /**
     * Get the account that is mapped t othis person
     * @return The account entity mapped to the person
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set the account connected to this person object.
     * @param account  the account to set.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Standard constructor to create a new person entity for entry into the database.
     */
    public Person() {
    }

    /**
     * Creates a new person with a specified primary id-key.
     * @param pId 
     */
    public Person(Long pId) {
        this.pId = pId;
    }

    /**
     * Get the primary key of this person object.
     * @return The primary key.
     */
    public Long getPId() {
        return pId;
    }

    /**
     * Set the primary key column of this object
     * parameter must be unique
     * 
     * Note: don't use this method, delete the user and create a new one instead.
     * @param pId The id to set.
     */
    public void setPId(Long pId) {
        this.pId = pId;
    }

    /**
     * Get the first name of this person.
     * @return First name as a string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of this person
     * @param firstName The name to set as a string.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of this person
     * @return The last name as a string.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of this person
     * @param lastName The name to set as a string
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the email-adress of this entity.
     * @return The email address of this person.
     */
    public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * Set the email Adress associated with this person.
     * @param emailAdress  A valid email adress to set, as a string.
     */
    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    /**
     * Returns true if this is equal to object. 
     * 
     * Auto genereated method. 
     * 
     * @param object The object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    /**
     * Creates and returns a string representation of this object
     * @return  A string representation of this object.
     */
    @Override
    public String toString() {
        return "org.kth.model.database.Person[ pId=" + pId + " ]";
    }
    
}
