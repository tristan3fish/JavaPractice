<%@ page import="com.t3f.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>CogniPorter</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="metro-bootstrap-master/css/metro-bootstrap.css" rel="stylesheet" type="text/css"/>

</head>





<body>

<%@include file="_header.jsp"%>


<section class="main container-fluid">
    <div class="container">

        <% User user = (User)request.getAttribute("user");
            if(user == null){
                user = new User();
            }
        %>

        <h1>Hey <%= user.getName() %> Welcome to the CogniPorter homepage!</h1>

        <div class="row-fluid">
            <div class="col-md-3">Sidebar</div>
            <div class="col-md-9">
                <tabset>
                    <tab heading="Search">
                        <div>
                            <form action="hello" method="post">
                                Name: <input type="text" name="name"/> <input type="submit" value="submit">
                            </form>
                        </div>
                    </tab>
                </tabset>
            </div>
        </div>
    </div>
</section>



<script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>