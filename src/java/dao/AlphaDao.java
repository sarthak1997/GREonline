/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.AlphaModel;

/**
 *
 * @author rohan
 */
public class AlphaDao {
    Connection con;
    PreparedStatement ps;
    
    public char getMaxAlpha(ServletContext context,HttpSession session)
    {
        try
        {
        int MaxCounter=(int)session.getAttribute("MaxCounter");
        con=(Connection)context.getAttribute("datacon");
        String qr="select Word from words where CategoryNo=?";
        ps=con.prepareStatement(qr);
        ps.setInt(1,MaxCounter);
        ResultSet rs=ps.executeQuery();
        String alpha="";
        if(rs.next())
        {
            alpha=rs.getString(1);
            
        }
        return alpha.charAt(0);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
       
    }
    
    public void fetchFamily(AlphaModel am,ServletContext context,HttpSession session)
    {
        try{
         
        con=(Connection)context.getAttribute("datacon");
        String qr="select Word,CategoryNo from words where word like ? and CategoryNo <= ?";
        ps=con.prepareStatement(qr);
        ps.setString(1,am.getAlpha()+"%");
        ps.setInt(2,(Integer)session.getAttribute("MaxCounter"));
        ResultSet rs=ps.executeQuery();
        ArrayList family=new ArrayList();
        ArrayList categories=new ArrayList();
        while(rs.next())
        {
           family.add(rs.getString(1));
           categories.add(rs.getString(2));
        }
        am.setFamily(family);
        am.setCategories(categories);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
