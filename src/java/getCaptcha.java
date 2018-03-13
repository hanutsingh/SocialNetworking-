/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
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
@WebServlet(urlPatterns = {"/getCaptcha"})
public class getCaptcha extends HttpServlet {

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
            HttpSession hs=request.getSession(true);
            String id=hs.getId();
            String text=id.substring(0,6).toUpperCase();
            
            
            BufferedImage image = new BufferedImage(150,50, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2d = image.createGraphics();
            graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            
            Font font = new Font("Comic Sans MS", Font.BOLD, 24);
            graphics2d.setFont(font);
            FontMetrics fontmetrics = graphics2d.getFontMetrics();
            
            graphics2d.setColor(Color.RED);
            for(int i=0;i<text.length();i++)
            {
                    String s=text.substring(i,i+1);
                    int y=(int)(Math.random()*20+15);
                    graphics2d.drawString(s,i*15+2,y);
            }
            graphics2d.setColor(Color.RED);
            graphics2d.drawLine(0,10,50,30);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawLine(30,30,100,10);
            graphics2d.setColor(Color.BLUE);
            graphics2d.drawLine(0,18,100,18);
            graphics2d.dispose();
            OutputStream out=response.getOutputStream();
            ImageIO.write(image, "png", out);
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
