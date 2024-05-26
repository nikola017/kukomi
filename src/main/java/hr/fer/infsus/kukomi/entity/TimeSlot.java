package hr.fer.infsus.kukomi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Termin")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TerminID")
    private Integer id;

    @Column(name = "Termin", nullable = false, length = 500)
    private String time;

    @Column(name = "CijenaTremina", nullable = false)
    private Integer price;




    // Konstruktori, getteri i setteri
    public TimeSlot() {
    }

    public TimeSlot(Integer id, String time, Integer price) {
        this.id = id;
        this.time = time;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
