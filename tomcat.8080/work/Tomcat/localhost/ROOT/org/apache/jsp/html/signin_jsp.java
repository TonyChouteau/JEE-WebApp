/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.23
 * Generated at: 2020-03-20 08:52:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>\r\n");
      out.write("<html xml:lang=\"fr\" lang=\"fr\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap\" rel=\"stylesheet\"> \r\n");
      out.write("    <title>Fluffy Gaming Center</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        html,\r\n");
      out.write("        body {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background: rgb(171, 28, 161);\r\n");
      out.write("            background: linear-gradient(45deg, rgb(192, 80, 186) 0%, rgba(184, 0, 255, 1) 100%);\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("            width: 100vw;\r\n");
      out.write("            color: black;/*rgb(223, 25, 209);*/\r\n");
      out.write("            font-family: 'Josefin Slab', serif;\r\n");
      out.write("        }\r\n");
      out.write("        #logo{\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            width : 7vh;\r\n");
      out.write("            height: 7vh;\r\n");
      out.write("        }\r\n");
      out.write("        #login-page {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background: transparent;\r\n");
      out.write("            width: 100vw;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #login-panel {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background: white;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            width: 60vh;\r\n");
      out.write("            min-width: 442px;\r\n");
      out.write("            min-height: 290px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("        }\r\n");
      out.write("        #centered-text{\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("        #title-login{\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .login-input{\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background: rgb(228, 228, 228);\r\n");
      out.write("            height: 40px;\r\n");
      out.write("            width: 40vh;\r\n");
      out.write("            min-width: 295px;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            border: 0;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        .login-button{\r\n");
      out.write("            font-family: 'Josefin Slab', serif;\r\n");
      out.write("            font-size:larger;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background: rgb(228, 228, 228);\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            width: 10vh;\r\n");
      out.write("            min-width: 295px;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            border: 0;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            color:rgb(235, 66, 223);\r\n");
      out.write("        }\r\n");
      out.write("        .login-button:hover{\r\n");
      out.write("            background: rgb(233, 233, 233);\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .login-button:active{\r\n");
      out.write("            background: rgb(235, 66, 223);\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div>\r\n");
      out.write("        <img id=\"logo\" src=\"../ressources/logo.png\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"login-page\">\r\n");
      out.write("        <div id=\"login-panel\">\r\n");
      out.write("            <h1 id=\"title-login\" class=\"centered-text\">\r\n");
      out.write("                Connexion\r\n");
      out.write("            </h1>\r\n");
      out.write("            <h3 class=\"centered-text\">\r\n");
      out.write("                Username :\r\n");
      out.write("            </h3>\r\n");
      out.write("            <input class=\"login-input\" type=\"text\" id=\"fusername\" name=\"username\" placeholder=\"\">\r\n");
      out.write("\r\n");
      out.write("            <h3 class=\"centered-text\">\r\n");
      out.write("                Password :\r\n");
      out.write("            </h3>\r\n");
      out.write("            <input class=\"login-input\" type=\"password\" id=\"fpassword\" name=\"password\" placeholder=\"\">\r\n");
      out.write("            <h1></h1>\r\n");
      out.write("            <button class=\"login-button\" type=\"button\" onclick=\"\">Login</button>\r\n");
      out.write("            <h4>\r\n");
      out.write("                <span>Not registered ?</span> <a href=\"./signup.html\" style=\"color:rgb(235, 66, 223);\">Sign up</a>\r\n");
      out.write("            </h4>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
