package com.example.Banderoll;

//com.example.Banderoll.Player
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {


    @Autowired
    Country country;

    @Autowired
    CountryRepository countries;

    @Autowired
    Player player;

    @Autowired
    PlayerRepository players;

    @GetMapping("/")
    public String start() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {

        List<Player> list = players.getPlayers();
        System.out.println(list.get(0).getUsername());
        for (int i = 0; i < list.size(); i++) {
            String uname = list.get(i).getUsername();
            String pass = list.get(i).getPassword();
            if (username.equals(uname) && password.equals(pass)) {
                return "redirect:/quiz";
            }
        }

        if (username.equals("admin") && password.equals("123")) {
            return "redirect:/quiz";
        }

        return "redirect:/";

    }


    @GetMapping("/player")
    public String player() {
        return "player";
    }


    @PostMapping("/player")
    public String createPlayer(HttpSession session, @RequestParam String username, @RequestParam String password){
        Player player = new Player(username, password);
        players.addPlayer(player);
        System.out.println("player added: " + player.getUsername());
        return "redirect:/";
    }

    @GetMapping("/quiz")
    public String quiz() {
        return "quiz";
    }

    @PostMapping("/quiz")
    public String quiz(Model model){
        List<Country> list = countries.getCountries();
        model.addAttribute("country", list.get(0).getCapital());
        model.addAttribute("num1", list.get(1).getCapital());
        model.addAttribute("num2", list.get(2).getCapital());
        return "quiz";
    }

/*
    @PostMapping("/quiz/{numq}")
    public String game(@ModelAttribute Country country, Model model, HttpSession session, @PathVariable Integer numq){
        List<Country> list = countries.getCountries();
        model.addAttribute("countries", list);


        return "redirect:/quiz";
    }

 */


    }


