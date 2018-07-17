package Servlet.CustomerOption;

import Bean.BuyBean;
import Bean.CustomerBean;
import Bean.GoodsBean;
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

@WebServlet(name = "GoodsToTro", urlPatterns = "/GoodsToTro")
public class GoodsToTro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String[] arr = request.getParameterValues("select");
        ArrayList<TrolleyBean> goodsbuy = new ArrayList<>();
        CustomerBean customer=(CustomerBean) session.getAttribute("customer");
        if (arr == null) {
            ArrayList<GoodsBean> goods = (ArrayList<GoodsBean>) session.getAttribute("goods");
            String gno=request.getParameter("gno");
            boolean flag=false;
            for (int i = 0; i < goods.size() && !flag; i++) {
                String temp = goods.get(i).getGno();
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == ' ') {
                        GoodsBean good=goods.get(i);
                        TrolleyBean trolley=new TrolleyBean();
                        trolley.setTnumber(1);
                        trolley.setGno(good.getGno());
                        trolley.setGtype(good.getGtype());
                        trolley.setGput(good.getGput());
                        trolley.setCno(customer.getCno());
                        trolley.setGprice(good.getGprice());
                        trolley.setGname(good.getGname());
                        trolley.setGnote(good.getGnote());
                        trolley.setGaddr(good.getGaddr());
                        goodsbuy.add(trolley);
                        session.setAttribute("goodsbuy", goodsbuy);
                        flag = true;
                        break;
                    }
                    if (temp.charAt(j) != gno.charAt(j)) {
                        break;
                    }
                }
            }
        } else {
            ArrayList<TrolleyBean> good = (ArrayList<TrolleyBean>) session.getAttribute("trolley");
            for (int i = 0; i < arr.length; i++) {
                goodsbuy.add(good.get(i));
            }
            session.setAttribute("goodsbuy", goodsbuy);
        }
        response.sendRedirect("/myweb/purchase/Confirm_purchase.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
