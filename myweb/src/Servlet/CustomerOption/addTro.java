package Servlet.CustomerOption;

import Bean.CustomerBean;
import DAO.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addTro",urlPatterns = "/addTro")
public class addTro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        CustomerBean customer=(CustomerBean)session.getAttribute("customer");
        if(request.getParameter("gno")==null) new CustomerDao().setTro(customer.getCno(),(String)session.getAttribute("gno"),1,"2");
        else new CustomerDao().setTro(customer.getCno(),request.getParameter("gno"),1,"2");
        response.sendRedirect("/myweb/getTro");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
