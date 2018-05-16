<%@ page import="com.t3f.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>CogniPorter</title>
</head>
<body>
<%@include file="_header.jsp"%>
<% User user = (User)request.getAttribute("user");
    if(user == null){
        user = new User();
    }
%>
<center><h1>Hello <%=user.getName()%>!</h1></center>

<p>
Welcome to the CogniPorter homepage. This site is under development.
</p>

<p>
<form action="hello" method="post">
    Please send us your name: <input type="text" name="name"/>
    <input type="submit" value="submit"/>
</form>
</p>

</body>
</html>