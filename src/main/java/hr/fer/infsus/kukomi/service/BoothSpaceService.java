package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.BoothSpace;
import hr.fer.infsus.kukomi.repository.BoothSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoothSpaceService {
    @Autowired
    private BoothSpaceRepository boothSpaceRepository;

    // Metoda za dohvat svih prostora za štandove
    public List<BoothSpace> findAllBoothSpaces() {
        return boothSpaceRepository.findAll();
    }

    // Metoda za dohvat pojedinačnog prostora za štand po ID-u
    public Optional<BoothSpace> findBoothSpaceById(Long id) {
        return boothSpaceRepository.findById(id);
    }

    public List<BoothSpace> findAvailableBoothSpaces() {
        return boothSpaceRepository.findAll().stream()
                .filter(boothSpace -> boothSpace.getOccupied() == 0)
                .collect(Collectors.toList());
    }

    // Metoda za dohvat svih dostupnih prostora za štandove
    public List<BoothSpace> findAllAvailableBoothSpaces() {
        return boothSpaceRepository.findAll().stream()
                .filter(boothSpace -> boothSpace.getOccupied() == 0)
                .collect(Collectors.toList());
    }
}
