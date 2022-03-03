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

        Player player = players.findByUserNameAndPassword(username,password);

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
        System.out.println("player added: " + player.getUserName());
        session.setAttribute("player",player);
        return "redirect:/";
    }

    @GetMapping("/home")
    public String options() {

        return "home";
    }

    public String options(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if (username != null) { //om nåt är satt betyder det att en inloggning har lyckats
            return "home";
        }
        return "redirect:/";
    }

    @GetMapping("/quiz")
    public String quiz(Model model,HttpSession session, @RequestParam int choice) {
        Question q = qs.getQuestion(choice);

        Player p = (Player)session.getAttribute("player");
        p.setLatestAnswer(q.getRightAnswer());
        model.addAttribute("player",p);

        session.setAttribute("choice",choice);
        model.addAttribute("question", q);

        return "quiz";
    }

    @PostMapping("/quiz")
    public String quiz(HttpSession session, Model model, @RequestParam String playerAnswer) {
            Player p = (Player) session.getAttribute("player");
            model.addAttribute("player",p);

            int choice = (int)session.getAttribute("choice");

           if (p.getLatestAnswer().equals(playerAnswer)){
                System.out.println("Correct");
                p.setPoint();
                session.setAttribute("point", p.getPoint());

            }
            else {
                System.out.println("Wrong answer!");
                if(!p.reduceAndCheckIfAlive()){
                    System.out.println("Quit game!");
                }
            }

        Question q = qs.getQuestion(choice);
        model.addAttribute("question", q);
        p.setLatestAnswer(q.getRightAnswer());

        return "quiz";
    }
}


