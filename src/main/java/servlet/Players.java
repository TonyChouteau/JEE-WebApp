package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (
    name = "players",
    urlPatterns = {
       "/player/*",
       "/listPlayers",
       "/getListPlayers"
    }
)
public class Players extends HttpServlet {
    
    private final static long serialVersionUID = 1L;
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Players avec le path " + req.getRequestURI());
    }

    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }
}