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

@WebServlet(name = "setRefund", urlPatterns = "/setRefund")
public class setRefund extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取参数
        String bno = request.getParameter("bno");
        new CustomerDao().setRefund(bno);

        CustomerBean customer=(CustomerBean) session.getAttribute("customer");
        session.setAttribute("buys", new AdminDao().getBuy());
        session.setAttribute("success", "1");
        session.setAttribute("customer",new CustomerDao().getInfo(customer.getCno()));
        response.sendRedirect("/myweb/personal/Allstatus.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
