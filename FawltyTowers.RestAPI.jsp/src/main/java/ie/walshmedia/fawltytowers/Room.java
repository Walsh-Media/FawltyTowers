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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "room")
@NamedQueries(
{
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findById", query = "SELECT r FROM Room r WHERE r.id = :id"),
    @NamedQuery(name = "Room.findByNumber", query = "SELECT r FROM Room r WHERE r.number = :number")
})
public class Room implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Number")
    private String number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "RoomTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Roomtype roomTypeId;

    public Room()
    {
    }

    public Room(Integer id)
    {
	this.id = id;
    }

    public Room(Integer id, String number)
    {
	this.id = id;
	this.number = number;
    }

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getNumber()
    {
	return number;
    }

    public void setNumber(String number)
    {
	this.number = number;
    }

    public Collection<Booking> getBookingCollection()
    {
	return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection)
    {
	this.bookingCollection = bookingCollection;
    }

    public Roomtype getRoomTypeId()
    {
	return roomTypeId;
    }

    public void setRoomTypeId(Roomtype roomTypeId)
    {
	this.roomTypeId = roomTypeId;
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
	if (!(object instanceof Room))
	{
	    return false;
	}
	Room other = (Room) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
	{
	    return false;
	}
	return true;
    }

    @Override
    public String toString()
    {
	return "ie.walshmedia.fawltytowers.Room[ id=" + id + " ]";
    }
    
}
