package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Players extends HttpServlet {
    
    private final static long serialVersionUID = 1L;
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Players avec le path " + req.getRequestURI());
        
        switch (uri) {
            case "/play":
                if (mode == "GET")
                    getPlayer(req, resp);
                else if (mode == "POST")
                    postPlayer(req, resp);
                break;
            case "/currentGames":
                if (mode == "GET")
                    getListPlayers(req, resp);
                else if (mode == "POST")
                    postListPlayers(req, resp);
                break;
            case "/getCurrentGames":
                if (mode == "GET")
                    getGetListPlayers(req, resp);
                else if (mode == "POST")
                    postGetListPlayers(req, resp);
                break;
            default :
                System.out.println("URI non reconnue : " + uri);
                break;
        }
    }
    

    private void postGetListPlayers(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getGetListPlayers(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postListPlayers(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getListPlayers(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postPlayer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getPlayer(HttpServletRequest req, HttpServletResponse resp) {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "GET");
    }
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "POST");
    }
}