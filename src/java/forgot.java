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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HANUT SINGH
 */
@WebServlet(urlPatterns = {"/forgot"})
public class forgot extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     String getPassword()
    {
        String pass="";
        int n=(int)(Math.random()*7+8);
        int a=(int)(Math.random()*4+4);
        int d=n-a;
        for(int i=1;i<=a;i++)
        {
            int c=(int)(Math.random()*26+65);
            pass=pass+(char)c;
        }
        for(int i=1;i<=d;i++)
        {
            int c=(int)(Math.random()*10+48);
            pass=pass+(char)c;
        }
        return pass;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try{
                String msg1="";
                if(request.getParameter("b1")!=null)
                {
                    Class.forName("org.gjt.mm.mysql.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/SocialNetworking","root","");
                    PreparedStatement stmt=con.prepareStatement("Select * from Members where Email=?");
                    stmt.setString(1,request.getParameter("t1"));
                    ResultSet rs=stmt.executeQuery();
                    if(rs.next())
                    {
                       String name=rs.getString("name");
                       String to=request.getParameter("t1");
                       String subject="Password Reset Mail";
                       String password=getPassword();
                       
                       String messageText="Dear "+name+",<br>As per your request we have reset your password.New password is:<br>";
                       messageText+="Login: <b>"+to+"</b><br>";
                       messageText+="New Password: <b>"+password+"</b><br>";
                       messageText+="Thanks";
                       String host="smtp.gmail.com", user="hanutsingh786@gmail.com",pass="stems@10";
                       String from = user;
                       Properties props = System.getProperties();
                       props.put("mail.host", host);
                       props.put("mail.transport.protocol.", "smtp");
                       props.put("mail.smtp.auth", "true");
                       props.put("mail.smtp.", "true");
                       props.put("mail.smtp.port", "465");
                       props.put("mail.smtp.socketFactory.fallback", "false");
                       props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                       Session mailSession = Session.getDefaultInstance(props, null);
                       Message msg = new MimeMessage(mailSession);
                       msg.setFrom(new InternetAddress(from));
                       InternetAddress[] address = {new InternetAddress(to)};
                       msg.setRecipients(Message.RecipientType.TO, address);
                       msg.setSubject(subject);
                       msg.setContent(messageText, "text/html"); // use setText if you want to send text
                       Transport transport = mailSession.getTransport("smtp");
                       transport.connect(host, user, pass);
                       transport.sendMessage(msg, msg.getAllRecipients());
                       transport.close();
                       
                        stmt=con.prepareStatement("Update Users set password=? where email=?");
                        stmt.setString(1,password);
                        stmt.setString(2,to);
                        stmt.executeUpdate();
                        msg1="Check your Email for new Password";
                    }
                    else
                    {
                        msg1="Invalid Email!!!!!";
                    }
                }
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                out.write("<html><body>");
                out.write("<img src='p15.jpg' width='50%' ><img src='p17.jpg' width='50%' ><hr><br><br>");
                out.write("<table align='center'> <tr><td> <a href='index'>Home</a></td>  <td></td> <td><a href='register'>SignIn</a></td> <td></td>  <td><a href='login'>Login</a></td></tr></table>");
                out.write("<br><br><br><hr>");
                out.write("<form method='post'><table align='center'>");
                out.write("<tr><td>Login:</td><td><input type='text' name='t1'></td></tr>");
                out.write("<tr><td></td><td><input type='submit' name='b1' value='Retrieve Password'></td></tr>");
                out.write("<tr><td></td><td><font color='red'>"+msg1+"</font></td></tr>");
                out.write("</table></form>");
                out.write("<hr><br><br>");
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
