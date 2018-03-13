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
@WebServlet(urlPatterns = {"/confirmrequest"})
public class confirmrequest extends HttpServlet {

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
                   
                    out.write("<html><body>");
                    out.write("<img src='p15.jpg' width='50%' ><img src='p17.jpg' width='50%'><hr><br><br>");
                    
                    
                    out.write("<table align='left'>");
                    out.write("<tr><td><a href='seenrequest'>Go Back</td><td></td></tr>");
                    out.write("<br><br><hr>");
                    out.write("<br><br><hr>");
                    out.write("</table>");
                    try{
                      stmt=con.prepareStatement("Select members.name,sendingrequest.* from sendingrequest,members where remail=? and members.email=sendingrequest.email");
                            //stmt.setString(1,request.getParameter("r"));
                            stmt.setString(1,email);
                            //stmt.setString(2,request.getParameter("t1"));
                            rs=stmt.executeQuery();
                         // if(rs!=null)
                          //{    
                            String status="N";
                            while(rs.next())
                             {
                                String s1=rs.getString(1);
                                String senderemail=rs.getString(2);
                                String s2=rs.getString(5);
                                String s3=rs.getString(6);
                                
                                stmt=con.prepareStatement("Insert into seenrequest values(?,?,?,?,?,?)");
                                stmt.setString(1,senderemail);
                                stmt.setString(1,email);
                                stmt.setString(1,s1);
                                stmt.setString(1,s2);
                                stmt.setString(1,p1.Date.getDate());
                                stmt.setString(1,status);
                                
                                //String s4=rs.getString(6);
                                //String s5=rs.getString(7);
                                //String s6=rs.getString(8);
                                //String s7=rs.getString(9);
                                //String s8=rs.getString(10); 

                                //out.write("<tr><td>"+senderemail+"</td><td>"+s1+"</td><td>"+s2+"</td><td>"+s3+"</td><td><a href='confirmrequest?email="+senderemail+"'>ConFirm Request</a></td></tr>");             
                              }
                             //out.write("</table>");
                        
                             }catch(Exception e){System.out.println("Error:"+e);}
                    
                    out.write("<center><font color='red' size='50%'>Now, You added him into your Friend List!!!</font></center>");
                   // out.write("<table align='center'> <tr><td> <a href='index'>Home</a></td> <td></td> <td>"+sss+"</td> </tr></table>");
                   
                    
                    out.write("<br><br><hr>");
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
