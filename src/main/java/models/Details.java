package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Details {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique=true)
    private String email;

    @Column(nullable=false ,length = 100)
    private String name;
    private LocalDate birthdate;


    public Details(int id, String email, String name, LocalDate birthdate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Details() {

    }

    private int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return id == details.id && Objects.equals(email, details.email) && Objects.equals(name, details.name) && Objects.equals(birthdate, details.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, birthdate);
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }


}
