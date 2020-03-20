package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Connect extends HttpServlet {

    private final static long serialVersionUID = 1L;

    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Connect avec le path " + req.getRequestURI());

        switch (uri) {
            case "/signin":
                if (mode == "GET") {
                    renderSignin(req, resp);
                } else if (mode == "POST") {
                    testSignin(req, resp);
                }
                break;
            case "/signup":
                break;
            case "/signout":
                break;
            case "/editProfile":
               break;
            default :
                System.out.println("URI non reconnue : " + uri);
                break;
        }
    }

    private void renderSignin (HttpServletRequest req, HttpServletResponse resp) {
        String pageName = "/WEB-INF/views/signin.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testSignin (HttpServletRequest req, HttpServletResponse resp) {
        String pageName = "/WEB-INF/views/signin.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp, "GET");
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ok boomer");
        doProcess(req, resp, "POST");
    }
}