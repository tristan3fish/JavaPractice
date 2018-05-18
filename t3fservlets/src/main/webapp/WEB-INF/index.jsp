<%@ page import="com.t3f.User" %>
<!DOCTYPE html>
<html>
<head>

    <title>CogniPorter</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
    $(document).ready(function(){
        $(".myGui").click(function(){
                var url = window.location.href;
                $.getJSON( url + "/static/GermanWords1000.json", function( data ) {

                    var x = Math.floor(Math.random() * 1000);
                    var y = Math.floor(Math.random() * 1000);
                    var z = Math.floor(Math.random() * 1000);
                    var t = Math.floor(Math.random() * 3);
                    var arr = [data[x].english, data[y].english, data[z].english];
                    $(".myGui").html(
                        data[x].german + " : " + arr[t % 3] + " " + arr[(t+1) % 3] + " " + arr[(t+2) % 3] +
                        " <font color=\"white\">"+data[x].english+"</font>");
                });

        });
    });
    </script>

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

<div class="myGui">
hello
</div>

</body>
</html>