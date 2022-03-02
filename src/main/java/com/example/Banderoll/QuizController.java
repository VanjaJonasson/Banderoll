package com.example.Banderoll;

//com.example.Banderoll.Player
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
            if (username.equals(uname) && password.equals(pass)){
                session.setAttribute("username", username);
                return "redirect:/home";
            }

        } return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse res){ //ber om responsobjekt
        session.invalidate();
        Cookie cookie = new Cookie("JSESSIONID", ""); //städa bort cookien med värde ingenting ""
        cookie.setMaxAge(0);//cookien får leva maximalt 0 tidsenheter
        res.addCookie(cookie);
        return "login";
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


    @GetMapping("/home")
    public String options(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if (username != null) { //om nåt är satt betyder det att en inloggning har lyckats
            return "home";
        }
        return "redirect:/";
    }


    //ny


    @GetMapping("/quiz")
    public String quiz(Model model, @RequestParam(required=true) int choice) {

        Question q = new Question(choice);
        model.addAttribute("question", q);
        model.addAttribute("choice", choice);

        return "quiz";
    }



    //@ModelAttribute


/*
    public String quiz(HttpSession session, Model model, @RequestBody(required=false) Question question,
                       @PathVariable(required=false) int choice, @PathVariable String a) {


 */
    //flexradiodefault playerAnswer-requestparam
    @PostMapping("/quiz")
    public String quiz(Model model, String playerAnswer, @RequestParam(required=true) int choice) {

        if (!question.equals(null)) {
            if (question.getCorrectAnswer("playerAnswer")){

            }
        }

        System.out.println(choice);
        Question q = new Question(choice);
        //String s = q.getQuestion();
        //String[] answers = q.getAnswers();
        model.addAttribute("question", q);
        model.addAttribute("choice", choice);
        //model.addAttribute("question", s);
        //model.addAttribute("answers", answers);




        return "quiz";
    }




    }


