<%-- 
    Document   : Revision
    Created on : 16 Dec, 2016, 8:43:24 PM
    Author     : rohan
--%>
<%@page import="dao.AlphaDao"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="am" scope="session" class="model.AlphaModel"/>
<%
ArrayList family=am.getFamily();
ArrayList categories=am.getCategories();
AlphaDao ad=new AlphaDao();
char MaxAlpha=ad.getMaxAlpha(application, session);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REVISION TIME</title>
    </head>
    <body>
        <PRE><h1>R E V I S I O N</h1><HR>
<%for(char i='A';i<=MaxAlpha;i++){%><a href="RevisionController?alpha=<%=i%>"><div style="display: inline; font-size: 16pt"><%=i%></div></a><%="    "%><%}%><hr>
 <%if(family!=null)
{for(int i=0;i<family.size();i++){%>
<%=(i+1)+". "%><a href="words.jsp?word=<%=family.get(i)%>&categoryNo=<%=categories.get(i)%>"><%=family.get(i)+"\n"%></a><%}}%> <hr>

<a href="vocab.jsp">VOCAB-SECTION</a> 

<a href="verbal.jsp">VERBAL-SECTION</a>
<hr>
          
        </pre>    
    </body>
</html>
