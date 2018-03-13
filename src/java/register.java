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
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
                 try{
                if(request.getParameter("b1")!=null)
                {
                    String cap=request.getParameter("t13");
                    HttpSession hs=request.getSession(false);
                    String id=hs.getId();
                    String text=id.substring(0,6).toUpperCase();
                    
                         if(cap.equals(text))
                         {
                            Class.forName("org.gjt.mm.mysql.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/SocialNetworking","root","");
                            
                            PreparedStatement stmt=con.prepareStatement("Insert into Members values(?,?,?,?,?,?,?,?,?,?)");

                            stmt.setString(1,request.getParameter("t1"));
                            stmt.setString(2,request.getParameter("t4"));
                            stmt.setString(3,request.getParameter("t5"));
                            stmt.setString(4,request.getParameter("t6"));
                            stmt.setString(5,request.getParameter("t7"));
                            stmt.setString(6,request.getParameter("t8"));
                            stmt.setString(7,request.getParameter("t9"));
                            stmt.setString(8,request.getParameter("t10"));
                            stmt.setString(9,request.getParameter("t11"));
                            stmt.setString(10,request.getParameter("t12"));
                            stmt.executeUpdate();

                            stmt=con.prepareStatement("Insert into users values(?,?)");
                            stmt.setString(1,request.getParameter("t1"));
                            stmt.setString(2,request.getParameter("t2"));
                            stmt.executeUpdate();

                            con.close();
                            response.sendRedirect("login");
                            }
                            else
                            {
                                msg="Invalid Captcha!!!";
                            }
                } 
                 }catch(Exception eee){System.out.println(eee);};
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                
                out.write("<html><body bgColor='lightgray'>");
                out.write("<img src='p15.jpg' width='50%' ><img src='p17.jpg' width='50%' ><hr><br><br>");
                 
                out.write("<table align='center'> <tr><td> <a href='index'>Home</a></td> <td><a href='register'>SignIn</a></td> <td><a href='login'>Login</a></td></tr></table>");
                out.write("<hr>");
                
                out.write("<form method='post' >");
                out.write("<table align='Center'>");
                out.write("<center><font color='red' size='50%'>Sign In Today!!!</font></center>");
               // out.write("<tr>");
                //out.write("<td> Email:</td> <td><input type='email' name='t1' ></td>");
                //out.write("<td> Password:</td> <td><input type='password' name='t2' ></td>");
                //out.write("<td> </td> <td><input type='submit' name='b1' value='LogIn'></td>");
                //out.write("</tr>");
                //out.write("<hr>");
                
                //out.write("<td></td><td><b><u><font size='60%'>Sign In Today!!!</font></b></u></td><br>");               
                
                
                out.write("<tr> <td>Email:</td> <td><input type='email' name='t1'></td> </tr>");
                out.write("<tr> <td>Password:</td> <td><input type='password' name='t2'></td> </tr>");
                 out.write("<tr> <td>Re-Type:</td> <td><input type='password' name='t3'></td> </tr>");
                out.write("<tr> <td>Name:</td> <td><input type='text' name='t4' ></td> </tr>");
               
                out.write("<tr> <td>Birthday:</td> <td><input type='date' name='t5' ></td> </tr>");
                out.write("<tr> <td>Gender:</td> <td><select name='t6'> <option>Male</option> <option>Female</option> </select></td></tr>");
                
                out.write("<tr> <td>Country:</td> <td><select name='t7'> <option>India</option> <option>Pakistan</option> <option>Singapore</option> <option>China</option> <option>Japan</option> <option>Germany</option> </select></td> </tr>");
                out.write("<tr> <td>State:</td> <td><select name='t8'> <option>Uttar Pradesh</option> <option>Uttrakhand</option> <option>dehradun</option> <option>Jammu</option> <option>Delhi</option> <option>Bihar</option> </select></td> </tr>");
                out.write("<tr> <td>City:</td> <td><select name='t9'><option>Meerut</option><option>Amritsar</option><option>Lucknow</option><option>Roorkee</option><option>Delhi</option></select></td></tr>");
                
                out.write("<tr><td>Hobbies:</td> <td><select name='t10'><option>Cricket</option><option>football</option><option>Hockey</option><option>Badminton</option><option>Coding</option><option>Designing</option><option>Reading</option><option>Writing</option><option>Swimming</option></select></td></tr>");
                out.write("<tr><td>SchoolName:</td> <td><input type='text' name='t11' ></td></tr>");
                out.write("<tr><td>CollegeName:</td> <td><input type='text' name='t12' ></td></tr>");
                out.write("<tr><td>Enter Captcha:</td><td><input type='text' name='t13' size='7'><img src='getCaptcha' height='50' width='150'></td></tr>");
                
                out.write("<tr><td></td><td>"+msg+"</td></tr>");
                //out.write("<tr><td>Photo:</td><td><input type='file' name='t9'></td></tr>");
                
                out.write("<tr><td><input type='submit' name='b1' value='Sign In'></td></tr>");
                
                out.write("</table></form>");
                out.write("<br><br><hr>");
                out.write("<img src='p11.jpg' width='50%'><img src='p5.jpg' width='50%'>");
                 
                out.write("</body></html>");
        }catch(Exception ee){System.out.println("Error "+ee);}
        
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
