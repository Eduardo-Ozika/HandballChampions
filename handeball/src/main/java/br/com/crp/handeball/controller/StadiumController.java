package br.com.crp.handeball.controller;


import br.com.crp.handeball.model.entity.Stadium;
import br.com.crp.handeball.model.repository.StadiumRepository;
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
@RequestMapping("stadium")
public class StadiumController {

    @Autowired
    StadiumRepository repository;


    @GetMapping("/form")
    public String form(Stadium stadium){
        return "/stadium/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("stadium", repository.findAll());
        return new ModelAndView("/stadium/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Stadium stadium){
        repository.save(stadium);
        return new ModelAndView("redirect:/stadium/list");
    }


    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.existsById(id);
        return new ModelAndView("redirect:/stadium/list");
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("stadium", repository.findById(id).get());
        return new ModelAndView("/stadium/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Stadium stadium) {
        repository.save(stadium);
        return new ModelAndView("redirect:/stadium/list");
    }

}