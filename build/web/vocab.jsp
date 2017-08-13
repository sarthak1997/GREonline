<%-- 
    Document   : vocab
    Created on : 13 Dec, 2016, 11:07:37 PM
    Author     : rohan
--%>

<%@page import="dao.UserCatDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="am" scope="session" class="model.AlphaModel"/>
<%am.setFamily(null);%>

<jsp:useBean id="ucm" scope="session" class="model.userCatModel"/>
<jsp:setProperty name="ucm" property="userID" value="<%=(String)((model.userModel)session.getAttribute("user")).getUserID()%>"/>
<%

UserCatDao ucd=new UserCatDao();
ucd.getCategoryNo(ucm,application);
ucd.getCount(ucm,application, session);
session.setAttribute("MaxCounter",ucm.getCategory());
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VOCABULARY SECTION</title>
    </head>
    <body>
        <PRE>
        <h1>V O C A B U L A R Y   S E C T I O N                       WORD COUNT : <%=session.getAttribute("wc")%></h1><HR>
    
    <a href="words.jsp">NEW WORDS</a>

    <a href="Revision.jsp">REVISION</a>
    
   <HR>
    <a href="StudentHome.jsp">HOME</a>

    <a href="logout">LOG-OUT</a>
        <hr>
        </PRE>
 
  
    </body>
</html>
