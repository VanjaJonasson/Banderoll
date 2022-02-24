package com.example.Banderoll;

//com.example.Banderoll.Player
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {


   // @Autowired
   // Country country;


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
    public String quiz(){

        return "quiz";
    }

    @GetMapping("/flags")
    public String flags(){

        return "flags";
    }

    @PostMapping("/flags/{numq}")
    public String flaggame(HttpSession session, Model model, @RequestParam int numq){
        model.addAttribute("numq", numq);

        return "flags";
    }




    }


