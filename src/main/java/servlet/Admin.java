package servlet;

import data.CurrentGames;
import data.CurrentGamesInt;
import data.DB;
import data.DBInt;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admin extends HttpServlet {

    private final static long serialVersionUID = 1L;
    private DBInt db = DB.getInstance();
    private CurrentGamesInt currentGames = CurrentGames.getInstance();
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Admin avec le path " + req.getRequestURI());

        Integer uid = (Integer) req.getSession().getAttribute("uid");

        try {
            if (uid == null) {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            else if (!db.isAdmin(uid)) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }

            switch (uri) {
                case "/ban":
                    if (mode.equals("GET")) {
                        getBan(req, resp, uid);
                    }
                    else if (mode.equals("POST")) {
                        postBan(req, resp, uid);
                    }
                    break;
                case "/unban":
                    if (mode.equals("GET")) {
                        getUnban(req, resp, uid);
                    }
                    else if (mode.equals("POST")) {
                        postUnban(req, resp, uid);
                    }
                    break;
                case "/games":
                    if (mode.equals("GET")) {
                        getGames(req, resp, uid);
                    }
                    else if (mode.equals("POST")) {
                        postGames(req, resp, uid);
                    }
                    break;
                case "/addGame":
                    if (mode.equals("GET")) {
                        getAddGame(req, resp, uid);
                    }
                    else if (mode.equals("POST")) {
                        postAddGame(req, resp, uid);
                    }
                    break;
                case "/removeGame":
                    if (mode.equals("GET")) {
                        getRemoveGame(req, resp, uid);
                    }
                    else if (mode.equals("POST")) {
                        postRemoveGame(req, resp, uid);
                    }
                    break;
                case "/endGame":
                    if (mode.equals("GET")) {
                        getEndGame(req, resp, uid);
                    }
                    else if (mode.equals("POST")) {
                        postEndGame(req, resp, uid);
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

    private void postGames(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getGames(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        displayPage(req, resp ,"/admin/games.jsp");
    }

    private void postEndGame(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {

        try {
            int i = Integer.parseInt(req.getReader().readLine());
            currentGames.removeGame(i);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void getEndGame(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        try {
            int user = Integer.parseInt(req.getParameter("uid"));
            currentGames.removeGame(user);
            resp.sendError(HttpServletResponse.SC_OK);
        } catch (NumberFormatException e) {
            System.out.println(req.getParameter("uid") + " is not a valid uid");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void getRemoveGame(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        try {
            int gid = Integer.parseInt(req.getParameter("gid"));
            System.out.println(gid + " enabled by " + uid);
            db.removeGame(gid);
            resp.sendError(HttpServletResponse.SC_OK);
        } catch (NumberFormatException e) {
            System.out.println(req.getParameter("gid") + " is not a valid gid");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void postRemoveGame(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getAddGame(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        try {
            int gid = Integer.parseInt(req.getParameter("gid"));
            System.out.println(gid + " enabled by " + uid);
            db.addGame(gid);
            resp.sendError(HttpServletResponse.SC_OK);
        } catch (NumberFormatException e) {
            System.out.println(req.getParameter("gid") + " is not a valid gid");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void postAddGame(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getUnban(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        try {
            int banned = Integer.parseInt(req.getParameter("uid"));
            System.out.println(banned + " unbanned by " + uid);
            db.unbanUser(banned);
            resp.sendError(HttpServletResponse.SC_OK);
        } catch (NumberFormatException e) {
            System.out.println(req.getParameter("uid") + " is not a valid uid");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void postUnban(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getBan(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        try {
            int banned = Integer.parseInt(req.getParameter("uid"));
            System.out.println(banned + " banned by " + uid);
            db.banUser(banned);
            resp.sendError(HttpServletResponse.SC_OK);
        } catch (NumberFormatException e) {
            System.out.println(req.getParameter("uid") + " is not a valid uid");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void postBan(HttpServletRequest req, HttpServletResponse resp, Integer uid) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) {
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