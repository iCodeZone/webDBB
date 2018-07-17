package Servlet.CustomerOption;

import Bean.CustomerBean;
import Bean.TrolleyBean;
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

@WebServlet(name = "orderFromTro", urlPatterns = "/orderFromTro")
public class orderFromTro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取参数
        CustomerBean customer = (CustomerBean) session.getAttribute("customer");
        ArrayList<TrolleyBean> trolleys = (ArrayList<TrolleyBean>) session.getAttribute("goodsbuy");
        String[] arr = request.getParameterValues("select");
        String baddr = request.getParameter("baddr");

        CustomerDao customerDao = new CustomerDao();
        for (int i = 0; i < arr.length; i++) {
            int index = Integer.valueOf(arr[i]);
            TrolleyBean trolley = trolleys.get(index);
            customerDao.setOrder(customer.getCno(), trolley.getGno(), baddr, trolley.getTnumber());
        }

        RequestDispatcher rd = request.getRequestDispatcher("++++++++++");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
