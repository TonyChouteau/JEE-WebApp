package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admin extends HttpServlet {

    private final static long serialVersionUID = 1L;
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Admin avec le path " + req.getRequestURI());

        switch (uri) {
            case "/ban":
                if (mode == "GET")
                    getBan(req, resp);
                else if (mode == "POST")
                    postBan(req, resp);
                break;
            case "/unban":
                if (mode == "GET")
                    getUnban(req, resp);
                else if (mode == "POST")
                    postUnban(req, resp);
                break;
            case "/addGame":
                if (mode == "GET")
                    getAddGame(req, resp);
                else if (mode == "POST")
                    postAddGame(req, resp);
                break;
            case "/removeGame":
                if (mode == "GET")
                    getRemoveGame(req, resp);
                else if (mode == "POST")
                    postRemoveGame(req, resp);
               break;
               case "/endGame":
                   if (mode == "GET")
                       getEndGame(req, resp);
                   else if (mode == "POST")
                       postEndGame(req, resp);
                  break;
            default :
                System.out.println("URI non reconnue : " + uri);
                break;
        }

    }

    private void postEndGame(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getEndGame(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postRemoveGame(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getRemoveGame(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postAddGame(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getAddGame(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postUnban(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getUnban(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postBan(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getBan(HttpServletRequest req, HttpServletResponse resp) {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "POST");
    }
}