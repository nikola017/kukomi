package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT d FROM Event d " +
            "JOIN d.booking z " +
            "JOIN z.timeSlot t " +
            "JOIN z.eventSpace pd " +
            "JOIN pd.hall dv " +
            "JOIN d.exhibitor i " +
            "WHERE z.day = :date")
    List<Event> findByDate(@Param("date") LocalDate date);

    List<Event> findByExhibitorId(Integer izlagacID);
}
