package hr.fer.infsus.kukomi.repository;

import hr.fer.infsus.kukomi.entity.Booth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoothRepository extends JpaRepository<Booth, Long> {
    // Standardne CRUD operacije
    List<Booth> findByBoothSpace_Hall_Id(Integer hallId);
    List<Booth> findByExhibitorId(Integer izlagacID);

    @Modifying
    @Query("UPDATE Booth b SET b.name = :name, b.details = :details WHERE b.id = :id")
    void updateNameAndDetailsById(@Param("name") String name, @Param("details") String details, @Param("id") Integer id);
}
