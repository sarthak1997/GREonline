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
import model.userCatModel;

/**
 *
 * @author rohan
 */
public class UserCatDao {
    
    Connection con;
    PreparedStatement ps,ps1;
    public void getCount(userCatModel ucm,ServletContext context, HttpSession session)
    {
        try
        {
        int cat=ucm.getCategory();
        String qr= "select Count(Synonym) from synonym where CategoryNo<=?";
        con=(Connection)context.getAttribute("datacon");
        ps=con.prepareStatement(qr);
        ps.setInt(1,cat);
        ResultSet rs=ps.executeQuery();
        rs.next();
        int wc=rs.getInt(1);
        session.setAttribute("wc",wc);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void updateCategory(userCatModel ucm,ServletContext context,HttpSession session)
    {
        try
        {
            int MaxCounter=(int)session.getAttribute("MaxCounter");
            
            if(MaxCounter==ucm.getCategory())
            { con=(Connection)context.getAttribute("datacon");
            String qr="update userCat set CategoryNo=? where userID=?";
            ps=con.prepareStatement(qr);
            ps.setInt(1,MaxCounter+1);
            ps.setString(2,ucm.getUserID());
            ps.executeUpdate();
            session.setAttribute("MaxCounter",MaxCounter+1);
            ucm.setCategory(ucm.getCategory()+1);
            getCount(ucm,context, session);
            }
            else
                ucm.setCategory(ucm.getCategory()+1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void getCategoryNo(userCatModel ucm,ServletContext context)
    {
       
        try{
       con=(Connection)context.getAttribute("datacon");
       String qr="select * from userCat where userID=?";
       ps=con.prepareStatement(qr);
       ps.setString(1,ucm.getUserID());
       ResultSet rs=ps.executeQuery();
       if(rs.next())
       {
         ucm.setCategory(rs.getInt(2));  
       }
       else
       {
           ucm.setCategory(0);
           insert(ucm,context);
       }
      
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
       
    }
    
    public void synonym(userCatModel ucm,ServletContext context)
    {
        try{
       con=(Connection)context.getAttribute("datacon");
       String qr="select Synonym,Meaning from synonym where CategoryNo=?";
       ps=con.prepareStatement(qr);
       ps.setInt(1,ucm.getCategory()+1);
       ResultSet rs=ps.executeQuery();
      
       String qr1="select Word,BroadMeaning from words where CategoryNo=?";
       ps1=con.prepareStatement(qr1);
       ps1.setInt(1,ucm.getCategory()+1);
       ResultSet rs1=ps1.executeQuery();
      
       
        ArrayList listSyn;
        ArrayList listMean;
        
        listSyn=new ArrayList();
        listMean=new ArrayList();
        
       String wrd,mean,wrd1,mean1;
       if(rs1.next())
       {
       wrd=rs1.getString(1);
       mean=rs1.getString(2);
       listSyn.add(wrd);
       listMean.add(mean);
       
       
       while(rs.next())
       {
           wrd1=rs.getString(1);
           mean1=rs.getString(2);
           if(!wrd1.equals(wrd))
           {
               listSyn.add(wrd1);
               listMean.add(mean1);
           }
       }
       
       ucm.setSynonym(listSyn);
       ucm.setMeaning(listMean);
       }
       else
       {
       ucm.setSynonym(null);
       ucm.setMeaning(null);
       }
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void insert(userCatModel ucm,ServletContext context)
    {
        try{
       con=(Connection)context.getAttribute("datacon");
       String qr="insert into userCat values (?,?)";
       
       ps=con.prepareStatement(qr);
       ps.setString(1,ucm.getUserID());
       ps.setInt(2, ucm.getCategory());
       ps.executeUpdate();
       
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
}
