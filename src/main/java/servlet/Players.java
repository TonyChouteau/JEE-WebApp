package servlet;

import data.DB;
import data.DBInt;
import data.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Players extends HttpServlet {
    
    private final static long serialVersionUID = 1L;
    private DBInt db = DB.getInstance();
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Players avec le path " + req.getRequestURI());

        try {
            switch (uri) {
                case "/player":
                    if (mode.equals("GET")) {
                        getPlayer(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postPlayer(req, resp);
                    }
                    break;
                case "/listPlayers":
                    if (mode.equals("GET")) {
                        getListPlayers(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postListPlayers(req, resp);
                    }
                    break;
                case "/getListPlayers":
                    if (mode.equals("GET")) {
                        getGetListPlayers(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postGetListPlayers(req, resp);
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
    

    private void postGetListPlayers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getGetListPlayers(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer uid = (Integer) req.getSession().getAttribute("uid");
        if (uid == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        } else if (!db.isAdmin(uid)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        ArrayList<User> users = db.listUser();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(users.toString());
    }

    private void postListPlayers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getListPlayers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "/players.jsp");
    }

    private void postPlayer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getPlayer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "/profile.jsp");
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