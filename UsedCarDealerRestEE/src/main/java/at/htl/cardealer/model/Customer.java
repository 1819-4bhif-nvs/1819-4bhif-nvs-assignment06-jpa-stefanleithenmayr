package at.htl.cardealer.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.time.LocalDate;


@NamedQuery(name = "Customer.findAll", query = "select c from Customer c join Person p on p.id = c.id")
@Entity
public class Customer extends Person {

    private LocalDate customerSince;

    public Customer(String firstName, String lastName, LocalDate birth, String phoneNumber, String address, String email, LocalDate customerSince) {
        super(firstName, lastName, birth, phoneNumber, address, email);
        this.customerSince = customerSince;
    }

    public Customer() {
    }

    public LocalDate getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(LocalDate customerSince) {
        this.customerSince = customerSince;
    }
}
