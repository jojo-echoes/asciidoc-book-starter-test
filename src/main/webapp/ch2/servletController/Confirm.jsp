<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Confirm Page</title>
</head>
<body>
    <h2>Form Submission Result</h2>
    <p>The hobby you entered is: <strong>${param.hobby}</strong></p>
    <form action="Controller" method="get">
        <input type="hidden" name="hobby" value="${param.hobby}">
        <input type="submit" name="editButton" value="Edit">
        <input type="submit" name="processButton" value="Process">
    </form>
</body>
</html>