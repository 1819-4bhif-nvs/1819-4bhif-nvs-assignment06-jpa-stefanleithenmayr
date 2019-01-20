package at.htl.cardealer.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    private Car car;
    @OneToOne (cascade = CascadeType.ALL)
    private Customer customer;
    @OneToOne (cascade = CascadeType.ALL)
    private Employee employee;

    private char type; //S == Sold, B == Buyed
    private int price; //Wenn Type ein B ist, dann ist das der Einkaufspreis und wenn es ein S ist der Verkaufspreis

    private LocalDate tradeDate;

    public Trade() {
    }

    public Trade(Car car, Customer customer, Employee employee, char type, int price, LocalDate tradeDate) {
        this.car = car;
        this.customer = customer;
        this.employee = employee;
        this.type = type;
        this.price = price;
        this.tradeDate = tradeDate;
        this.car.setOwner(this.customer);
        this.customer.getCars().add(this.car);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }
}
