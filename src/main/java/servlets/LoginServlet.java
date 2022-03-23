package servlets;

import DAO.DAOFactory;
import DAO.UserDAO;
import log.MyLog;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final String jsp_login = "/WEB-INF/view/login.jsp";
    private static final String jsp_loginError = "/WEB-INF/view/login_error.jsp";
    private static final String url_student = "/main";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            resp.sendRedirect(url_student);
        } else {
            req.getRequestDispatcher(jsp_login).forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            DAOFactory sqliteFactory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
            UserDAO userDAO = sqliteFactory.getUserDAO();
            User target = userDAO.findUser(req.getParameter("email"), req.getParameter("pwd"));
            if (target == null) {
                MyLog.Msg("User is not found");
                req.getRequestDispatcher(jsp_loginError).forward(req, resp);
                return;
            }
            // Session init
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(60*60*24);
            session.setAttribute("user", target);
            // Cookie example
            /*Cookie cookie = new Cookie("email", target.getEmail());
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);*/
            resp.sendRedirect(url_student);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher(jsp_loginError).forward(req, resp);
        }
    }
}
