package mk.ukim.finki.veblabs.web.controller;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.ShoppingCart;
import mk.ukim.finki.veblabs.model.User;
import mk.ukim.finki.veblabs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String showLoginPage(){
        return "login";
    }
    @PostMapping
    public String loginUser(@RequestParam String username,
                           @RequestParam String password,
                           Model model , HttpServletRequest request){
        User u;
        try{
            u=userService.login(username,password);
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("user",u);
            ShoppingCart shoppingCart = new ShoppingCart(u);
            request.getSession().setAttribute("cartId",shoppingCart.getId());
            return "redirect:/balloons";
        }
        catch(NonExistentUserException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";

        }
    }

}