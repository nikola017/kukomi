package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Izlagac")
public class Exhibitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IzlagacID")
    private Integer id;

    @Column(name = "ImeIzlagaca", nullable = false, length = 500)
    private String name;

    @Column(name = "Kompanija", length = 500)
    private String company;

    @Column(name = "Email", nullable = false, length = 500)
    private String email;

    @Column(name = "Telefon", length = 50)
    private String phone;




    // Konstruktori, getteri i setteri
    public Exhibitor() {
    }

    public Exhibitor(Integer id, String name, String company, String email, String phone) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

