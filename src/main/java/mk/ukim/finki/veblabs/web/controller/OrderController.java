package mk.ukim.finki.veblabs.web.controller;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.service.OrderService;
import mk.ukim.finki.veblabs.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    public OrderController(OrderService orderService, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String viewOrders(@RequestParam(required = false) String error, Model model, HttpServletRequest request) {
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        String username = (String) request.getSession().getAttribute("username");
        List<Order> orders;
        try {
            orders = orderService.searchByClient(username);
        } catch (NonExistentUserException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("orders",orders);
//       model.addAttribute("color",request.getSession().getAttribute("color"));
        return "listOrders";
    }
}
