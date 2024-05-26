package hr.fer.infsus.kukomi.controller;

import hr.fer.infsus.kukomi.entity.ApplicationForm;
import hr.fer.infsus.kukomi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ApplicationFormController {
    @Autowired
    private ApplicationFormService applicationFormService;

    @Autowired
    private BoothSpaceService boothSpaceService;

    @Autowired
    private EventSpaceService eventSpaceService;

    @Autowired
    private TimeSlotService timeSlotService;

    @GetMapping("/apply")
    public String showApplicationForm(Model model) {
        model.addAttribute("boothSpaces", boothSpaceService.findAllAvailableBoothSpaces());
        model.addAttribute("eventSpaces", eventSpaceService.findAllEventSpaces());
        model.addAttribute("timeSlots", timeSlotService.findAllTimeSlots());
        model.addAttribute("applicationForm", new ApplicationForm());
        return "exhibitor/apply_form";
    }

    @PostMapping("/apply")
    public String submitApplicationForm(@ModelAttribute ApplicationForm applicationForm) {

        applicationFormService.submitApplicationForm(applicationForm);
        return "redirect:/apply";
    }
}