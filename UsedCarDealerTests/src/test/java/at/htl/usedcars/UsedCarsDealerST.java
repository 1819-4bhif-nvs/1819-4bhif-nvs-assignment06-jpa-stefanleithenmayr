package at.htl.usedcars;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UsedCarsDealerST {

    private Client client;
    private WebTarget target;

    private final JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/usedcardealer/API/cars");
    }

    @Test
    public void t01_crud_carEndpoint() {
        //Post a new Car
        JsonObject vehicleJson = jsonBuilder
                .add("mileage", 137120)
                .add("firstRegistration", "2017-05-01")
                .add("isSold", true)
                .add("priceExpected", 19900)
                .add("model", Json.createObjectBuilder().add("brand", "BMW").add("model", "420d"))
                .add("from", Json.createObjectBuilder().add("firstName", "Max").add("lastName", "Mayr").add("birth", "2017-05-01").add("phoneNumber", "+123456789").add("address", "Linz").add("email","xy@xy.at")
                                            .add("customerSince", "2017-05-01"))
                .build();

        this.target = client.target("http://localhost:8080/usedcardealer/API/cars/insertCar");
        Response response = this.target
                .request()
                .post(Entity.json(vehicleJson));
        JsonObject entity = response.readEntity(JsonObject.class);
        int id = entity.getInt("id");
        System.out.println(id);
        assertThat(response.getStatus(), is(200));
        assertThat(entity.getInt("mileage"), is(137120));

        //Get Car
        this.target = client.target("http://localhost:8080/usedcardealer/API/cars/getCar/" + id);
        JsonObject car = this.target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertThat(car.getInt("mileage"), is(137120)); //Check if right car*/

        //Todo: Update Car

        //Delete new Car
        this.target = client.target("http://localhost:8080/usedcardealer/API/cars/deleteCar/" + 1);
        this.target.request().delete();
    }

    @Test
    public void t02_crud_customerEndpoint() {

    }

    @Test
    public void t03_crud_employeeEndpoint() {
        //Post a new Employee
        JsonObject employeeJson = jsonBuilder
                .add("salary", 3000.00)
                .add("socialNumber", 1234010180L)
                .add("employeedSince", "2017-05-01")
                .add("firstName", "Max")
                .add("lastName", "Mustermitarbeiter")
                .add("birth", "1995-05-01")
                .add("phoneNumber", "0645/12345678")
                .add("address", "Musterstreet 1, Musterhausen 1")
                .add("email", "m.muster@provider.net")
                .build();

        this.target = client.target("http://localhost:8080/usedcardealer/API/employees/insertEmployee");
        Response response = this.target
                .request()
                .post(Entity.json(employeeJson));
        JsonObject entity = response.readEntity(JsonObject.class);
        assertThat(response.getStatus(), is(200));
        assertThat(entity.getString("email"), is("m.muster@provider.net"));
    }
}