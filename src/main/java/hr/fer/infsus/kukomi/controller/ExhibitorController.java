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
        List<Event> dogadaji = exhibitorService.getDogadajiByIzlagacId(id);

        model.addAttribute("izlagac", exhibitor);
        model.addAttribute("stands", booths);
        model.addAttribute("dogadaji", dogadaji);

        return "admin/izlagac-detail";
    }

    @PostMapping("/izlagaci/update")
    public String updateIzlagac(Exhibitor exhibitor) {
        exhibitorService.saveIzlagac(exhibitor);
        return "redirect:/izlagaci/" + exhibitor.getId();
    }

    @PostMapping("/stands/update")
    public String updateStand(Booth booth) {
        exhibitorService.saveStand(booth);
        return "redirect:/izlagaci/" + booth.getExhibitor().getId();
    }

    @PostMapping("/dogadaji/update")
    public String updateDogadaj(Event event) {
        exhibitorService.saveDogadaj(event);
        return "redirect:/izlagaci/" + event.getExhibitor().getId();
    }
}
