package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.model.User;
import system.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Для регистрации пользователя
    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String userSignUpPage(Model model){
        model.addAttribute("user",new User());
        return "userSignUp";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")@Valid User user,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "userSignUp";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    // Для авторизации пользователя

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String userLoginPage(Model model){
        model.addAttribute("user",new User());
        return "userLogin";
    }

}
