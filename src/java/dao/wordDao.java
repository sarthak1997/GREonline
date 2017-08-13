/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.servlet.ServletContext;
import model.wordModel;

/**
 *
 * @author rohan
 */
public class wordDao {
    Connection con;
    PreparedStatement ps;
     public void addBaseWord(wordModel wm,ServletContext context)
     {
         try
         {
        con=(Connection)context.getAttribute("datacon");
        String qr="insert into words(Word,BroadMeaning) values(?,?)";
        ps=con.prepareStatement(qr);
        ps.setString(1,wm.getWord());
        ps.setString(2,wm.getBroad());
        ps.executeUpdate();
        addSynonym(wm,context);
        
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         
     }
     public void getCategory(wordModel wm,ServletContext context)
     {
         try
         {
        con=(Connection)context.getAttribute("datacon");
        String cat="select max(CategoryNo) from words";
        ps=con.prepareStatement(cat);
        ResultSet rs=ps.executeQuery();
        rs.next();
        cat=rs.getString(1);
        wm.setCategoryno(Integer.parseInt(cat));
         }
          catch(Exception e)
          {
               System.out.println(e);
          }
         
     }
     public void addSynonym(wordModel wm,ServletContext context)
     {
         try
         {
        getCategory(wm,context);
        con=(Connection)context.getAttribute("datacon");
        String qr="insert into synonym values(?,?,?)";
        ps=con.prepareStatement(qr);
        ps.setInt(1,wm.getCategoryno());
        ps.setString(2,wm.getWord());
        ps.setString(3,wm.getMeaning());
        ps.executeUpdate();
         }
         catch(Exception e)
         {
              System.out.println(e);
         }
     }
     
     
    
}
