package ute.edu.java.corte2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ute.edu.java.corte2.model.User;
import ute.edu.java.corte2.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/new")
    public String createUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "/views/user/create";
    }

    @GetMapping("/")
    public String getAllUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/views/user/list";
    }

    @GetMapping("/list/{idUsuario}")
    public String getUserById(Model model, @PathVariable int idUsuario){
        User user = userService.searchUserById(idUsuario);
        model.addAttribute("user", user);
        return "/views/user/edit";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.createUser(user);
        return "redirect:/user/";
    }

    @PostMapping("/delete/{idUsuario}")
    public String delete(@PathVariable int idUsuario){
        userService.deleteUser(idUsuario);
        return "redirect:/user/";
    }
}
