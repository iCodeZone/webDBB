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

@WebServlet(name = "AddGoods",urlPatterns = "/AddGoods")
public class AddGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AdminDao admin = (AdminDao) session.getAttribute("Admin");
        String gno = request.getParameter("gno");
        String gname = request.getParameter("gname");
        double gprice = Double.valueOf(request.getParameter("gprice"));
        String gtype = request.getParameter("gtype");
        String gput = request.getParameter("gput");
        String gaddr = request.getParameter("paddr");
        if (!admin.calGno(gno)) {
            System.out.println(gno);
            admin.addGoods(gno, gname, gprice, gtype, gput, gaddr);
            session.setAttribute("success", "0");
            response.sendRedirect("/myweb/AdminPage/StoragePage.jsp");
        } else {
            session.setAttribute("success", "1");
            response.sendRedirect("/myweb/AdminPage/StoragePage.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
