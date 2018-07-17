package Servlet.AdminOption;

import DAO.AdminDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "getStock", urlPatterns = "/getStock")
public class getStock extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AdminDao admin = (AdminDao) session.getAttribute("Admin");
        String gno = request.getParameter("search");

        if (admin.calGno(gno)) {
            session.setAttribute("stocks", admin.getStock(gno));
            session.setAttribute("success", "0");
            response.sendRedirect("/myweb/AdminPage/InventoryMessage.jsp");
        } else {
            session.setAttribute("success", "1");
            response.sendRedirect("/myweb/AdminPage/InventoryPage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
