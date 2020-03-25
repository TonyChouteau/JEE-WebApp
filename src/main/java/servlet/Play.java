package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Play extends HttpServlet {

    private final static long serialVersionUID = 1L;

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
        // TODO Il faut récupérer les parties en cours
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

        try {
            int gid = Integer.parseInt(req.getParameter("gid"));
            displayPage(req, resp, "/play.jsp");
        } catch (NumberFormatException e) {
            System.out.println(req.getParameter("gid") + " is not a valid gid");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void postHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        try {
            rd.forward(req, resp);
            resp.sendError(HttpServletResponse.SC_OK);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}