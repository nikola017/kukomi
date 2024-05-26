package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.Booth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoothRepository extends JpaRepository<Booth, Long> {
    // Standardne CRUD operacije
}
