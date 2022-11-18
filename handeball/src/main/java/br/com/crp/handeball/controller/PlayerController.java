package br.com.crp.handeball.controller;


import br.com.crp.handeball.model.entity.Player;
import br.com.crp.handeball.model.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Controller
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerRepository repository;


    @GetMapping("/form")
    public String form(Player player){
        return "/player/form";
    }



    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("player", repository.findAll());
        return new ModelAndView("/player/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Player player){
        repository.save(player);
        return new ModelAndView("redirect:/player/list");
    }


    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.existsById(id);
        return new ModelAndView("redirect:/player/list");
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("player", repository.findById(id).get());
        return new ModelAndView("/player/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Player player) {
        repository.save(player);
        return new ModelAndView("redirect:/player/list");
    }

}