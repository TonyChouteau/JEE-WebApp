package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.print("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN'	'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>" +
                  "<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>" +
                  "    <head>" +
                  "        <meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>" +
                  "        <title>Fluffy Gaming Center</title>" +
                  "        <link rel='stylesheet' href='style.css' type='text/css' media='screen' charset='utf-8'/>" +
                  "    </head>" +
                  "    <body>" +
                  "    </body>" +
                  "</html>");
        out.flush();
        out.close();
    }
}
