package hr.fer.infsus.kukomi.controller;

import hr.fer.infsus.kukomi.entity.Event;
import hr.fer.infsus.kukomi.entity.Exhibitor;
import hr.fer.infsus.kukomi.entity.Booth;
import hr.fer.infsus.kukomi.service.ExhibitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExhibitorController {
    @Autowired
    private ExhibitorService exhibitorService;

    @GetMapping("/izlagaci")
    public String getAllIzlagaci(Model model) {
        List<Exhibitor> izlagaci = exhibitorService.getAllIzlagaci();
        model.addAttribute("izlagaci", izlagaci);
        return "admin/izlagaci";
    }

    @GetMapping("/izlagaci/{id}")
    public String getIzlagacDetail(@PathVariable Integer id, Model model) {
        Exhibitor exhibitor = exhibitorService.getIzlagacById(id);
        List<Booth> booths = exhibitorService.getStandsByIzlagacId(id);
        List<Event> events = exhibitorService.getDogadajiByIzlagacId(id);

        model.addAttribute("exhibitor", exhibitor);
        model.addAttribute("booths", booths);
        model.addAttribute("events", events);

        return "admin/izlagac-detail";
    }

    @PostMapping("/izlagaciupdate")
    public String updateIzlagac(String boothName, String boothDetails, Integer boothId) {
        exhibitorService.saveIzlagac(boothName,boothDetails,boothId);
        return "redirect:/izlagaci/" + boothId;
    }

    @PostMapping("/updateBooth")
    public String updateStand(String boothName, String boothDetails, Integer boothId) {
        exhibitorService.saveStand(boothName, boothDetails, boothId);
        return "redirect:/izlagaci/" + boothId;
    }

    @PostMapping("/dogadaji/update")
    public String updateDogadaj(Event event) {
        exhibitorService.saveDogadaj(event);
        return "redirect:/izlagaci/" + event.getExhibitor().getId();
    }
}
