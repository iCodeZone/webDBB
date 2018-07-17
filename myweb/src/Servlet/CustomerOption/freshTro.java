package Servlet.CustomerOption;

import Bean.CustomerBean;
import Bean.TrolleyBean;
import DAO.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "freshTro", urlPatterns = "/freshTro")
public class freshTro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerBean customer = (CustomerBean) session.getAttribute("customer");
        ArrayList<TrolleyBean> trolley = (ArrayList<TrolleyBean>) session.getAttribute("trolley");
        CustomerDao customerDao = new CustomerDao();
        for (int i = 0; i < trolley.size(); i++) {
            String index = request.getParameter(Integer.toString(i));
            if (index != "") {
                customerDao.setTro(customer.getCno(), trolley.get(i).getGno(), Integer.valueOf(index), "1");
            }
        }

        response.sendRedirect("/myweb/getTro");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
