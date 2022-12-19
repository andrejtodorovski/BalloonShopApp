package mk.ukim.finki.veblabs.web.controller;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.User;
import mk.ukim.finki.veblabs.service.OrderService;
import mk.ukim.finki.veblabs.service.ShoppingCartService;
import mk.ukim.finki.veblabs.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    public OrderController(OrderService orderService , UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String viewOrders(@RequestParam(required = false) String error, Model model, HttpServletRequest request) {
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        // String username = (String) request.getSession().getAttribute("username");
        String username = request.getRemoteUser();
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
    @GetMapping("/filtered")
    public String viewFilteredOrders(Model model, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                                     @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo, HttpServletRequest request)
    {

/*        String dateFrom = request.getParameter("dateFrom");
        String dateTo =  request.getParameter("dateTo");
        LocalDateTime from=LocalDateTime.parse(dateFrom);
        LocalDateTime to=LocalDateTime.parse(dateTo);*/
        User user = null;
        try {
            user = userService.findByUsername(request.getRemoteUser());
        } catch (NonExistentUserException e) {
            throw new RuntimeException(e);
        }
        List<Order> orders=orderService.findByDateCreatedBetween(dateFrom,dateTo,user);
        model.addAttribute("orders",orders);
        return "filteredOrders";
    }
}
