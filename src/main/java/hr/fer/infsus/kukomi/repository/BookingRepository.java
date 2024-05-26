package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
