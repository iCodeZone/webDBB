package Servlet.CustomerOption;

import Bean.CustomerBean;
import DAO.CustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "ChangePassword",urlPatterns = "/ChangePassword")
public class ChangePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取参数
        CustomerBean customer = (CustomerBean) session.getAttribute("customer");
        String password = request.getParameter("password");
        new CustomerDao().upPassword(customer.getCno(),password);

        session.setAttribute("success","1");
        response.sendRedirect("/myweb/personal/PSuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
