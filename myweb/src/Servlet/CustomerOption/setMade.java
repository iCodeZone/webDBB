package Servlet.CustomerOption;

import Bean.CustomerBean;
import Bean.DealerBean;
import DAO.CustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "setMade", urlPatterns = "/setMade")
public class setMade extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //²ÎÊý
        CustomerBean customer = (CustomerBean) session.getAttribute("customer");
        String gno = request.getParameter("gno");

        new CustomerDao().setTro(customer.getCno(), gno, 1,"1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
