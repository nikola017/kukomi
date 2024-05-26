package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProstorDogađaj")
public class EventSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProstorDogadajID")
    private Integer id;

    @Column(name = "ImeProstora", nullable = false, length = 200)
    private String name;

    @Column(name = "CijenaProstora", nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "DvoranaID", nullable = false)
    private Hall hall;




    // Konstruktori, getteri i setteri
    public EventSpace() {
    }

    public EventSpace(Integer id, String name, Integer price, Hall hall) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.hall = hall;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
