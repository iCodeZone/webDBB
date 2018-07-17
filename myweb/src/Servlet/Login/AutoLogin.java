package Servlet.Login;

import DAO.CustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AutoLogin", urlPatterns = "/AutoLogin")
public class AutoLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("saimot_username")) username = cookie.getValue();
            if (cookie.getName().equals("saimot_password")) password = cookie.getValue();
        }
        HttpSession session = request.getSession();
        session.setAttribute("customer", new CustomerDao().getInfo(username));
        session.setAttribute("goods", new CustomerDao().getGoods());
        session.setAttribute("trolley", new CustomerDao().getTro(username));
        session.setAttribute("cno", username);
        //重新设置cookie
        Cookie nameCookie = new Cookie("Saimot_username", username);
        Cookie passCookie = new Cookie("Saimot_password", password);
        System.out.println(username + " " + password);
        //设置最大存活时间为30分钟
        //测试参数待修改
        nameCookie.setMaxAge(60);
        passCookie.setMaxAge(60);
        //向客户发送cookie
        response.addCookie(nameCookie);
        response.addCookie(passCookie);
        response.sendRedirect("/myweb/HomePage/HomePage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
