package ch2.servletController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch2/servletController/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address;
        if (request.getParameter("confirmButton") != null) {
            System.out.println(request.getParameter("confirmButton"));
            address = "Confirm.jsp";
        } else if (request.getParameter("processButton") != null) {
            System.out.println(request.getParameter("processButton"));
            address = "Process.jsp";
        } else {
            System.out.println(request.getParameter("editButton"));
            address = "Edit.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}