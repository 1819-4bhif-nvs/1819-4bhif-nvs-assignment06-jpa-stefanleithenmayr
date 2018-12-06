package at.htl.cardealer.rest;

import at.htl.cardealer.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("customers")
public class CustomerEndpoint {

    @PersistenceContext
    EntityManager em;

    //Create
    @POST
    @Path("insertCustomer")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCustomer(Customer customer) {
        em.persist(customer);
        return Response.ok().entity(customer).build();
    }

    //Read - Methods
    //http://localhost:8080/usedcardealer/API/customer/getCustomers
    @GET
    @Path("getCustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers(){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
        return query.getResultList();
    }

    //http://localhost:8080/usedcardealer/API/cars/getCustomer/id
    @GET
    @Path("getCustomer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") long id) {
        return em.find(Customer.class, id);
    }

    //Update Methods


    //Delete Methods

    @DELETE
    @Transactional
    @Path("deleteCustomer/{id}")
    public void deleteCustomer(@PathParam("id") long id) {
        Customer customer = em.find(Customer.class, id);
        if(customer != null) {
            em.remove(em.contains(customer) ? customer : em.merge(customer));
        }
    }
}