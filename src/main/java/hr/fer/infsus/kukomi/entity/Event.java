package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Događaj")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DogadajID")
    private Integer id;

    @Column(name = "ImeDogađaja", nullable = false, length = 500)
    private String name;

    @Column(name = "DetaljiDogađaja", nullable = false, length = 2000)
    private String details;

    @Column(name = "TipDoađaja", nullable = false, length = 200)
    private String eventType;

    @ManyToOne
    @JoinColumn(name = "ZauzećeID", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "IzlagacID", nullable = false)
    private Exhibitor exhibitor;




    // Konstruktori, getteri i setteri
    public Event() {
    }

    public Event(Integer id, String name, String details, String eventType, Booking booking, Exhibitor exhibitor) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.eventType = eventType;
        this.booking = booking;
        this.exhibitor = exhibitor;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Exhibitor getExhibitor() {
        return exhibitor;
    }

    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }
}
