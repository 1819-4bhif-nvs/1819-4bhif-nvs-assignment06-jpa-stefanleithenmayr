package at.htl.cardealer.rest;

import at.htl.cardealer.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cars")
public class CarsEndpoint {

    @PersistenceContext
    EntityManager em;


    //http://localhost:8080/usedcardealer/API/cars/getCars
    @GET
    @Path("getCars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars(){
        TypedQuery<Car> query = em.createNamedQuery("Car.findAll", Car.class);
        return query.getResultList();
    }

    //http://localhost:8080/usedcardealer/API/cars/getSoldCars
    @GET
    @Path("getSoldCars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getSoldCars(){
        TypedQuery<Car> query = em.createNamedQuery("Car.findSold", Car.class);
        return query.getResultList();
    }

    @POST
    @Path("insertCar")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void insertCar(Car car) {
        em.persist(car);
    }
}