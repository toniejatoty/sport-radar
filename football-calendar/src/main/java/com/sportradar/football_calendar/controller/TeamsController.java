package com.sportradar.football_calendar.controller;

import com.sportradar.football_calendar.model.Teams;
import com.sportradar.football_calendar.repository.TeamsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamsController {

    private final TeamsRepository teamsRepository;

    public TeamsController(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @GetMapping("/teams")
    public String listTeams(Model model) {
        model.addAttribute("team", teamsRepository.findAll());
        return "Team";
    }

    @GetMapping("/teams/add")
    public String showAddForm(Model model) {
        model.addAttribute("team", new Teams());
        return "add-teams";
    }

    @PostMapping("/teams/save")
    public String saveTeam(@ModelAttribute("team") Teams team) {
        teamsRepository.save(team);
        return "redirect:/teams";
    }

}
