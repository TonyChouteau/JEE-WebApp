package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admin extends HttpServlet {

    private final static long serialVersionUID = 1L;
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        System.out.println("bonjour");
        String pageName = "/profile.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("here" + req.getRequestURI());
        doProcess(req, resp);
    }

}