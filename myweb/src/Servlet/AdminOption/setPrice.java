package Servlet.AdminOption;

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

@WebServlet(name = "setPrice", urlPatterns = "/setPrice")
public class setPrice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AdminDao admin = (AdminDao) session.getAttribute("Admin");
        String gno = (String) session.getAttribute("Gno");
        double price = Double.valueOf(request.getParameter("gprice"));
        admin.setPrice(gno, price);
        session.setAttribute("good",new CustomerDao().getGoods(gno));
        response.sendRedirect("/myweb/AdminPage/PriceMessage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
