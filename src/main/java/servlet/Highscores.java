package servlet;

import data.DB;
import data.DBInt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Highscores extends HttpServlet {

    private final static long serialVersionUID = 1L;
    private DBInt db = DB.getInstance();

    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Highscores avec le path " + req.getRequestURI());

        try {
            switch (uri) {
                case "/submitScore":
                    if (mode.equals("GET")) {
                        getSubmitScore(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postSubmitScore(req, resp);
                    }
                    break;
                case "/pastGames":
                    if (mode.equals("GET")) {
                        getPastGames(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postPastGames(req, resp);
                    }
                    break;
                case "/getPastGames":
                    if (mode.equals("GET")) {
                        getGetPastGames(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postGetPastGames(req, resp);
                    }
                    break;
                default :
                    System.out.println("URI non reconnue : " + uri);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        };

    }

    private void postGetPastGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getGetPastGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //TODO Il faut pouvoir récupérer la liste des parties passées
    }

    private void postPastGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getPastGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //TODO Il faut avoir la page d'affichage des parties passées
    }

    private void postSubmitScore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //db.submitScore(req.);
    }

    private void getSubmitScore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "POST");
    }
}