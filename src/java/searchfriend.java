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
@WebServlet(urlPatterns = {"/searchfriend"})
public class searchfriend extends HttpServlet {

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
              
                String sss="<td></td> <td><a href='register'>SignIn</a></td> <td><a href='login'>Login</a></td>";
                
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
                   
                    out.write("<html><body bgColor='#996699'>");
                    out.write("<img src='p15.jpg' width='50%' ><img src='p17.jpg' width='50%'><hr><br><br>");
                    out.write("<table align='center'> <tr><td> <a href='index'>Home</a></td> <td></td> <td>"+sss+"</td> </tr></table>");

                    out.write("<form method='post'>");
                    out.write("<table align='center'>");

                    out.write("<tr><td></td><td><input type='radio' name='r' value='Name'></td><td>Name</td></tr>");
                    out.write("<tr><td></td><td><input type='radio' name='r' value='gender'></td><td>Gender</td></tr>");
                    out.write("<tr><td></td><td><input type='radio' name='r' value='country'></td><td>Country</td></tr>");
                    out.write("<tr><td></td><td><input type='radio' name='r' value='State'></td><td>State</td></tr>");
                    out.write("<tr><td></td><td><input type='radio' name='r' value='City'></td><td>City</td></tr>");
                    out.write("<tr><td></td><td><input type='radio' name='r' value='Hobbies'></td><td>Hobbies</td></tr>");
                    out.write("<tr><td></td><td><input type='radio' name='r' value='SchoolName'></td><td>School Name</td></tr>");
                    out.write("<tr><td></td><td><input type='radio' name='r' value='CollegeName'></td><td>College Name</td></tr>");
                    
                    out.write("<tr><td></td><td></td><td></td></tr>");
                    out.write("<tr><td><input type='text' name='t1'></td><td></td><td></td></tr>");

                    out.write("<tr><td></td><td></td><td><input type='submit' name='b1' value='Seach'></td></tr>");
                    out.write("</table></form>");
                    out.write("<br><br><hr>");

              /*      stmt=con.prepareStatement("Select * from members where email=?");
                    stmt.setString(1,email);
                    rs=stmt.executeQuery();
                    rs.next();                       */
                    
                /*   // String n=rs.getString("Name");
                    //String cou=rs.getString("Country");
                    //String s=rs.getString("State");
                    String c=rs.getString("City");
                    //String h=rs.getString("Hobbies");
                    //String sn=rs.getString("SchoolName");
                    //String cn=rs.getString("CollegeName");
                    
                    
                    //String nam=rs.getString(2);            */
                    
                 
                    
                  
                    if(request.getParameter("b1")!=null)
                    {   
                        try{
                            out.write("<table align='center' border='2' cellspacing='15'>");
                            out.write("<tr><th>NAME</th><th>GENDER</th><th>COUNTRY</th><th>STATE</th><th>CITY</th><th>HOBBIES</th><th>SCHOOL</th><th>COLLEGE</th></tr>");
                        
                            stmt=con.prepareStatement("Select * from members where "+request.getParameter("r")+"=? and email != ?");
                            //stmt.setString(1,request.getParameter("r"));
                            stmt.setString(1,request.getParameter("t1"));
                            stmt.setString(2,email);
                            rs=stmt.executeQuery();
                         // if(rs!=null)
                          //{     
                            while(rs.next())
                             {
                                String receiveremail=rs.getString(1);
                                String s1=rs.getString(2);
                                String s2=rs.getString(4);
                                String s3=rs.getString(5);
                                String s4=rs.getString(6);
                                String s5=rs.getString(7);
                                String s6=rs.getString(8);
                                String s7=rs.getString(9);
                                String s8=rs.getString(10); 

                                out.write("<tr><td>"+s1+"</td><td>"+s2+"</td><td>"+s3+"</td><td>"+s4+"</td><td>"+s5+"</td><td>"+s6+"</td><td>"+s7+"</td><td>"+s8+"</td><td><a href='sendingrequest?email="+receiveremail+"'>Add Friend</a></td></tr>");             
                              }
                             out.write("</table>");
                        
                             }catch(Exception e){System.out.println(e);}
                      //}
                        out.write("<center><font color='red' size='50%'>No Record Found!!!</font></center>");
                }
                         
    
                  /*  stmt=con.prepareStatement("Select * from members where city=? and email !=? order by name");
                    //stmt.setString(1,"Name");
                    stmt.setString(1,c);
                    stmt.setString(2,email);
                    rs=stmt.executeQuery();
                        while(rs.next())
                        {
                            String s1=rs.getString(2);
                            String s2=rs.getString(4);
                            String s3=rs.getString(5);
                            String s4=rs.getString(6);
                            String s5=rs.getString(7);
                            String s6=rs.getString(8);
                            String s7=rs.getString(9);
                            String s8=rs.getString(10);           
                         
                            out.write("<tr><td>"+s1+"</td><td>"+s2+"</td><td>"+s3+"</td><td>"+s4+"</td><td>"+s5+"</td><td>"+s6+"</td><td>"+s7+"</td><td>"+s8+"</td><td><a href='#'>Add Friend</td></tr>");             */
               
                out.write("<br><br><hr>");
                
                out.write("<img src='p11.jpg' width='50%'><img src='p5.jpg' width='50%'>");
                out.write("</body></html>");
                
                }
               else
                {
                    response.sendRedirect("login");
                } 
               
                
                
        }catch(Exception ee){System.out.println(ee);}
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
