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
 * The entity class for a row in the table competencecategory.
 * The set methods will not write to database. Proper hibernate syntax has to 
 * be used for this to work.
 * 
 * Generated class.
 * @author lallarN
 */
@Entity
@Table(name = "competencecategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencecategory.findAll", query = "SELECT c FROM Competencecategory c"),
    @NamedQuery(name = "Competencecategory.findByName", query = "SELECT c FROM Competencecategory c WHERE c.name = :name"),
    @NamedQuery(name = "Competencecategory.findByDescription", query = "SELECT c FROM Competencecategory c WHERE c.description = :description")})
public class Competencecategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    /**
     * Standard construcutor used to create a new competence category.
     */
    public Competencecategory() {
    }

    /**
     * Creates a new competence category with an initial name.
     * @param name The initial name
     */
    public Competencecategory(String name) {
        this.name = name;
    }

    /**
     * The getes the name of this entity category.
     * @return The main name of this category.
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of this category
     * Note: Dont use this, delete the category and create a new one instead
     * must be unique.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of this competence category.
     * @return description as string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a new description for this competence category.
     * @param description The description to set, length < 255.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Hibernate needed / genereated method. 
     * @return a hashmap.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    /**
     * Return true if this equals obejct
     * @param object The object to compare
     * @return True if this equals object
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencecategory)) {
            return false;
        }
        Competencecategory other = (Competencecategory) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    /**
     * Creates and returns a string representation of this object. 
     * @return A string representing this object.
     */
    @Override
    public String toString() {
        return "org.kth.model.database.Competencecategory[ name=" + name + " ]";
    }
    
}
