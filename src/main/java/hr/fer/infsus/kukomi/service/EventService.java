package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.Event;
import hr.fer.infsus.kukomi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }

    public Event getEventById(Integer dogadjajId) {
        return eventRepository.findById(Long.valueOf(dogadjajId)).orElse(null);
    }
}
