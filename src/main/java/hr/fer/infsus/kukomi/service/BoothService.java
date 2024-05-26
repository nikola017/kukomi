package hr.fer.infsus.kukomi.service;

import hr.fer.infsus.kukomi.entity.Booth;
import hr.fer.infsus.kukomi.repository.BoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoothService {
    @Autowired
    private BoothRepository boothRepository;

    public List<Booth> getStandsByHall(Integer id) {
        return boothRepository.findByBoothSpace_Hall_Id(id);
    }

    public Booth getStandById(Integer standID) {
        return boothRepository.findById(Long.valueOf(standID)).orElse(null);
    }
}
