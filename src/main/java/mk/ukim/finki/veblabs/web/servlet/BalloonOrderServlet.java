package mk.ukim.finki.veblabs.web.servlet;

import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.service.OrderService;
import mk.ukim.finki.veblabs.service.implementation.OrderServiceImplementation;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloonOrderServlet", urlPatterns = "/balloonOrder")
public class BalloonOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;
    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        String color = (String) req.getSession().getAttribute("color");
        String size = (String) req.getSession().getAttribute("size");
        context.setVariable("color",color);
        context.setVariable("size",size);
        springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = (String) req.getSession().getAttribute("color");
        String size = (String) req.getSession().getAttribute("size");
        String clientAddress = req.getParameter("clientAddress");
        String clientName = req.getParameter("clientName");
        Order order = orderService.placeOrder(color,clientName,clientAddress);
        order.setBalloonSize(size);
        req.getSession().setAttribute("order",order);
        orderService.addOrder(order);
        resp.sendRedirect("/confirmationInfo");
    }
}
