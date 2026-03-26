package com.sportradar.football_calendar.controller;

import com.sportradar.football_calendar.model.Events;
import com.sportradar.football_calendar.repository.EventsRepository;
import com.sportradar.football_calendar.repository.GroupRepository;
import com.sportradar.football_calendar.repository.ResultRepository;
import com.sportradar.football_calendar.repository.StageRepository;
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
    private final GroupRepository groupRepository;
    private final StageRepository stageRepository;
    private final ResultRepository resultRepository;
    public EventsController(EventsRepository eventRepository, TeamsRepository teamsRepository,
            GroupRepository groupRepository, StageRepository stageRepository,
            ResultRepository resultRepository
            ) {
        this.eventRepository = eventRepository;
        this.teamsRepository = teamsRepository;
        this.groupRepository = groupRepository;
        this.stageRepository = stageRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/events") 
    public String listEvents(Model model) {
        // "model" to taki worek, do którego wrzucamy dane dla HTML-a
        model.addAttribute("matches", eventRepository.findAll());
        
        return "events"; // To musi być nazwa pliku HTML (bez .html)
    }
    
    @GetMapping("/events/add")
    public String showAddForm(Model model) {
    model.addAttribute("event", new Events());
    model.addAttribute("teams", teamsRepository.findAll());
    model.addAttribute("results", resultRepository.findAll());
    model.addAttribute("stages", stageRepository.findAll());
    model.addAttribute("groups", groupRepository.findAll());
    return "add-event"; 
}
    @PostMapping("/events/save")
    public String saveEvent(@ModelAttribute("event") Events event) {
    eventRepository.save(event); // Zapisujemy to, co przyszło z formularza
    return "redirect:/events"; // Po zapisie wracamy na listę meczów
}


}