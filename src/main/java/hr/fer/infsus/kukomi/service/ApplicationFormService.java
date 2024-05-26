package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.ApplicationForm;
import hr.fer.infsus.kukomi.entity.Exhibitor;
import hr.fer.infsus.kukomi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationFormService {
    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Autowired
    private BoothRepository boothRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ExhibitorRepository exhibitorRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void submitApplicationForm(ApplicationForm form) {
        Exhibitor exhibitor = form.getExhibitor();
        form.setPaid(0);
        form.setApproved(0);

        if (exhibitor.getId() == null) {
            // Generiraj sljedeći ID ručno
            Integer nextId = jdbcTemplate.queryForObject("SELECT MAX(IzlagacID) + 1 FROM Izlagac", Integer.class);
            if (nextId == null) {
                nextId = 1; // Postavi na 1 ako je tablica prazna
            }
            exhibitor.setId(nextId);
            exhibitor = exhibitorRepository.save(exhibitor);
        }

        System.out.println("Exhibitor after save: " + exhibitor); // Debug log
        form.setExhibitor(exhibitor);
        if (form.getBooth().getName() != null) {
            form.getBooth().setExhibitor(exhibitor);
        }
        if (form.getEvent().getName() != null) {
            form.getEvent().setExhibitor(exhibitor);
        }
        applicationFormRepository.save(form);
    }

    // Metoda za dohvat svih prijavnica, ako je potrebno
    public List<ApplicationForm> getAllApplicationForms() {
        return applicationFormRepository.findAll();
    }

    @Transactional
    public void updateApprovalStatus(Long id, int status) {
        ApplicationForm applicationForm = applicationFormRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid application form ID: " + id));
        applicationForm.setApproved(status);
        applicationFormRepository.save(applicationForm);
    }
}

