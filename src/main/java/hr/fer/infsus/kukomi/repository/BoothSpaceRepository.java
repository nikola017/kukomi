package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.BoothSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoothSpaceRepository extends JpaRepository<BoothSpace, Long> {
    List<BoothSpace> findByOccupiedFalse();
}
