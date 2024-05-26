package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Dvorana")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DvoranaID")
    private Integer id;

    @Column(name = "ImeDvorane", nullable = false, length = 50)
    private String name;




    // Konstruktori, getteri i setteri
    public Hall() {
    }

    public Hall(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
