<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String address;
    if (request.getParameter("confirmButton") != null) {
        address = "Confirm.jsp";
    } else if (request.getParameter("processButton") != null) {
        address = "Process.jsp";
    } else {
        address = "Edit.jsp";
    }
    request.getRequestDispatcher(address).forward(request, response);
%>
    <%-- This is a JSP comment. It will not be included in the HTML output. --%>
    <%-- response.sendRedirect(address); --%>