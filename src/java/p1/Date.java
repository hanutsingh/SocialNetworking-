/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p1;

/**
 *
 * @author HANUT SINGH
 */
public class Date {
    
    public static String getDate()
    {
        java.util.Date d=new java.util.Date();
        return (d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate();                
    }
}
    

