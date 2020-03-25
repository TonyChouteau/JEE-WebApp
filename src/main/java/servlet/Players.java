package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Players extends HttpServlet {
    
    private final static long serialVersionUID = 1L;
    
    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String mode) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("Connexion à Players avec le path " + req.getRequestURI());

        try {
            switch (uri) {
                case "/play":
                    if (mode.equals("GET")) {
                        getPlayer(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postPlayer(req, resp);
                    }
                    break;
                case "/currentGames":
                    if (mode.equals("GET")) {
                        getListPlayers(req, resp);
                    }
                    else if (mode.equals("POST")) {
                        postListPlayers(req, resp);
                    }
                    break;
                case "/getCurrentGames":
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
        // TODO récupérer la liste des joueurs
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
        displayPage(req, resp, "player.jsp");
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