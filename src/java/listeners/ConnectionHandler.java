/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import javax.servlet.ServletContext;

/**
 * Web application lifecycle listener.
 *
 * @author rohan
 */
public class ConnectionHandler implements ServletContextListener {

    Connection con;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //To change body of generated methods, choose Tools | Templates.
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/greOnline","root","root");  
        
        ServletContext context=sce.getServletContext();
        context.setAttribute("datacon",con);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      //To change body of generated methods, choose Tools | Templates.
    try{
        con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    
    }
    
}
