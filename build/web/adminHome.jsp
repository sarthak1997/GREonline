<%-- 
    Document   : adminHome
    Created on : 14 Dec, 2016, 10:38:41 AM
    Author     : rohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Admin </title>
    </head>
    <body>
        <pre>
        <h1>WELCOME GLOBALIZERS</h1>
        <form action="SaveWord">
            <fieldset>
                <legend align="center"><h1>ADD WORDS</h1></legend>
  WORD    <input type="text" name="word"/>
  
  MEANING <input type="text" name="tag"/> 
  
           
        <input type="submit" value="Add Synonym" name="add"/>        <input type="submit"value="Add Category" name="add"/> 
            </fieldset> 
</form>
<a href="logout">LOG-OUT</a>
        </pre>
        
    </body>
</html>
