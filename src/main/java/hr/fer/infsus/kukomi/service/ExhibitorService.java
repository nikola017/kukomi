package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.Exhibitor;
import hr.fer.infsus.kukomi.repository.ExhibitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitorService {
    @Autowired
    private ExhibitorRepository exhibitorRepository;

    public List<Exhibitor> findAllExhibitors() {
        return exhibitorRepository.findAll();
    }

    public Exhibitor saveExhibitor(Exhibitor exhibitor) {
        if (exhibitor.getName() == null || exhibitor.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return exhibitorRepository.save(exhibitor);
    }

    public Optional<Exhibitor> findExhibitorById(Integer id) {
        return exhibitorRepository.findById(id);
    }

    public void deleteExhibitor(Integer id) {
        exhibitorRepository.deleteById(id);
    }
}