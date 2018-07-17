package Servlet.CustomerOption;

import Bean.CustomerBean;
import DAO.AdminDao;
import DAO.CustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "setPay",urlPatterns = "/setPay")
public class setPay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //获取参数
        String bno = request.getParameter("bno");
        new CustomerDao().setPay(bno);
        CustomerBean customer=(CustomerBean) session.getAttribute("customer");
        session.setAttribute("buys",new CustomerDao().getBuy(customer.getCno()));
        session.setAttribute("customer",new CustomerDao().getInfo(customer.getCno()));
        session.setAttribute("success","1");
        response.sendRedirect("/myweb/personal/Allstatus.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
