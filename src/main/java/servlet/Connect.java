package servlet;

import data.DB;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
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
    }

    private void postEditProfile(HttpServletRequest req, HttpServletResponse resp) {

       //TODO parce que j'ai la flemme

    }

    private void getEditProfile(HttpServletRequest req, HttpServletResponse resp) {
        String pageName = "/WEB-INF/views/profile.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postSignout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        try {
            resp.sendRedirect("/home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSignout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        try {
            resp.sendRedirect("/home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postSignup(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        Date d = new Date(42);
        int uid = db.signup(username, req.getParameter("email"), req.getParameter("password"), d);

        if (uid >= 0) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("uid", uid);
            try {
                resp.sendRedirect("/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String pageName = "/WEB-INF/views/signin.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
            try {
                rd.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getSignup(HttpServletRequest req, HttpServletResponse resp) {
        String pageName = "/WEB-INF/views/signup.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postSignin (HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");

        int uid = db.signin(username, req.getParameter("password"));

        if (uid >= 0) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("uid", uid);
            try {
                resp.sendRedirect("/home");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            String pageName = "/WEB-INF/views/signin.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
            try {
                rd.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getSignin(HttpServletRequest req, HttpServletResponse resp) {
        String pageName = "/WEB-INF/views/signin.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet (HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("ok boomer");
        doProcess(req, resp, "POST");
    }
}