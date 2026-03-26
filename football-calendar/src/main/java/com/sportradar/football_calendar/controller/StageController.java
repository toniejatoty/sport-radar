package com.sportradar.football_calendar.controller;
import com.sportradar.football_calendar.model.Stage;
import com.sportradar.football_calendar.repository.StageRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StageController {

    private final StageRepository stageRepository;
    public StageController( StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    @GetMapping("/stage") 
    public String listTeams(Model model) {
        model.addAttribute("stage", stageRepository.findAll());
        return "Stage"; 
    }
    
    @GetMapping("/stage/add")
    public String showAddForm(Model model) {
    model.addAttribute("stage", new Stage()); 
    return "add-stage"; 
}
    @PostMapping("/stage/save")
    public String saveTeam (@ModelAttribute("stage") Stage stage) {
    stageRepository.save(stage); 
    return "redirect:/stage"; 
}


}