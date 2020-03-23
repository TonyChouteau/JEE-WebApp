package servlet;

import data.DB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admin extends HttpServlet {

    private final static long serialVersionUID = 1L;
    private DB db = DB.getInstance();
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Admin avec le path " + req.getRequestURI());

        switch (uri) {
            case "/ban":
                if (mode.equals("GET"))
                    getBan(req, resp);
                else if (mode.equals("POST"))
                    postBan(req, resp);
                break;
            case "/unban":
                if (mode.equals("GET"))
                    getUnban(req, resp);
                else if (mode.equals("POST"))
                    postUnban(req, resp);
                break;
            case "/addGame":
                if (mode.equals("GET"))
                    getAddGame(req, resp);
                else if (mode.equals("POST"))
                    postAddGame(req, resp);
                break;
            case "/removeGame":
                if (mode.equals("GET"))
                    getRemoveGame(req, resp);
                else if (mode.equals("POST"))
                    postRemoveGame(req, resp);
               break;
               case "/endGame":
                   if (mode.equals("GET"))
                       getEndGame(req, resp);
                   else if (mode.equals("POST"))
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

        if (db.isAdmin(Integer.parseInt((String) req.getSession().getAttribute("uid")))) {

            int uid = Integer.parseInt(req.getParameter("uid"));
            System.out.println(uid);

            db.banUser(uid);
        }

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp, "POST");
    }
}