package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.Booth;
import hr.fer.infsus.kukomi.entity.Event;
import hr.fer.infsus.kukomi.entity.Exhibitor;
import hr.fer.infsus.kukomi.repository.BoothRepository;
import hr.fer.infsus.kukomi.repository.EventRepository;
import hr.fer.infsus.kukomi.repository.ExhibitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitorService {
    @Autowired
    private ExhibitorRepository exhibitorRepository;
    @Autowired
    private BoothRepository boothRepository;
    @Autowired
    private EventRepository eventRepository;

    public List<Exhibitor> findAllExhibitors() {
        return exhibitorRepository.findAll();
    }

    public List<Exhibitor> getAllIzlagaci() {
        return exhibitorRepository.findAll();
    }

    public Exhibitor getIzlagacById(Integer id) {
        return exhibitorRepository.findById(id).orElse(null);
    }

    public List<Booth> getStandsByIzlagacId(Integer izlagacID) {
        return boothRepository.findByExhibitorId(izlagacID);
    }

    public List<Event> getDogadajiByIzlagacId(Integer izlagacID) {
        return eventRepository.findByExhibitorId(izlagacID);
    }

    @Transactional
    public void saveIzlagac(String name, String details, Integer id) {
        eventRepository.updateNameAndDetailsById(id, name, details);
    }


    @Transactional
    public void saveStand(String name, String details, Integer id) {

        boothRepository.updateNameAndDetailsById(name,details,id);
    }

    public void saveDogadaj(Event event) {
        eventRepository.save(event);
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