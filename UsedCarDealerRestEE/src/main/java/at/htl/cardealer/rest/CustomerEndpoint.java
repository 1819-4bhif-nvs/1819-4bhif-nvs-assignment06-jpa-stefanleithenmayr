package at.htl.cardealer.rest;

import at.htl.cardealer.model.Car;
import at.htl.cardealer.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("customer")
public class CustomerEndpoint {

    @PersistenceContext
    EntityManager em;

    //http://localhost:8080/usedcardealer/API/customer/getCustomers
    @GET
    @Path("getCustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers(){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
        return query.getResultList();
    }
}
