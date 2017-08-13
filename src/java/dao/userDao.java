/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.userModel;

/**
 *
 * @author rohan
 */
public class userDao {
    Connection con;
    PreparedStatement ps;
    
    public Boolean insertUser(userModel um,ServletContext context)
    {
        try
        {
        con = (Connection) context.getAttribute("datacon");
        String qr="insert into users values(?,?,?,?,?)";
        ps=con.prepareStatement(qr);
        ps.setString(1,um.getUserID());
        ps.setString(2,um.getFirstName());
        ps.setString(3,um.getLastName());
        ps.setString(4,um.getPassword());
        ps.setString(5,um.getDOB());
        
       return ps.executeUpdate()>0;
        }
        catch(Exception e)
        {
            
        }
       return null;
    }
    
    public Boolean checkUser(userModel um,ServletContext context)
    {
        try{
            con = (Connection) context.getAttribute("datacon");
            String qr="select * from users where userID=? and password=?";
            ps=con.prepareStatement(qr);
            ps.setString(1,um.getUserID());
            ps.setString(2,um.getPassword());
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next())
            {
             um.setFirstName(rs.getString(2).toUpperCase());
             um.setLastName(rs.getString(3).toUpperCase());
             um.setDOB(rs.getString(5));
                return true;
            }
            else
                return false;
        }
        catch(Exception e)
        {
            
        }
        return null;
    }
    
}
