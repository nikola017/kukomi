package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.EventSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSpaceRepository extends JpaRepository<EventSpace, Long> {
}