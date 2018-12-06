package at.htl.cardealer.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e"),
})
public class Employee extends Person{

    private double salary;
    private Long socialNumber;
    private LocalDate employeedSince;

    //region Constructur
    public Employee() {
    }

    public Employee(double salary, Long socialNumber, LocalDate employeedSince, String firstName, String lastName, LocalDate birth, String phoneNumber, String address, String email) {
        super(firstName, lastName, birth, phoneNumber, address, email);
        this.salary = salary;
        this.socialNumber = socialNumber;
        this.employeedSince = employeedSince;
    }
    //endregion

    //region Getter and Setter Methods
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(Long socialNumber) {
        this.socialNumber = socialNumber;
    }

    public LocalDate getEmployeedSince() {
        return employeedSince;
    }

    public void setEmployeedSince(LocalDate employeedSince) {
        this.employeedSince = employeedSince;
    }
    //endregion
}
