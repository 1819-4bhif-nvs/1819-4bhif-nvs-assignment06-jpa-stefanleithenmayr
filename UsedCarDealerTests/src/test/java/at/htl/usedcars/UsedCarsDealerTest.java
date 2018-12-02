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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UsedCarsDealerTest {

    private Client client;
    private WebTarget target;

    private final JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/usedcardealer/API/cars/insertCar");
    }

    //.add("address", factory.createObjectBuilder()
    //         .add("streetAddress", "21 2nd Street")
    //         .add("city", "New York")
    //         .add("state", "NY")
    //         .add("postalCode", "10021"))
    @Test
    public void t01_fetchCars() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        JsonObject vehicleJson = jsonBuilder
                .add("mileage", 137120)
                .add("firstRegistration", "2017-05-01")
                .add("isSold", true)
                .add("priceExpected", 19900)
                .add("model", Json.createObjectBuilder().add("brand", "BMW").add("model", "420d"))
                .add("from", Json.createObjectBuilder().add("firstName", "Max").add("lastName", "Mayr").add("birth", "2017-05-01").add("phoneNumber", "+123456789").add("address", "Linz").add("email","xy@xy.at")
                                            .add("customerSince", "2017-05-01"))
                .build();

        this.target
                .request()
                .post(Entity.json(vehicleJson));
        //assertThat(response.getStatus(), is(204));

        /*response = this.target.request(MediaType.APPLICATION_JSON).get();//.readEntity(JsonArray.class);
        JsonArray cars = response.readEntity(JsonArray.class);
        JsonObject firstCar = cars.get(0).asJsonObject();
        JsonObject model = firstCar.getJsonObject("model");
        assertThat(model.getString("brand"), is("Audi"));*/
    }
}