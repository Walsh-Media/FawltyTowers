package ie.walshmedia.fawltytowers.repositories.service;

import ie.walshmedia.utilities.RepositoryBase;
import ie.walshmedia.fawltytowers.Booking;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

/**
 *
 * @author Keith
 */
@Stateless
@Path("ie.walshmedia.fawltytowers.booking")
public class BookingRepository extends RepositoryBase<Booking>
{

    @PersistenceContext(unitName = "FawltyTowers")
    private EntityManager em;

    public BookingRepository()
    {
	super(Booking.class);
    }

    @Override
    protected EntityManager getEntityManager()
    {
	return em;
    }
    
}
