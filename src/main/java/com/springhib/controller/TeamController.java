
package com.springhib.controller;

import com.springhib.model.Team;
import com.springhib.service.TeamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {
    
    @Autowired
    private TeamService teamService;
    
    @RequestMapping(value="/team/add")
    public ModelAndView addTeamPage(){
        
        ModelAndView modelAndView = new ModelAndView("add-team-form");
        
        modelAndView.addObject("team", new Team());
        
        return modelAndView;
        
    }
    
    @RequestMapping(value="/team/add/process")
    public ModelAndView addingTeam(@ModelAttribute Team team){
        
        ModelAndView modelAndView = new ModelAndView("home");
        
        teamService.addTeam(team);
        
        String message = "Team successfully added.";
        
        modelAndView.addObject("message", message);
        
        return modelAndView;
        
    }
    
    @RequestMapping(value="/team/list")
    public ModelAndView listOfTeams(){
        
        ModelAndView modelAndView = new ModelAndView("list-of-teams");
        
        List<Team> teams= teamService.getTeams();
        modelAndView.addObject("teams", teams);
        
        return modelAndView;
        
        
    }
    
    @RequestMapping(value="/team/edit/{id}", method= RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id){
        
        ModelAndView modelAndView = new ModelAndView("edit-team-form");
        
        Team team = teamService.getTeam(id);
        
        modelAndView.addObject("team", team);
        
        return modelAndView;
        
    }
    
    @RequestMapping(value="/team/edit/{id}", method= RequestMethod.POST)
    public ModelAndView editingTeam(@ModelAttribute Team team, @PathVariable Integer id){
        
        ModelAndView modelAndView = new ModelAndView("home");
        
        teamService.updateTeam(team);
        
        String message = "Team was successfully edited.";
        
        modelAndView.addObject("message", message);
        
        return modelAndView;
        
    }
    
    public ModelAndView deleteTeam(@PathVariable Integer id){
        
        ModelAndView modelAndView = new ModelAndView("home");
        
        teamService.deleteTeam(id);
        
        String message = "Team successfully deleted.";
        
        modelAndView.addObject("message", message);
        
        return modelAndView;
        
    }
    
    
}
