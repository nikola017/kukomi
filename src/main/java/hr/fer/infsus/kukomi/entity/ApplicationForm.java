package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Prijavnica")
public class ApplicationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrijavnicaID")
    private Integer id;

    @Column(name = "Placeno", nullable = false)
    private Integer paid;

    @Column(name = "Odobrena", nullable = false)
    private Integer approved;

    @ManyToOne
    @JoinColumn(name = "IzlagacID", nullable = false)
    private Exhibitor exhibitor;

    @ManyToOne
    @JoinColumn(name = "StandID")
    private Booth booth;

    @ManyToOne
    @JoinColumn(name = "ProstorStandID")
    private BoothSpace boothSpace;

    @ManyToOne
    @JoinColumn(name = "ProstorDogadajID")
    private EventSpace eventSpace;

    @ManyToOne
    @JoinColumn(name = "DogadajID")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "TerminID")
    private TimeSlot timeSlot;




    // Konstruktori, getteri i setteri
    public ApplicationForm() {
    }

    public ApplicationForm(Integer id, Integer paid, Integer approved, Exhibitor exhibitor, Booth booth, BoothSpace boothSpace, EventSpace eventSpace, Event event, TimeSlot timeSlot) {
        this.id = id;
        this.paid = paid;
        this.approved = approved;
        this.exhibitor = exhibitor;
        this.booth = booth;
        this.boothSpace = boothSpace;
        this.eventSpace = eventSpace;
        this.event = event;
        this.timeSlot = timeSlot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public Exhibitor getExhibitor() {
        return exhibitor;
    }

    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }

    public Booth getBooth() {
        return booth;
    }

    public void setBooth(Booth booth) {
        this.booth = booth;
    }

    public BoothSpace getBoothSpace() {
        return boothSpace;
    }

    public void setBoothSpace(BoothSpace boothSpace) {
        this.boothSpace = boothSpace;
    }

    public EventSpace getEventSpace() {
        return eventSpace;
    }

    public void setEventSpace(EventSpace eventSpace) {
        this.eventSpace = eventSpace;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
