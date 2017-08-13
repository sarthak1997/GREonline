<%-- 
    Document   : words
    Created on : 14 Dec, 2016, 2:52:36 PM
    Author     : rohan
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.userModel" %>
<%@page import="dao.UserCatDao"%>
<!DOCTYPE html>

<jsp:useBean id="ucm" scope="session" class="model.userCatModel"/>

<%
if(request.getParameter("word")!=null)
{
    ucm.setCategory((Integer.parseInt(request.getParameter("categoryNo")))-1);
}
    
UserCatDao ucd=new UserCatDao();
ucd.synonym(ucm,application);
ArrayList Synonym=ucm.getSynonym();
ArrayList Meaning=ucm.getMeaning();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VOCABULARY</title>
    </head>
    <body>
        <pre><h1>                                                      WORD COUNT : <%=session.getAttribute("wc")%></h1><form action="NextWord"><fieldset><legend style="font-size : 50pt" align="center"><%=Synonym.get(0)%></legend><h1>MEANING   :</h1><div style="font-size : 15pt"><%=Meaning.get(0)%></div><hr><h1>SYNONYMS  :</h1><div style="font-size : 15pt"><% for(int i=1;i<Synonym.size();i++){%>
    <%=i+". "+(String)Synonym.get(i)%><%="    \t\t:\t\t"%><%=Meaning.get(i)%><%}%></div>      
     
     <center><input type="submit" name="submit" value="PREVIOUS CATEGORY"/>  <input type="submit" name="submit" value="NEXT CATEGORY"/></center>
       </fieldset>
        </form>
    <a href="vocab.jsp">VOCAB-SECTION</a> 

    <a href="verbal.jsp">VERBAL-SECTION</a>
        </pre>
    </body>
</html>
