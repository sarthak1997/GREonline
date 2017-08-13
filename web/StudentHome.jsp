
<jsp:useBean scope="session" id="user" class="model.userModel"/>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GRE - ONLINE</title>
    </head>
    
        <pre>
        <h1>G R E- O N L I N E</h1><HR><div style="font-size: 15">WELCOME : <jsp:getProperty name="user" property="firstName"/> <jsp:getProperty name="user" property="lastName"/></div><hr>
       
    <a href="verbal.jsp">VERBAL</a>

    <a href="quant.jsp">QUANT</a>
         <hr>
    <a href="logout">LOG-OUT</a>
         <hr>
        </pre>
    

