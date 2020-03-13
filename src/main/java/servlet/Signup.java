package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "signup",
        urlPatterns = {"/signup"}
    )
public class Signup extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private void doProcess(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                String pageName = "/signup.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
                try {
                    rd.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

}
