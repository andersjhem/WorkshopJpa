package models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;

    @Column(unique = true, nullable = false,length = 100)
    private String username;

    @Column(nullable = false,length = 25)
    private String password;

    private LocalDate regDate;

    @OneToOne
    private Details details;

    public AppUser(int id, String username, String password, LocalDate regDate, Details details) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.details = details;
    }

    public AppUser() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public Details getDetails() {
        return details;
    }

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && Objects.equals(regDate, appUser.regDate) && Objects.equals(details, appUser.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, regDate, details);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", details=" + details +
                '}';
    }
}
