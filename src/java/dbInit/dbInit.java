/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbInit;

/**
 *
 * @author rohan
 */
import java.sql.*;
public class dbInit {
    
    public static void main(String args[])
    {
        DDL();
    }
    
    public static void DDL()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        try
        {
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/greOnline","root","root");  
       // String qr="create database greOnline";
        Statement stmt=con.createStatement();
      //  stmt.execute(qr);
        //String qr1="use greOnline";
        /*stmt.execute(qr1);
        String qr2="create table users(userID varchar(50),firstName varchar(20),lastName varchar(20),password varchar(20),DOB varchar(15),primary key(userID))";
        stmt.execute(qr2);*/
       //String qr3="create table words(CategoryNo int not null auto_increment, Word varchar(25), BroadMeaning varchar (35),primary key(CategoryNo))";
     // stmt.execute(qr3);
        
        //String qr4="create table synonym(CategoryNo int, Synonym varchar(25), Meaning varchar (35),primary key(CategoryNo,Synonym))";
       // stmt.execute(qr4);
       
        String qr5="create table userCat(userID varchar(50),CategoryNo int,primary key(userID))";
        stmt.execute(qr5);
        con.close();
        }
        catch(Exception e)
        {
        System.out.print(e);
        }
        
    }
    
}
