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
    Question question;

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

    /*
    @GetMapping("/quiz")
    public String options() {
        return "quiz";
    }

     */

    //@ModelAttribute

    //(@RequestParam(required=false, defaultValue = "World") String param1)


    @PostMapping("/quiz/{choice}")
    public String quiz(HttpSession session, Model model, @RequestBody(required=false) Question question,
                       @PathVariable(required=false) int choice, @PathVariable String a) {
        Question q = new Question(choice);
        String s = q.getQuestion();
        String[] answers = q.getAnswers();
        model.addAttribute("question", s);
        model.addAttribute("answers", answers);

        if (!q.equals(null)) {
            if (??.equals(q.getAnswers());
        }
        return "quiz";
    }




 /*

    @GetMapping("/capital")
    public String capitals(Model model) {
        Question q = new Question(2);
        String s = q.getQuestion();
        String[] answers = q.getAnswers();
        model.addAttribute("question", s);
        model.addAttribute("answers", answers);
        return "capital";
    }



    @GetMapping("/country")
    public String country(Model model) {
        Question q = new Question(1);
        String s = q.getQuestion();
        String[] answers = q.getAnswers();
        model.addAttribute("question", s);
        model.addAttribute("answers", answers);
        return "country";
    }

    @GetMapping("/flag")
    public String flag(Model model) {
        Question q = new Question(3);
        String s = q.getQuestion();
        String[] answers = q.getAnswers();
        model.addAttribute("question", s);
        model.addAttribute("answers", answers);
        return "flag";
    }

    //String givenanswer = null;
    //session.setAttribute("givenanswer", givenanswer);

  */








    }


