package com.sportradar.football_calendar.controller;
import com.sportradar.football_calendar.model.Result;
import com.sportradar.football_calendar.repository.ResultRepository;
import com.sportradar.football_calendar.repository.TeamsRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultsController {

    private final ResultRepository resultRepository;
    private final TeamsRepository teamRepository;
    public ResultsController( ResultRepository resultRepository, TeamsRepository teamRepository) {
        this.resultRepository = resultRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/results") 
    public String listTeams(Model model) {
        model.addAttribute("result", resultRepository.findAll());
        return "Result"; 
    }
    
    @GetMapping("/result/add")
    public String showAddForm(Model model) {
    model.addAttribute("result", new Result());
    model.addAttribute("teams", teamRepository.findAll()); 
    return "add-result"; 
}
    @PostMapping("/results/save")
    public String saveTeam (@ModelAttribute("result") Result result) {
    resultRepository.save(result); 
    return "redirect:/events"; 
}


}