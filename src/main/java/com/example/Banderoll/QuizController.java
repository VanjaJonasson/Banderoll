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
    PlayerRepository players;

    @Autowired
    QuestionService qs;

    @GetMapping("/")
    public String start() {
        return "login";
    }


    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {

        //Player player = players.findByUserNameAndPassword(username,password);
        Player player = new Player("","");
        if(player != null){
            session.setAttribute("player",player);
            return "redirect:/home";
        }
        return "login";
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
        players.save(player);
        //System.out.println("player added: " + player.getUserName());
        session.setAttribute("player",player);
        return "redirect:/";
    }

    @GetMapping("/home")
    public String options() {

        return "home";
    }

    @GetMapping("/quiz")
    public String quiz(Model model,HttpSession session, @RequestParam(required = false) Integer choice,
                       @RequestParam(required = false, defaultValue = "true") boolean answered) {
        int choiceTmp;
        if(choice != null) {
            choiceTmp = choice;
        }
        else{
            choiceTmp = (int)session.getAttribute("choice");
            if(!answered){
                Player p = (Player)session.getAttribute("player");
                if(!p.reduceAndCheckIfAlive()){
                    System.out.println("Quit game!");
                    return "finished";
                }
            }
        }

        Question q = qs.getQuestion(choiceTmp);
        Player p = (Player)session.getAttribute("player");
        p.setLatestAnswer(q.getRightAnswer());
        model.addAttribute("player",p);

        session.setAttribute("choice",choiceTmp);
        model.addAttribute("question", q);

        return "quiz";
    }

    @PostMapping("/quiz")
    public String quiz(HttpSession session, Model model, @RequestParam(required = false) String playerAnswer) {
        Player p = (Player) session.getAttribute("player");
        model.addAttribute("player",p);
        int choice = (int) session.getAttribute("choice");

            System.out.println("Not Answered!");
            p.reduceAndCheckIfAlive();

            if (p.getLatestAnswer().equals(playerAnswer)) {
                System.out.println("Correct");
                p.setPoint();
                session.setAttribute("point", p.getPoint());

            } else {
                System.out.println("Wrong answer!");
                if (!p.reduceAndCheckIfAlive()) {
                    System.out.println("Quit game!");
                    return "finished";
                }
            }

        Question q = qs.getQuestion(choice);
        model.addAttribute("question", q);
        p.setLatestAnswer(q.getRightAnswer());
        return "quiz";
    }
    @GetMapping("/finished")
    public String finished(Model model,HttpSession session) {
        Player p = (Player)session.getAttribute("player");
        model.addAttribute("player",p);
        p.getPoint();
        p.getLives();

        return "finished";
    }
}


