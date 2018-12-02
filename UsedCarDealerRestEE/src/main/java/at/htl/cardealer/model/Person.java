package at.htl.cardealer.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName, lastName;
    private LocalDate birth;
    private String phoneNumber;
    private String address;
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birth, String phoneNumber, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
