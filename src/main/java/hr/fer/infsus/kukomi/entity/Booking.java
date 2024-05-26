package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Zauzece")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ZauzeceID")
    private Integer id;

    @Column(name = "Zauzeto", nullable = false)
    private Integer occupied;

    @Column(name = "Dan")
    private LocalDate day;

    @ManyToOne
    @JoinColumn(name = "TerminID", nullable = false)
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "ProstorDogadajID", nullable = false)
    private EventSpace eventSpace;




    // Konstruktori, getteri i setteri
    public Booking() {
    }

    public Booking(Integer id, Integer occupied, LocalDate day, TimeSlot timeSlot, EventSpace eventSpace) {
        this.id = id;
        this.occupied = occupied;
        this.day = day;
        this.timeSlot = timeSlot;
        this.eventSpace = eventSpace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public EventSpace getEventSpace() {
        return eventSpace;
    }

    public void setEventSpace(EventSpace eventSpace) {
        this.eventSpace = eventSpace;
    }
}
