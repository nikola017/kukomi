package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {
    // Standardne CRUD operacije
    List<ApplicationForm> findByApprovedFalse();
    List<ApplicationForm> findAllByOrderByIdDesc();
    List<ApplicationForm> findAllByOrderByIdAsc();

}