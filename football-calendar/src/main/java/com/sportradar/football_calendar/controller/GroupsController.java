package com.sportradar.football_calendar.controller;

import com.sportradar.football_calendar.model.Group;
import com.sportradar.football_calendar.repository.GroupRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupsController {

    private final GroupRepository groupsRepository;

    public GroupsController(GroupRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    @GetMapping("/groups")
    public String listTeams(Model model) {
        model.addAttribute("group", groupsRepository.findAll());
        return "Group";
    }

    @GetMapping("/groups/add")
    public String showAddForm(Model model) {
        model.addAttribute("group", new Group());
        return "add-group";
    }

    @PostMapping("/groups/save")
    public String saveTeam(@ModelAttribute("group") Group group) {
        groupsRepository.save(group);
        return "redirect:/events";
    }

}
