package com.hoaiphung.controller;

import com.hoaiphung.model.User;
import com.hoaiphung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@ModelAttribute("user")User user, HttpSession session){
        User userdb = userService.findAllByName(user.getName());
        if ((userdb !=null)&&(userdb.getName().equals(user.getName()))&& (userdb.getPassword().equals(user.getPassword()))){
            session.setAttribute("myUser", user.getName());
            return "redirect:/categories";
        }else {
            return "redirect:/index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/index";
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/index/index");
        modelAndView.addObject("message","register success");
        return  modelAndView;
    }

}
