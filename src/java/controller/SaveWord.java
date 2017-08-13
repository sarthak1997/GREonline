/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.wordDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.wordModel;

/**
 *
 * @author rohan
 */
public class SaveWord extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       ServletContext context=getServletContext();
       String add[]=request.getParameterValues("add");
       PrintWriter out=response.getWriter();
       HttpSession session=request.getSession();
       Boolean check=(Boolean)session.getAttribute("check");
       if(check==null)
       {
           check=false;
           session.setAttribute("check",check);
       }
       if(add[0].equals("Add Category"))
       {
           if(check==true)
           {
               String word=request.getParameter("word").toUpperCase();
               String meaning=request.getParameter("tag");
               
               if(meaning !=null)
                   meaning=meaning.toUpperCase();
               
               wordModel wm=new wordModel();
               wm.setWord(word);
               wm.setMeaning(meaning);
               
               wordDao wd=new wordDao();
               wd.addSynonym(wm,context);
               check=false;
               session.setAttribute("check",check);
               
           }
           else
           {
               String word=request.getParameter("word").toUpperCase();
               String broad=request.getParameter("tag");
               
               if(broad !=null)
                   broad=broad.toUpperCase();
               
               wordModel wm=new wordModel();
               wm.setWord(word);
               wm.setBroad(broad);
               wm.setMeaning(broad);
               
               wordDao wd=new wordDao();
               wd.addBaseWord(wm,context);
               
               
           }
       }
       else if(add[0].equals("Add Synonym"))
       {
           if(!check)
           {
               check=true;
               session.setAttribute("check",check);
               
               String word=request.getParameter("word").toUpperCase();
               String broad=request.getParameter("tag");
               
               if(broad !=null)
                   broad=broad.toUpperCase();
               
               wordModel wm=new wordModel();
               wm.setWord(word);
               wm.setBroad(broad);
               wm.setMeaning(broad);
               
               wordDao wd=new wordDao();
               wd.addBaseWord(wm,context);
               
           }
           else
           {
               String word=request.getParameter("word").toUpperCase();
               String meaning=request.getParameter("tag");
               
               if(meaning !=null)
                   meaning=meaning.toUpperCase();
               
               wordModel wm=new wordModel();
               wm.setWord(word);
               wm.setMeaning(meaning);
               
               wordDao wd=new wordDao();
               wd.addSynonym(wm,context);
           }
           
       }
       response.sendRedirect("adminHome.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
