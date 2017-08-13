<%-- 
    Document   : login
    Created on : 4 Dec, 2016, 12:24:06 PM
    Author     : rohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOG IN</title>
        <style>
            
            h1{
                color:blue;
                font-size:25pt;
            }
        </style>
    </head>
    <body>
        <pre>
        <h1>G R E - O N L I N E</h1><hr>
        <form action="verifyuser" method="post">
            USER-ID     <input type="text" name="id"/>
            PASSWORD    <input type="password" name="pwd"/>
            USER-TYPE   <select name="utype" ><option> Student </option><option> Admin </option></select>
            SAVE PASSWORD <input type="checkbox" value="yes" name="sp"/>
            
            <input type="submit" value="LOG-IN"/>
        </form>
        <hr>
        <a href="newuser.jsp">NEW ACCOUNT</a>

        <a href="index.html">HOME</a>
        <hr>
        <pre>
    </body>
</html>
