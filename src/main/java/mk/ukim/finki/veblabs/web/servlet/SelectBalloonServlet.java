package mk.ukim.finki.veblabs.web.servlet;


import mk.ukim.finki.veblabs.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "selectBalloonServlet", urlPatterns = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        String color = (String) req.getSession().getAttribute("color");
        context.setVariable("color",color);
        springTemplateEngine.process("selectBalloonSize.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String size = req.getParameter("size");
        req.getSession().setAttribute("size",size);
        resp.sendRedirect("/balloonOrder");
    }
}
