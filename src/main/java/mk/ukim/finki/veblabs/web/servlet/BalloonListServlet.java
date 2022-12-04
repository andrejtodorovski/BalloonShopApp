package mk.ukim.finki.veblabs.web.servlet;

import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.ShoppingCart;
import mk.ukim.finki.veblabs.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "balloonListServlet", urlPatterns = "/balloon")
public class BalloonListServlet extends HttpServlet {
    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonListServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Balloon> balloonList = balloonService.listAll();
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("balloons", balloonList);
        this.springTemplateEngine.process("listBalloons.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        req.getSession().setAttribute("color",color);
        resp.sendRedirect("/selectBalloon");
    }
}
