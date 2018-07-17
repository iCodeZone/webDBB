package Servlet.Login;

import DAO.CustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CustomerLogin", urlPatterns = "/CustomerLogin")
public class CustomerLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto = request.getParameter("auto");
        //�ͻ���½
        System.out.println("in");
        if (new CustomerDao().Login(username, password)) {
            System.out.println("ok");

            HttpSession session = request.getSession();
            session.setAttribute("customer", new CustomerDao().getInfo(username));//��ù˿���Ϣ
            session.setAttribute("goods", new CustomerDao().getGoods());//�����Ʒ��Ϣ
            session.setAttribute("trolley", new CustomerDao().getTro(username));
            session.setAttribute("cno", username);
            //�Զ���½
            if (("1").equals(auto)) {
                System.out.println("auto");
                Cookie nameCookie = new Cookie("saimot_username", username);
                Cookie passCookie = new Cookie("saimot_password", password);
                //���������ʱ��Ϊ30����
                //���Բ������޸�
                nameCookie.setMaxAge(60);
                passCookie.setMaxAge(60);
                //��ͻ�����cookie
                response.addCookie(nameCookie);
                response.addCookie(passCookie);
            }
            response.sendRedirect("/myweb/HomePage/HomePage.jsp");
        } else {
            HttpSession session = request.getSession();
            System.out.println("fail");
            session.setAttribute("success", "1");
            response.sendRedirect("/myweb/begin/Login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
