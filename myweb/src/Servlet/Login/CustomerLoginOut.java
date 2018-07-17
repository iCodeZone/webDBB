package Servlet.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerLoginOut",urlPatterns = "/CustomerLoginOut")
public class CustomerLoginOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie nameCookie = new Cookie("saimot_username", "");
        Cookie passCookie = new Cookie("saimot_password", "");

        nameCookie.setMaxAge(0);
        passCookie.setMaxAge(0);
        //向客户发送cookie
        response.addCookie(nameCookie);
        response.addCookie(passCookie);

        response.sendRedirect("/myweb/begin/Login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
