/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HANUT SINGH
 */
@WebServlet(urlPatterns = {"/comment"})
public class comment extends HttpServlet {

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
   {
        try{
                
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                
                out.write("<html><body bgColor='lightgray'>");
                out.write("<img src='p15.jpg' width='50%' ><img src='p17.jpg' width='50%' ><hr><br><br>");
                 
                out.write("<table width='100%'> <tr><td> <a href='index'>Home</a></td> <td><a href='register'>Account</a></td> <td><a href='comment'>My Comment</a></td> <td><a href='edit'>Edit Account</a></td> <td><a href='changepassword'>Change Password</a></td> <td><a href='login'>Login</a></td></tr></table>");
                
                out.write("<form method='post' action='login' >");
                out.write("<table align='Right'>");
               
                out.write("<td></td><td>Comment!!!</td><br>");               
                out.write("<hr>");
                out.write("</table></form>");
                
                out.write("<hr><br><br>");
                out.write("<img src='p11.jpg' width='50%'><img src='p5.jpg' width='50%'>");
                out.write("<br><br><hr>");
               
                out.write("</body></html>");
        }catch(Exception ee){}
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
