package br.com.crp.handeball.controller;


import br.com.crp.handeball.model.entity.Stadium;
import br.com.crp.handeball.model.entity.Team;
import br.com.crp.handeball.model.repository.StadiumRepository;
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
@RequestMapping("team")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    StadiumRepository stadiumRepository;

    @GetMapping("/form")
    public ModelAndView form(Team team, ModelMap model){
        model.addAttribute("stadium", stadiumRepository.findAll());
        return new ModelAndView("/team/form",model);
    }


    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("team", teamRepository.findAll());
        return new ModelAndView("/team/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Team team){
        Stadium s =stadiumRepository.findById(team.getStadium().getId()).get();
        team.setStadium(s);
        s.setTeam(team);
        stadiumRepository.save(s);
        teamRepository.save(team);
        return new ModelAndView("redirect:/team/list");
    }


    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        teamRepository.existsById(id);
        return new ModelAndView("redirect:/team/list");
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("team", teamRepository.findById(id).get());
        model.addAttribute("stadium", stadiumRepository.findAll());
        return new ModelAndView("/team/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Team team) {
        teamRepository.save(team);
        return new ModelAndView("redirect:/team/list");
    }

}