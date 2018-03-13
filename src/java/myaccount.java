/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(urlPatterns = {"/myaccount"})
public class myaccount extends HttpServlet {

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
                String sss=" <td></td> <td><a href='register'>SignIn</a></td> <td><a href='login'>Login</a></td>";
                
                Connection con=null;
                PreparedStatement stmt=null;
                ResultSet rs=null;
               
                String email=null;
                HttpSession hs=request.getSession(false);
                if(hs!=null)
                {
                     sss="<td><a href='myaccount'>My Account</a></td> <td><a href='searchfriend'>Search Friend</a></td> <td><a href='seenrequest'>Seen Request</a></td> <td><a href='logout'>Logout</a></td>";
                    con=(Connection)hs.getAttribute("CON");
                    email=hs.getAttribute("EMAIL").toString();
                }
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                
                out.write("<html><body bgColor='#996699'>");
                out.write("<img src='p15.jpg' width='50%' ><img src='p17.jpg' width='50%' ><hr><br><br>");
                 
                out.write("<table align='center'> <tr><td> <a href='index'>Home</a></td> <td></td> <td>"+sss+"</td> </tr></table>");
                 stmt=con.prepareStatement("Select * from members where email=?");
                stmt.setString(1,email);
                rs=stmt.executeQuery();
                rs.next();
                
                 String s=rs.getString(7);
                
                out.write("<form method='post'>");
                out.write("<table align='center'>");
                out.write("<tr><td>Email:</td><td><b>"+rs.getString(1)+"</b></td></tr>");
                out.write("<tr><td>Password:</td><td><input type='password' name='t2'></td></tr>");
                //out.write("<tr><td>Re Type:</td><td><input type='password' name='t3'></td></tr>");
                out.write("<tr><td>Name:</td><td><b>"+rs.getString(2)+"</b></td></tr>");
                out.write("<tr><td>DOB:</td><td><b>"+rs.getString(3)+"</b></td></tr>");
                out.write("<tr><td>Gender:</td><td><b>"+rs.getString(4)+"</b></td></tr>");
                out.write("<tr><td>Country:</td><td><b>"+rs.getString(5)+"</b></td></tr>");
                out.write("<tr><td>State:</td><td><b>"+rs.getString(6)+"</b></td></tr>");
                out.write("<tr><td>City:</td><td><b>"+rs.getString(7)+"</b></td></tr>");
                out.write("<tr><td>Hobbies:</td><td><b>"+rs.getString(8)+"</b></td></tr>");
                out.write("<tr><td>School Name:</td><td><b>"+rs.getString(9)+"</b></td></tr>");
                out.write("<tr><td>College Name:</td><td><b>"+rs.getString(10)+"</b></td></tr>");
                out.write("<tr><td></td><td><input type='submit' name='b1' value='Change Password'></td></tr>");
                out.write("</table></form>");
                out.write("<br><br><hr>");
                
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
