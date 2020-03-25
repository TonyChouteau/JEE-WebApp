package servlet;

import data.DB;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Connect extends HttpServlet {

    private final static long serialVersionUID = 1L;
    private DB db = DB.getInstance();

    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Connect avec le path " + req.getRequestURI());

        try {

            switch (uri) {
                case "/signin":
                    if (mode.equals("GET"))
                        getSignin(req, resp);
                    else if (mode.equals("POST"))
                        postSignin(req, resp);
                    break;
                case "/signup":
                    if (mode.equals("GET"))
                        getSignup(req, resp);
                    else if (mode.equals("POST"))
                        postSignup(req, resp);
                    break;
                case "/signout":
                    if (mode.equals("GET"))
                        getSignout(req, resp);
                    else if (mode.equals("POST"))
                        postSignout(req, resp);
                    break;
                case "/editProfile":
                    if (mode.equals("GET"))
                        getEditProfile(req, resp);
                    else if (mode.equals("POST"))
                        postEditProfile(req, resp);
                   break;
                default :
                    System.out.println("URI non reconnue : " + uri);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postEditProfile(HttpServletRequest req, HttpServletResponse resp) throws IOException {

       //TODO parce que j'ai la flemme

    }

    private void getEditProfile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "/WEB-INF/views/profile.jsp");
    }

    private void postSignout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/home");
    }

    private void getSignout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/home");
    }

    private void postSignup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // TODO Check les paramètres !!!
        String username = req.getParameter("username");
        Date d = new Date(42);
        int uid = db.signup(username, req.getParameter("email"), req.getParameter("password"), d);

        if (uid >= 0) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("uid", uid);
            resp.sendRedirect("/home");
        } else {
            displayPage(req, resp, "/signin.jsp");
        }
    }

    private void getSignup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "/signup.jsp");
    }

    private void postSignin (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("username");

        int uid = db.signin(username, req.getParameter("password"));

        if (uid >= 0) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("uid", uid);
            resp.sendRedirect("/home");

        } else {
            displayPage(req, resp, "/signin.jsp");
        }
    }

    private void getSignin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        displayPage(req, resp, "/signin.jsp");
    }

    public void doGet (HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("ok boomer");
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

    public String checkParam (HttpServletRequest req, String param) {
        //TODO
        return null;
    }
}