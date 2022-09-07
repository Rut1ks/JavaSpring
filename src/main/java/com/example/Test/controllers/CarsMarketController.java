package com.example.Test.controllers;

import com.example.Test.models.CarsMarket;
import com.example.Test.models.News;
import com.example.Test.repositories.CarsMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    public String search(
            @RequestParam("name") String name,
            Model model)
    {
        List<CarsMarket> newsList = carsMarketRepository.findByName(name);
        model.addAttribute("cars",newsList);
        return "carsmarket/index";
    }


    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model)
    {
        Optional<CarsMarket> carsMarket = carsMarketRepository.findById(id);
        ArrayList<CarsMarket> carsMarketArrayList = new ArrayList<>();
        carsMarket.ifPresent(carsMarketArrayList::add);
        model.addAttribute("cars",carsMarketArrayList);
        return "carsmarket/info-cars";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model)
    {
        if(!carsMarketRepository.existsById(id))
        {
            return "redirect:/cars/";
        }
        Optional<CarsMarket> carsMarket = carsMarketRepository.findById(id);
        ArrayList<CarsMarket> carsMarketArrayList = new ArrayList<>();
        carsMarket.ifPresent(carsMarketArrayList::add);
        model.addAttribute("cars",carsMarketArrayList);
        return "carsmarket/edit-cars";
    }


    @PostMapping("/edit/{id}")
    public String editNews(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("kolichestvo") Integer kolichestvo,
            @RequestParam("cena") Integer cena,
            @RequestParam("moshnost") Integer moshnost,
            Model model)
    {
        CarsMarket carsMarket = carsMarketRepository.findById(id).orElseThrow();
        carsMarket.setName(name);
        carsMarket.setDate(date);
        carsMarket.setKolichestvo(kolichestvo);
        carsMarket.setCena(cena);
        carsMarket.setMoshnost(moshnost);
        carsMarketRepository.save(carsMarket);
        return "redirect:/cars/";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") Long id
    )
    {
        CarsMarket carsMarket = carsMarketRepository.findById(id).orElseThrow();
        carsMarketRepository.delete(carsMarket);
        return "redirect:/cars/";
    }
}
