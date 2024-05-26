package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.TimeSlot;
import hr.fer.infsus.kukomi.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<TimeSlot> findAllTimeSlots() {
        return timeSlotRepository.findAll();
    }
}

