/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.walshmedia.fawltytowers;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Keith
 */
@Entity
@Table(name = "roomtype")
@NamedQueries(
{
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r"),
    @NamedQuery(name = "Roomtype.findById", query = "SELECT r FROM Roomtype r WHERE r.id = :id"),
    @NamedQuery(name = "Roomtype.findByName", query = "SELECT r FROM Roomtype r WHERE r.name = :name")
})
public class Roomtype implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomTypeId")
    private Collection<Room> roomCollection;

    public Roomtype()
    {
    }

    public Roomtype(Integer id)
    {
	this.id = id;
    }

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public Collection<Room> getRoomCollection()
    {
	return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection)
    {
	this.roomCollection = roomCollection;
    }

    @Override
    public int hashCode()
    {
	int hash = 0;
	hash += (id != null ? id.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object)
    {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Roomtype))
	{
	    return false;
	}
	Roomtype other = (Roomtype) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
	{
	    return false;
	}
	return true;
    }

    @Override
    public String toString()
    {
	return "ie.walshmedia.fawltytowers.Roomtype[ id=" + id + " ]";
    }
    
}
