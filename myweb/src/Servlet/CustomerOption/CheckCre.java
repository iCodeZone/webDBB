package Servlet.CustomerOption;

import Bean.CustomerBean;
import Bean.DealerBean;
import DAO.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckCre",urlPatterns = "/CheckCre")
public class CheckCre extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        CustomerBean customer=(CustomerBean) session.getAttribute("customer");
        int cre = new CustomerDao().calCre(customer.getCno());
        if(cre>=80){
            String temp=request.getParameter("mnote");
            String mnote=new String(temp.getBytes("iso-8859-1") ,"GBK");
            session.setAttribute("mnote",mnote);
            session.setAttribute("gno",request.getParameter("gno"));
            response.sendRedirect("/myweb/addTro");
        }
        else{
            response.sendRedirect("/myweb/purchase/Check_order.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
