package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Highscores extends HttpServlet {

    private final static long serialVersionUID = 1L;

    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Highscores avec le path " + req.getRequestURI());

        switch (uri) {
            case "/submitScore":
                if (mode == "GET")
                    getSubmitScore(req, resp);
                else if (mode == "POST")
                    postSubmitScore(req, resp);
                break;
            case "/pastGames":
                if (mode == "GET")
                    getPastGames(req, resp);
                else if (mode == "POST")
                    postPastGames(req, resp);
                break;
            case "/getPastGames":
                if (mode == "GET")
                    getGetPastGames(req, resp);
                else if (mode == "POST")
                    postGetPastGames(req, resp);
                break;
            default :
                System.out.println("URI non reconnue : " + uri);
                break;
        }

    }

    private void postGetPastGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getGetPastGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postPastGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getPastGames(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void postSubmitScore(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getSubmitScore(HttpServletRequest req, HttpServletResponse resp) {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "POST");
    }
}