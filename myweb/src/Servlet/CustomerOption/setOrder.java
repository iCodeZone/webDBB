package Servlet.CustomerOption;

import Bean.CustomerBean;
import Bean.GoodsBean;
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

@WebServlet(name = "setOrder", urlPatterns = "/setOrder")
public class setOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<TrolleyBean> goodsbuy = (ArrayList<TrolleyBean>) session.getAttribute("goodsbuy");
        //获取参数
        CustomerBean customer = (CustomerBean) session.getAttribute("customer");
        String s=request.getParameter("province")+request.getParameter("address");
        String baddr =new String(s.getBytes("iso-8859-1") ,"UTF-8");
        System.out.println(baddr);
        System.out.println("11");
        boolean flag = true;
        for (int i = 0; i < goodsbuy.size(); i++) {
            if (!(new CustomerDao().setOrder(customer.getCno(), goodsbuy.get(i).getGno(), baddr, goodsbuy.get(i).getTnumber()))) {
                flag = false;
            } else {
                new CustomerDao().setTro(customer.getCno(), goodsbuy.get(i).getGno(), 0,"1");
            }
        }
        if (!flag) {
            session.setAttribute("success", "0");
        } else {
            session.setAttribute("success", "1");
        }
        response.sendRedirect("/myweb/purchase/Check_purchase.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
