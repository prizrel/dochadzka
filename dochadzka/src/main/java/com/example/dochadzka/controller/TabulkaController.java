package com.example.dochadzka.controller;

import com.example.dochadzka.model.Tabulka;
import com.example.dochadzka.repository.TabulkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Controller
public class TabulkaController {

    @Autowired
    private TabulkaRepository repository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("tabulka", new Tabulka());

        List<Tabulka> list = repository.findAllByOrderByDatumAsc();
        model.addAttribute("tabulkaList", list);

        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Tabulka tabulka) {
        if (tabulka.getOd() != null && tabulka.getDoTime() != null) {
            Duration duration = Duration.between(tabulka.getOd(), tabulka.getDoTime());

            if (duration.isNegative()) {
                duration = duration.plusHours(24);
            }

            tabulka.setSpolu_hod(LocalTime.ofSecondOfDay(duration.getSeconds()));
        } else {
            tabulka.setSpolu_hod(null);
        }

        repository.save(tabulka);
        return "redirect:/";
    }
}

