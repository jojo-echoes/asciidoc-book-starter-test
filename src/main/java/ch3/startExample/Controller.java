package ch3.startExample;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/ch3/startExample/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Override
    public void init() throws ServletException {
        super.init();
        logger.info("Controller servlet initialized. Controller = {}", this);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Service method called. HTTP method: {}. Controller = {}", request.getMethod(), this);
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Controller = {}", this);
        logger.info("Handling GET request. Thread: {}", Thread.currentThread().getName());

        // Log cookies
        logCookies(request);

        HttpSession session = request.getSession(true);
        logSessionAttributes(session);

        UserDataBean userData = (UserDataBean) session.getAttribute("userData");
        if (userData == null) {
            userData = new UserDataBean();
            session.setAttribute("userData", userData);
        }

        userData.setHobby(request.getParameter("hobby"));
        userData.setAversion(request.getParameter("aversion"));

        logger.info("userData = {}", userData);
        logger.info("userData.setHobby = {}", request.getParameter("hobby"));
        logger.info("userData.setAversion = {}", request.getParameter("aversion"));

        String address;
        if (request.getParameter("confirmButton") != null) {
            address = "Confirm.jsp";
        } else if (request.getParameter("processButton") != null) {
            address = "Process.jsp";
        } else {
            address = "Edit.jsp";
        }

        logger.info("address = {}", address);
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        logger.info("Controller = {}", this);
        logger.info("Handling POST request. Thread: {}", Thread.currentThread().getName());

        // Log cookies
        logCookies(request);

        HttpSession session = request.getSession(true);
        logSessionAttributes(session);

        UserDataBean userData = (UserDataBean) session.getAttribute("userData");
        if (userData == null) {
            userData = new UserDataBean();
            session.setAttribute("userData", userData);
        }

        userData.setHobby(request.getParameter("hobby"));
        userData.setAversion(request.getParameter("aversion"));

        logger.info("userData = {}", userData);
        logger.info("userData.setHobby = {}", request.getParameter("hobby"));
        logger.info("userData.setAversion = {}", request.getParameter("aversion"));

        String address;
        if (request.getParameter("confirmButton") != null) {
            address = "Confirm.jsp";
        } else if (request.getParameter("processButton") != null) {
            address = "Process.jsp";
        } else {
            address = "Edit.jsp";
        }

        logger.info("address = {}", address);
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        logger.info("Controller servlet destroyed. Controller = {}", this);
        super.destroy();
    }

    private void logSessionAttributes(HttpSession session) {
        logger.info("Session ID: {}", session.getId());
        logger.info("Creation Time: {}", session.getCreationTime());
        logger.info("Last Accessed Time: {}", session.getLastAccessedTime());
        logger.info("Max Inactive Interval: {}", session.getMaxInactiveInterval());

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = session.getAttribute(attributeName);
            logger.info("Session Attribute - Name: {}, Value: {}", attributeName, attributeValue);
        }
    }

    private void logCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                logger.info("Cookie - Name: {}, Value: {}", cookie.getName(), cookie.getValue());
            }
        } else {
            logger.info("No cookies found");
        }
    }

}