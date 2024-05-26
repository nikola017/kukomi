package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Stand")
public class Booth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StandID")
    private Integer id;

    @Column(name = "ImeStanda", nullable = false, length = 500)
    private String name;

    @Column(name = "DetaljiStanda", nullable = false, length = 2000)
    private String details;

    @ManyToOne
    @JoinColumn(name = "IzlagacID", nullable = false)
    private Exhibitor exhibitor;

    @ManyToOne
    @JoinColumn(name = "ProstorStandID", nullable = false)
    private BoothSpace boothSpace;




    // Konstruktori, getteri i setteri
    public Booth() {
    }

    public Booth(Integer id, String name, String details, Exhibitor exhibitor, BoothSpace boothSpace) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.exhibitor = exhibitor;
        this.boothSpace = boothSpace;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Exhibitor getExhibitor() {
        return exhibitor;
    }

    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }

    public BoothSpace getBoothSpace() {
        return boothSpace;
    }

    public void setBoothSpace(BoothSpace boothSpace) {
        this.boothSpace = boothSpace;
    }
}

