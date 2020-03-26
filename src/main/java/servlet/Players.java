package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;
import data.DB;
import data.DBInt;
import data.User;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
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
                case "/getPlayer":
                    if (mode.equals("GET")) {
                        getGetPlayer(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postGetPlayer(req, resp);
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
        resp.getWriter().write(new Gson().toJson(users));
    }

    private void postListPlayers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void getListPlayers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer uid = (Integer) req.getSession().getAttribute("uid");

        if (uid == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        else if (!db.isAdmin(uid)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        displayPage(req, resp, "/admin/players.jsp");
    }

    private void postPlayer(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    // TODO editProfile
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String birthday = req.getParameter("birthday");
        String password = req.getParameter("password");

        int uid = Integer.parseInt(req.getSession().getAttribute("uid").toString());

        User u = db.getUser(uid);
        String p = db.getUserPassword(uid);

        username = username.equals("") ? u.getPseudo() : username;
        email = email.equals("") ? u.getEmail() : email;
        birthday = birthday.equals("") ? u.getBirthday().toString() : birthday;
        password = password.equals("") ? p : password;

        if (db.editProfile(uid, username, email, password, new Date(Time.valueOf(birthday).getTime())) == 0) {
            resp.sendError(HttpServletResponse.SC_OK);
        } else {
            resp.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

    private void getPlayer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession().getAttribute("uid") != null) {
            displayPage(req, resp, "/profile.jsp");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    public void getGetPlayer (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer uid = (Integer) req.getSession().getAttribute("uid");
        if (uid == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        User u = db.getUser(uid);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(u));

    }

    public void postGetPlayer (HttpServletRequest req, HttpServletResponse resp) throws IOException {

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