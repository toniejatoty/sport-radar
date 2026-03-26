package com.sportradar.football_calendar.controller;

import com.sportradar.football_calendar.model.Events;
import com.sportradar.football_calendar.repository.EventsRepository;
import com.sportradar.football_calendar.repository.TeamsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventsController {

    private final EventsRepository eventRepository;
    private final TeamsRepository teamsRepository;
    public EventsController(EventsRepository eventRepository, TeamsRepository teamsRepository) {
        this.eventRepository = eventRepository;
        this.teamsRepository = teamsRepository;
    }

    @GetMapping("/events") 
    public String listEvents(Model model) {
        // "model" to taki worek, do którego wrzucamy dane dla HTML-a
        model.addAttribute("matches", eventRepository.findAll());
        
        return "events"; // To musi być nazwa pliku HTML (bez .html)
    }
    
    @GetMapping("/events/add")
    public String showAddForm(Model model) {
    model.addAttribute("event", new Events()); // Przekazujemy pusty obiekt do wypełnienia
    model.addAttribute("teams", teamsRepository.findAll()); // Lista drużyn do wyboru w <select>
    return "add-event"; // Nazwa pliku HTML
}
    @PostMapping("/events/save")
    public String saveEvent(@ModelAttribute("event") Events event) {
    eventRepository.save(event); // Zapisujemy to, co przyszło z formularza
    return "redirect:/events"; // Po zapisie wracamy na listę meczów
}


}