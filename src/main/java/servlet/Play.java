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
import javax.servlet.http.HttpSession;

public class Play extends HttpServlet {

    private final static long serialVersionUID = 1L;
    private DBInt db = DB.getInstance();
    private CurrentGamesInt currentGames = CurrentGames.getInstance();

    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Play avec le path " + req.getRequestURI());
        try {

            switch (uri) {
                case "/home":
                    if (mode.equals("GET")) {
                        getHome(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postHome(req, resp);
                    }
                    break;
                case "/play":
                    if (mode.equals("GET")) {
                        getPlay(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postPlay(req, resp);
                    }
                    break;
                case "/currentGames":
                    if (mode.equals("GET")) {
                        getCurrentGames(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postCurrentGames(req, resp);
                    }
                    break;
                case "/getCurrentGames":
                    if (mode.equals("GET")) {
                        getGetCurrentGames(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postGetCurrentGames(req, resp);
                    }
                    break;
                default :
                    System.out.println("URI non reconnue : " + uri);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postGetCurrentGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getGetCurrentGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer uid = (Integer) req.getSession().getAttribute("uid");
        if (uid == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        } else if (!db.isAdmin(uid)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        ArrayList<GameLine> parties = currentGames.getAllgames();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(parties));
    }

    private void postCurrentGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getCurrentGames(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "/current-games.jsp");
    }

    private void postPlay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getPlay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("uid") == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        int uid;
        try {
            uid = Integer.parseInt(session.getAttribute("uid").toString());
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        User u = db.getUser(uid);

        if (u == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (u.getBanned() == 1) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        try {
            int gid = Integer.parseInt(req.getParameter("gid"));
            Jeu j = db.getJeu(gid);
            if (j == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            if (j.isAvailable()) {
                displayPage(req, resp, "/play.jsp");
            } else {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } catch (NumberFormatException e) {
            System.out.println(req.getParameter("gid") + " is not a valid gid");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void postHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // TODO jeux favoris
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "/games.jsp");
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