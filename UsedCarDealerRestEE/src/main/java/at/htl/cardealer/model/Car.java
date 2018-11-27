package at.htl.cardealer.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQueries({
        @NamedQuery(name = "Car.findAll", query = "select c from Car c"),
        @NamedQuery(name = "Car.findSold", query = "select c from Car c where c.isSold = true")
})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mileage; //Kilometerstand
    private LocalDate firstRegistration; //Erstzulassung
    private boolean isSold; //Wurde das Auto bereits verkauft
    private int priceExpected; //Erwarteter Preis
    private int priceSold;

    @OneToOne (cascade = CascadeType.ALL)
    private Model model; //Legt das Automodell fest z.B. Audi A4
    @OneToOne
    private Customer from; //Wer hat das Auto dem Händler verkauft
    @OneToOne
    private Customer to; //An wenn wird das Auto verkauft
    @OneToOne
    private Employee seller; //Wer hat das Auto vermittelt

    public Car() {
    }

    public Car(int mileage, LocalDate firstRegistration, boolean isSold, int priceExpected, Model model, Customer from) {
        this.mileage = mileage;
        this.firstRegistration = firstRegistration;
        this.isSold = isSold;
        this.priceExpected = priceExpected;
        this.model = model;
        this.from = from;
    }

    public Long getId() {
        return id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public LocalDate getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(LocalDate firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public int getPriceExpected() {
        return priceExpected;
    }

    public void setPriceExpected(int priceExpected) {
        this.priceExpected = priceExpected;
    }

    public int getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(int priceSold) {
        this.priceSold = priceSold;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Customer getFrom() {
        return from;
    }

    public void setFrom(Customer from) {
        this.from = from;
    }

    public Customer getTo() {
        return to;
    }

    public void setTo(Customer to) {
        this.to = to;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }
}
