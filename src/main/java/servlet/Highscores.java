package servlet;

import com.google.gson.Gson;
import data.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Highscores extends HttpServlet {

    private final static long serialVersionUID = 1L;
    private DBInt db = DB.getInstance();
    private CurrentGames currentGames = CurrentGames.getInstance();

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
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        if (uid == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        } else if (!db.isAdmin(uid)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        ArrayList<Partie> parties = db.listPartie();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(parties));
    }

    private void postPastGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getPastGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "past-games.jsp");
    }

    private void postSubmitScore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PartieFinie p = (new Gson()).fromJson(req.getReader().readLine(), PartieFinie.class);
        System.out.println(p);
        GameLine g = currentGames.removeGame(p.getUid());
        db.submitScore(g.getGame(), g.getIdUser(), g.getGameBeginD(), g.getGameEndD());
        resp.sendRedirect("/home");
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

    private void displayPage (HttpServletRequest req, HttpServletResponse resp, String page) throws IOException{

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views" + page);
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}