/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HANUT SINGH
 */
@WebServlet(urlPatterns = {"/index"})
public class index extends HttpServlet {

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
               String ss="<td><a href='register'>Sign Up Today!!!</a></td><br>";
               String sss="<td></td> <td><a href='register'>SignIn</a></td> <td><a href='login'>Login</a></td>";
                Connection con=null;
                PreparedStatement stmt=null;
               
                String email=null;
                HttpSession hs=request.getSession(false);
                if(hs!=null)
                {
                   ss="<td><a href='newaccount'>Create Another Account!!!</a></td><br>";
                     sss="<td><a href='myaccount'>My Account</a></td> <td><a href='searchfriend'>Search Friend</a></td> <td><a href='seenrequest'>Seen Request</a></td> <td><a href='logout'>Logout</a></td>";
                    con=(Connection)hs.getAttribute("CON");
                    email=hs.getAttribute("EMAIL").toString();
               }
                else
                {
                    Class.forName("org.gjt.mm.mysql.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/SocialNetworking","root","");
                }                
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                
                out.write("<html><body bgColor='lightgray'>");                 
                out.write("<img src='p15.jpg' width='50%'><img src='p17.jpg' width='50%'> <hr><br><br>");
                 
                out.write("<table align='center'> <tr><td><a href='index'>Home</a></td>"+sss+"</tr></table>");
               
                out.write("<table align='Right'>");
                out.write(ss);               
                out.write("<hr>");
                out.write("</table><br><br>");
                out.write("<br><br><hr>");
                out.write("<img src='p11.jpg' width='50%'><img src='p5.jpg' width='50%'>");
                 
                out.write("</body></html>");
        }catch(Exception ee)
            {
                System.out.println("Error is:"+ee);
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
