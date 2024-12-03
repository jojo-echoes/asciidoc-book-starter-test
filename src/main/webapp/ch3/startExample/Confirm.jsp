<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.slf4j.Logger, org.slf4j.LoggerFactory" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="ch3.startExample.UserDataBean" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%
    Logger logger = LoggerFactory.getLogger("ConfirmJSP");
    logger.info("Rendering Confirm.jsp");

    // Log cookies
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            logger.info("Cookie - Name: {}, Value: {}", cookie.getName(), cookie.getValue());
        }
    } else {
        logger.info("No cookies found");
    }

    // Retrieve the session object
    // HttpSession session = request.getSession();
    // Retrieve the session object (implicitly available)
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

    // Retrieve the userData attribute from the session
    UserDataBean userData = (UserDataBean) session.getAttribute("userData");
    String hobby = "";
    String aversion = "";

    if (userData != null) {
        hobby = userData.getHobby();
        aversion = userData.getAversion();
        logger.info("UserData: {}", userData);
        logger.info("Hobby: {}", hobby);
        logger.info("Aversion: {}", aversion);
    } else {
        logger.warn("UserData attribute is null");
    }
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Confirm Page</title>
</head>
<body>
    <p>This is a simple HTML page that has a form in it.</p>
    <p>The value of the hobby that was sent to this page is: <strong>${param.hobby}</strong></p>
    <p>The value of the hobby from the userData bean is: <strong>"<%= hobby %>"</strong></p>
    <p>The value of the aversion that was sent to this page is: <strong>${param.aversion}</strong></p>
    <p>The value of the aversion from the userData bean is: <strong>"<%= aversion %>"</strong></p>
    <p>If there is an error, please select <em>Edit</em>, otherwise please select <em>Process</em>.</p>
    <form action="Controller" method="get">
        <input type="hidden" name="hobby" value="<%= hobby %>">
        <input type="hidden" name="aversion" value="<%= aversion %>">
        <p>
        <input type="submit" name="editButton" value="Edit">
        <input type="submit" name="processButton" value="Process">
    </form>
</body>
</html>