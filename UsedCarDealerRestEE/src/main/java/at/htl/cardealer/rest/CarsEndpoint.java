package at.htl.cardealer.rest;

import at.htl.cardealer.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cars")
public class CarsEndpoint {

    @PersistenceContext
    EntityManager em;

    //Create
    @POST
    @Path("/insertCar")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCar(Car car) {
        em.persist(car);
        return Response.ok().entity(car).build();
    }

    //Read - Methods
    //http://localhost:8080/usedcardealer/API/cars/getCars
    @GET
    @Path("/getCars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars(){
        TypedQuery<Car> query = em.createNamedQuery("Car.findAll", Car.class);
        return query.getResultList();
    }

    //http://localhost:8080/usedcardealer/API/cars/getSoldCars
    @GET
    @Path("/getSoldCars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getSoldCars(){
        TypedQuery<Car> query = em.createNamedQuery("Car.findSold", Car.class);
        return query.getResultList();
    }

    //http://localhost:8080/usedcardealer/API/cars/getCar/id
    @GET
    @Path("/getCar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") long id) {
        return em.find(Car.class, id);
    }

    //Update Methods


    //Delete Methods

    @DELETE
    @Transactional
    @Path("/deleteCar/{id}")
    public void deleteCar(@PathParam("id") long id) {
        Car car = em.find(Car.class, id);
        if(car != null) {
            em.remove(em.contains(car) ? car : em.merge(car));
        }
    }
}