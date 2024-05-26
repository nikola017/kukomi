package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProstorStand")
public class BoothSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProstorStandID")
    private Integer id;

    @Column(name = "ImeProstora", nullable = false, length = 50)
    private String name;

    @Column(name = "CijenaProstora", nullable = false)
    private Integer price;

    @Column(name = "Zauzeto", nullable = false)
    private Integer occupied;

    @ManyToOne
    @JoinColumn(name = "DvoranaID", nullable = false)
    private Hall hall;




    // Konstruktori, getteri i setteri
    public BoothSpace() {
    }

    public BoothSpace(Integer id, String name, Integer price, Integer occupied, Hall hall) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.occupied = occupied;
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

    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
