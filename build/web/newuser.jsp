<%-- 
    Document   : newuser
    Created on : 4 Dec, 2016, 12:38:51 PM
    Author     : rohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WELCOME</title>
    </head>
    <body>
        <PRE>
        <h1><center>WELCOME  TO  GRE  ONLINE</center></h1><hr>
        CREATE YOUR ACCOUNT HERE :
        <form action="SaveUser" method="post">
        First Name  <input type="text" name="fname"/>
        Last Name   <input type="text" name="lname"/>
        Email-ID    <input type="text" name="email"/>
        Password    <input type="password" name="pwd"/>
        DOB         <input type="text" name="dob"/>
        
            <input type="submit" value="SIGN-UP"/>
        </form>
        <hr>
        <a href="index.html">HOME</a>

        <a href="login.jsp">EXISTING-USER</a><pre><hr>
        </PRE>
    </body>
</html>
