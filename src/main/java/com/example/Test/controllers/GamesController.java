package com.example.Test.controllers;



import com.example.Test.models.Games;
import com.example.Test.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/games")
public class GamesController {


    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Games> games = gamesRepository.findAll();
        model.addAttribute("games",games);
        return "games/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "games/add-games";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("jenre") String jenre,
            @RequestParam("cena") Integer cena,
            @RequestParam("prodajKopii") Integer prodajKopii,
            Model model)
    {
        Games gamesOne = new Games(name,date,jenre,cena,prodajKopii);
        gamesRepository.save(gamesOne);
        return "redirect:/games/";
    }

    @GetMapping("/search")
    public String add(
            @RequestParam("name") String name,
            Model model)
    {
        List<Games> newsList = gamesRepository.findByNameContains(name);
        model.addAttribute("games",newsList);
        return "games/index";
    }

}
