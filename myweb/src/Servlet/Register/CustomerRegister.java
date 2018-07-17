package Servlet.Register;

import DAO.CustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CustomerRegister", urlPatterns = "/CustomerRegister")
public class CustomerRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tele = request.getParameter("telephone");
        //²éÖØ
        if (!new CustomerDao().checkUser(userid)) {
            HttpSession session = request.getSession();
            session.setAttribute("success", "1");
            response.sendRedirect("/myweb/begin/Regist.jsp");
        } else {//×¢²á
            new CustomerDao().Register(userid, username, tele, password);
            response.sendRedirect("/myweb/begin/Login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
