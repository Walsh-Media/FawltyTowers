/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.walshmedia.fawltytowers;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Keith
 */
@Entity
@Table(name = "booking")
@NamedQueries(
{
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id"),
    @NamedQuery(name = "Booking.findByFirstName", query = "SELECT b FROM Booking b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "Booking.findByLastName", query = "SELECT b FROM Booking b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "Booking.findByTelephone", query = "SELECT b FROM Booking b WHERE b.telephone = :telephone"),
    @NamedQuery(name = "Booking.findByCheckInDate", query = "SELECT b FROM Booking b WHERE b.checkInDate = :checkInDate"),
    @NamedQuery(name = "Booking.findByCheckOutDate", query = "SELECT b FROM Booking b WHERE b.checkOutDate = :checkOutDate")
})
public class Booking implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "Telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CheckInDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Column(name = "CheckOutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;
    @JoinColumn(name = "RoomId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Room roomId;

    public Booking()
    {
    }

    public Booking(Integer id)
    {
	this.id = id;
    }

    public Booking(Integer id, String firstName, String lastName, Date checkInDate)
    {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.checkInDate = checkInDate;
    }

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public String getLastName()
    {
	return lastName;
    }

    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }

    public String getTelephone()
    {
	return telephone;
    }

    public void setTelephone(String telephone)
    {
	this.telephone = telephone;
    }

    public Date getCheckInDate()
    {
	return checkInDate;
    }

    public void setCheckInDate(Date checkInDate)
    {
	this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate()
    {
	return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate)
    {
	this.checkOutDate = checkOutDate;
    }

    public Room getRoomId()
    {
	return roomId;
    }

    public void setRoomId(Room roomId)
    {
	this.roomId = roomId;
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
	if (!(object instanceof Booking))
	{
	    return false;
	}
	Booking other = (Booking) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
	{
	    return false;
	}
	return true;
    }

    @Override
    public String toString()
    {
	return "ie.walshmedia.fawltytowers.Booking[ id=" + id + " ]";
    }
    
}
