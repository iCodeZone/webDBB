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

@WebServlet(name = "setTro", urlPatterns = "/setTro")
public class setTro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        CustomerBean customer = (CustomerBean) session.getAttribute("customer");
        ArrayList<TrolleyBean> trolley=(ArrayList<TrolleyBean>) session.getAttribute("trolley");
        CustomerDao customerDao = new CustomerDao();
        for(int i=0;i<trolley.size();i++){
            String index=request.getParameter(Integer.toString(i));
            if(index!=null){
                String gno = trolley.get(i).getGno();
                int num = Integer.valueOf(index);

                customerDao.setTro(customer.getCno(), gno, num,"1");
            }
        }
        //获取参数
        session.setAttribute("trolley", customerDao.getTro(customer.getCno()));
        response.sendRedirect("/myweb/purchase/Shopping_car.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
