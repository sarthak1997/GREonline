/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.userDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.userModel;

/**
 *
 * @author rohan
 */
public class verifyuser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context=getServletContext();
        
       String id=request.getParameter("id");
       String pwd=request.getParameter("pwd");
       String utype=request.getParameter("utype");
      
       if(utype.equals("Student"))
       {
       
       userModel um=new userModel();
      
       um.setUserID(id);
       um.setPassword(pwd);
        
       userDao ud=new userDao();
       Boolean check=ud.checkUser(um,context);
       
       if(check)
       {
           HttpSession session=request.getSession();
           session.setAttribute("user",um);
           response.sendRedirect("StudentHome.jsp");
       }
       else
       {
           response.getWriter().println("<pre><h1><center>I N V A L I D   U S E R</center></h1></pre>");
       }
       }
      
       else
       {
           if(id.equals("Globalizers")&&pwd.equals("Globalizers"))
           {response.sendRedirect("adminHome.jsp");}
           else
           {
               response.getWriter().println("<h1><pre> I N V A L I D   A D M I N</pre></h1>");
           }
       }
       
        
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
