package Servlet.Login;

import DAO.AdminDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminLogin", urlPatterns = "/AdminLogin")
public class AdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("AUSER") && password.equals("AUSER-AUSER")) {
            session.setAttribute("Admin", new AdminDao());
            response.sendRedirect("/myweb/AdminPage/AdminPage.jsp");
        } else {
            session.setAttribute("success", "1");
            response.sendRedirect("/myweb/admin/Admin_login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
