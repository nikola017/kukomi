package hr.fer.infsus.kukomi.controller;

import hr.fer.infsus.kukomi.entity.ApplicationForm;
import hr.fer.infsus.kukomi.service.ApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminDashboardController {

    @Autowired
    private ApplicationFormService applicationFormService;

    @GetMapping("/admin/dashboard")
    public String showDashboard(Model model) {
        List<ApplicationForm> applicationForms = applicationFormService.getAllApplicationForms();
        model.addAttribute("applicationForms", applicationForms);
        return "admin/dashboard";
    }

    @PostMapping("/admin/dashboard/approve")
    public String approveApplication(@RequestParam("id") Long id) {
        applicationFormService.updateApprovalStatus(id, 1);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/admin/dashboard/reject")
    public String rejectApplication(@RequestParam("id") Long id) {
        applicationFormService.updateApprovalStatus(id, -1);
        return "redirect:/admin/dashboard";
    }
}
