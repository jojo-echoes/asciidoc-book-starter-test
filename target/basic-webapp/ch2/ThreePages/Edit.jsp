<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit Page</title>
</head>
<body>
    <form action="Confirm.jsp" method="get">
        <p>This is a simple HTML page that has a form in it.</p>
        <p>The hobby was received as: <strong>${param.hobby}</strong></p>
        <p>Hobby: <input type="text" name="hobby" value="${param.hobby}">
        <input type="submit" name="confirmButton" value="Confirm"></p>
    </form>
</body>
</html>