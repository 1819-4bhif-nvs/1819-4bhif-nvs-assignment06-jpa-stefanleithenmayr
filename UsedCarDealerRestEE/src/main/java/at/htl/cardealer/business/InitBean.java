package at.htl.cardealer.business;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class InitBean {

    @PersistenceContext
    EntityManager em;

    private InitBean() {
    }

    @PostConstruct
    public void init() {
        System.err.println("********** Init started");

        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Employee emp = new Employee(2500, 1234010180L, LocalDate.parse("2010-05-10", formatter), "Max",
                "Mustermann", LocalDate.parse("1980-01-10", formatter), "+12345678910", "Musterstrasse 3", "x.muster@muster.at");
        em.persist(emp);

        emp = new Employee(1750, 6789010180L, LocalDate.parse("2010-05-10", formatter), "Susi",
                "Musterfrau", LocalDate.parse("1985-01-10", formatter), "+12345678910", "Gasse 7", "x.muster@muster.at");
        em.persist(emp);

        emp = new Employee(2000,4321010180L, LocalDate.parse("2010-05-10", formatter), "Tim",
                "Mayr", LocalDate.parse("2000-01-10", formatter), "+12345678910", "Hofhausen 3", "x.muster@muster.at");
        em.persist(emp);

        Customer customer = new Customer("Franz", "Muster", LocalDate.parse("1997-03-10"), "+234524552", "Musterstraße 99", "franz.muster@muster.at", LocalDate.parse("2018-04-13", formatter));
        em.persist(customer);

        Model model = new Model("Audi", "A4");
        Car car = new Car(101032,LocalDate.parse("2014-05-01"), false, 12500, model, customer);
        em.persist(car);
        car = new Car(42351,LocalDate.parse("2017-05-01"), true, 25000, model, customer);
        em.persist(car);*/
    }
}
