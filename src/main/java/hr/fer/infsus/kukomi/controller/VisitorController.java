package hr.fer.infsus.kukomi.controller;

import hr.fer.infsus.kukomi.entity.Booth;
import hr.fer.infsus.kukomi.entity.Event;
import hr.fer.infsus.kukomi.service.EventService;
import hr.fer.infsus.kukomi.service.BoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;


@Controller
public class VisitorController {
    @Autowired
    private BoothService boothService;
    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String showHomePage() {
        return "visitor/index";
    }
    @GetMapping("/booths")
    public String getBooths(@RequestParam String hall, Model model) {
        List<Booth> booths = boothService.getStandsByHall(Integer.parseInt(hall));
        for (int i = 0; i < booths.size(); i++) {
            System.out.println(booths.get(i));
        }
        model.addAttribute("booths", booths);
        return "visitor/stands";
    }

    @GetMapping("/booth/{id}")
    public String getBoothDetails(@PathVariable Integer id, Model model) {
        Booth booth = boothService.getStandById(id);
        model.addAttribute("booth", booth);
        model.addAttribute("exhibitor", booth.getExhibitor());
        model.addAttribute("boothSpace", booth.getBoothSpace());
        return "visitor/stand-details";
    }

    @GetMapping("/events")
    public String events() {;
        return "visitor/events";
    }

    @GetMapping("/events/by-date")
    public String getEventsByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, Model model) {
        List<Event> events = eventService.getEventsByDate(date);
        for (int i = 0; i < events.size(); i++) {
            System.out.println(events.get(i).toString());
        }
        model.addAttribute("events", events);
        return "visitor/eventsFragment :: eventsList";
    }

    @GetMapping("/events/{id}")
    public String getEventDetails(@PathVariable Integer id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "visitor/eventDetails";

    }

    @GetMapping("/plan")
    public String getPlan() {;
        return "visitor/eventPlan";
    }

    @GetMapping("/ticket")
    public String getTicket() {;
        return "visitor/ticket";
    }

    @GetMapping("/cosplay")
    public String getCosplay() {;
        return "visitor/cosplay";
    }
}
