package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Play extends HttpServlet {

    private final static long serialVersionUID = 1L;

    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Play avec le path " + req.getRequestURI());

        switch (uri) {
            case "/play":
                if (mode == "GET")
                    getPlay(req, resp);
                else if (mode == "POST")
                    postPlay(req, resp);
                break;
            case "/currentGames":
                if (mode == "GET")
                    getCurrentGames(req, resp);
                else if (mode == "POST")
                    postCurrentGames(req, resp);
                break;
            case "/getCurrentGames":
                if (mode == "GET")
                    getGetCurrentGames(req, resp);
                else if (mode == "POST")
                    postGetCurrentGames(req, resp);
                break;
            default :
                System.out.println("URI non reconnue : " + uri);
                break;
        }
    }

    private void postGetCurrentGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getGetCurrentGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postCurrentGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getCurrentGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postPlay(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getPlay(HttpServletRequest req, HttpServletResponse resp) {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "POST");
    }
}