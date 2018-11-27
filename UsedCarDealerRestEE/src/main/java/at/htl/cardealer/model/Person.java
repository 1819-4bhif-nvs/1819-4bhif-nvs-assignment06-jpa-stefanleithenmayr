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
}
