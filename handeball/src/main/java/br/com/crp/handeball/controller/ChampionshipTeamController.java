package br.com.crp.handeball.controller;


import br.com.crp.handeball.model.entity.Championship;
import br.com.crp.handeball.model.entity.Team;
import br.com.crp.handeball.model.repository.ChampionshipRepository;
import br.com.crp.handeball.model.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("champteam")
public class ChampionshipTeamController {


    @Autowired
    ChampionshipRepository championshipRepository;
    @Autowired
    TeamRepository teamRepository;


    @GetMapping("/form")
    public ModelAndView form(ModelMap model){
        model.addAttribute("championship", championshipRepository.findAll());
        model.addAttribute("team", teamRepository.findAll());
        return new ModelAndView("/champteam/form",model);
    }



    @PostMapping("/save")
    public ModelAndView save(Team team){

        return new ModelAndView("redirect:/champteam/list");
    }

    @PostMapping("/addstadium")
    public ModelAndView addstadium(Team team){
        Championship c = championshipRepository.findById(team.getStadium().getId()).get();
        Team t = teamRepository.findById(team.getId()).get();
        c.getTeam().add(t);
        championshipRepository.save(c);
        teamRepository.save(t);
        return new ModelAndView("redirect:/championship/list");
    }


    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        championshipRepository.existsById(id);
        return new ModelAndView("redirect:/championship/list");
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("player", championshipRepository.findById(id).get());
        return new ModelAndView("/championship/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Championship championship) {
        championshipRepository.save(championship);
        return new ModelAndView("redirect:/championship/list");
    }
}