package at.htl.cardealer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private String model;

    @OneToMany (mappedBy = "model", cascade = CascadeType.ALL)
    private List<Car> cars;

    //region Constructor
    public Model() {
        this.cars = new ArrayList<>();
    }

    public Model(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.cars = new ArrayList<>();
    }
    //endregion

    //region Getter and Setter Methods
    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    //endregion
}