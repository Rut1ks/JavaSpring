package com.example.Test.controllers;



import com.example.Test.models.Games;
import com.example.Test.models.News;
import com.example.Test.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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


    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model)
    {
        Optional<Games> games = gamesRepository.findById(id);
        ArrayList<Games> gamesArrayList = new ArrayList<>();
        games.ifPresent(gamesArrayList::add);
        model.addAttribute("games",gamesArrayList);
        return "games/info-games";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model)
    {
        if(!gamesRepository.existsById(id))
        {
            return "redirect:/games/";
        }
        Optional<Games> games = gamesRepository.findById(id);
        ArrayList<Games> gamesArrayList = new ArrayList<>();
        games.ifPresent(gamesArrayList::add);
        model.addAttribute("games",gamesArrayList);
        return "games/edit-games";
    }


    @PostMapping("/edit/{id}")
    public String editNews(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("jenre") String jenre,
            @RequestParam("cena") Integer cena,
            @RequestParam("prodajKopii") Integer prodajKopii,
            Model model)
    {
        Games games = gamesRepository.findById(id).orElseThrow();
        games.setName(name);
        games.setDate(date);
        games.setJenre(jenre);
        games.setCena(cena);
        games.setProdajKopii(prodajKopii);
        gamesRepository.save(games);
        return "redirect:/games/";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") Long id
    )
    {
        Games games = gamesRepository.findById(id).orElseThrow();
        gamesRepository.delete(games);
        return "redirect:/games/";
    }

}
