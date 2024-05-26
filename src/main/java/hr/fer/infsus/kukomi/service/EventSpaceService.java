package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.EventSpace;
import hr.fer.infsus.kukomi.repository.EventSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventSpaceService {
    @Autowired
    private EventSpaceRepository eventSpaceRepository;

    public List<EventSpace> findAllEventSpaces() {
        return eventSpaceRepository.findAll();
    }

    public Optional<EventSpace> findEventSpaceById(Long id) {
        return eventSpaceRepository.findById(id);
    }
}
