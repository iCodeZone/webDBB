package Servlet.AdminOption;

import DAO.AdminDao;
import DAO.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "getGood",urlPatterns = "/getGood")
public class getGood extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AdminDao admin = (AdminDao) session.getAttribute("Admin");
        String gno = request.getParameter("search");
        if(admin.calGno(gno)){

            session.setAttribute("Gno",gno);
            session.setAttribute("good",new CustomerDao().getGoods(gno));
            response.sendRedirect("/myweb/AdminPage/PriceMessage.jsp");
        }
        else{
            session.setAttribute("success","1");
            response.sendRedirect("/myweb/AdminPage/PricePage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
