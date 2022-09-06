package com.example.Test.controllers;

import com.example.Test.models.CarsMarket;
import com.example.Test.repositories.CarsMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarsMarketController {


    @Autowired
    private CarsMarketRepository carsMarketRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<CarsMarket> cars = carsMarketRepository.findAll();
        model.addAttribute("cars",cars);
        return "carsmarket/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "carsmarket/add-cars";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("kolichestvo") Integer kolichestvo,
            @RequestParam("cena") Integer cena,
            @RequestParam("moshnost") Integer moshnost,
            Model model)
    {
        CarsMarket carsOne = new CarsMarket(name,date,kolichestvo,cena,moshnost);
        carsMarketRepository.save(carsOne);
        return "redirect:/cars/";
    }

    @GetMapping("/search")
    public String add(
            @RequestParam("name") String name,
            Model model)
    {
        List<CarsMarket> newsList = carsMarketRepository.findByNameContains(name);
        model.addAttribute("cars",newsList);
        return "carsmarket/index";
    }

}
