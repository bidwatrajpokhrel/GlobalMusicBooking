/*
Java Project Group 1 -- GlobalMusic Festival Booking Agency System
Bidwat Raj Pokhrel - 1812483
Aastha Pandey - 1814220
Kapendra Kathayat - 1822753
Numa Rai - 1822754
*/


/*


THIS CLASS DEALS WITH ALL VALIDATIONS USED IN THE PROGRAM


*/


package AdminDashboard;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

public class Validation{
    
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    Statement s = null;
    
    Validation(){

    
    try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg","root","");
        } catch (SQLException ex) {
            Logger.getLogger(AdminDash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
   
     public boolean nameTest(String name){
        String pattern = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(name);
        return match.matches();
    }
    
    public boolean emailTest(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(emailPattern);
        Matcher match = p.matcher(email);
        return match.matches();
    }
    
    public boolean usernTest(String usern){
        String pattern = "^[a-z0-0_-]{3,10}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(usern);
        return match.matches();
    }
    
    public boolean phoneTest (String phone){
        String pattern = "^[0-9]{7,13}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(phone);
        return match.matches();
    }
    
    public boolean testNumber (String number){
        String pattern = "^[0-9]{0,20}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(number);
        return match.matches();
    }
    
    public boolean testWebsite(String website){
        String pattern = "(:?(?:https?:\\/\\/)?(?:www\\.)?)?[-a-z0-9]+\\.(?:com|gov|org|net|edu|biz)";              
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(website);
        return match.matches();
    }
    
    public boolean username_repeat(String username){
        boolean repeat = false;
        try {
            String query = "SELECT userName FROM user";
            s = con.createStatement();
            rs = s.executeQuery(query);            
            while (rs.next()){
                if (rs.getString("userName").equals(username)){
                    repeat = true;
                    break;
                }                
            }           
        } catch (SQLException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return repeat;
    }    
    
    public boolean email_repeat(String email){
        boolean repeat = false;
        try {
            String query = "SELECT email FROM user";
            s = con.createStatement();
            rs = s.executeQuery(query);            
            while (rs.next()){
                if (rs.getString("email").equals(email)){
                    repeat = true;
                    break;
                }                
            }           
        } catch (SQLException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return repeat;
    }    
    
        
    public boolean phone_repeat(String phone){
        boolean repeat = false;
        try {
            String query = "SELECT contactNumber FROM user";
            s = con.createStatement();
            rs = s.executeQuery(query);            
            while (rs.next()){
                if (rs.getString("contactNumber").equals(phone)){
                    repeat = true;
                    break;
                }                
            }           
        } catch (SQLException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return repeat;
    }    
    
    
}