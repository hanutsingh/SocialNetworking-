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
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            
                String msg="";
                if(request.getParameter("b1")!=null)
                {
                    Class.forName("org.gjt.mm.mysql.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/SocialNetworking","root","");
                    PreparedStatement stmt=con.prepareStatement("Select * from users where Email=? and password=?");
                    stmt.setString(1,request.getParameter("t1"));
                    stmt.setString(2,request.getParameter("t2"));
                    
                    ResultSet rs=stmt.executeQuery();
                    if(rs.next())
                    {
                        HttpSession hs=request.getSession(true);
                        
                        hs.setAttribute("CON",con);
                        hs.setAttribute("EMAIL",request.getParameter("t1"));
                        response.sendRedirect("myaccount");
                   }
                    else
                    {
                        msg="Invalid Login/Password!!!";
                    }
                }
                
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                
                out.write("<html><body bgColor='lightgray'>");
                out.write("<img src='p15.jpg' width='50%' ><img src='p17.jpg' width='50%' ><hr><br>");
                 
                out.write("<table align='center'> <tr><td> <a href='index'>Home</a></td> <td><a href='register'>SignIn</a></td> <td><a href='login'>Login</a></td></tr></table>");
                out.write("<br><br>");
                out.write("<form method='post'>");
                out.write("<table align='center' >");
                
               
                out.write("<tr> <td>Email:</td> <td>Password:</td> <td></td> </tr>");
                out.write("<tr> <td><input type='email' name='t1' ></td> <td><input type='password' name='t2' ></td> <td><input type='submit' name='b1' value='Log In'></td> </tr>");
                
                out.write("<tr>  <td><font color='red'>"+msg+"</font></td> <td></td> <td></td> </tr>");
                out.write("<tr>  <td><a href='register'>Register</a></td> <td><a href='forgot'>Forgot Password</a></td> <td></td> </tr>");
                out.write("<hr>");
                out.write("</table></form>");
                out.write("<br><br><hr>");
                out.write("<img src='p11.jpg' width='50%'><img src='p5.jpg' width='50%'>");
                
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
