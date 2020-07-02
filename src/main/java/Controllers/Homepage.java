package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="WelcomeController", urlPatterns = "/homepage")
public class Homepage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String str = session.getAttribute("login").toString();
//        System.out.println(str);
//        PrintWriter writer = resp.getWriter();
//         writer.print("Welcome " + str);
        session.setAttribute("message",str);
        RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(req,resp);
    }
}
