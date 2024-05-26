package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.Event;
import hr.fer.infsus.kukomi.entity.Exhibitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExhibitorRepository extends JpaRepository<Exhibitor, Integer> {
    // Standardne CRUD operacije
}
