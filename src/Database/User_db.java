package Database;

import static Database.Order_db.c;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import talabat_clone.Owner;
import talabat_clone.User;

public class User_db {

    static Connection c;
    static PreparedStatement pst;
    static PreparedStatement pst1;

    public User_db() {
        
    }

    public void insert_data(String username, String password, String address, String mobile, boolean type, String rest_name) {
        try {     
            c = connection.con();
            pst = (PreparedStatement) c.prepareStatement("insert into User values (?,?,?,?,?,?) ");
            pst1 = c.prepareStatement("insert into Restaurant values (?)");

            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, address);
            pst.setString(4, mobile);
            pst.setBoolean(5, type);

            //forgin key
            pst1.setString(1, rest_name);

            pst.setString(6, rest_name);
            
            pst.execute();
            pst1.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         finally{
        try{
            c.close();
            pst.close();
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        }
        
        

    }
    
    public void insert_data2(String username, String password, String address, String mobile, boolean type) {
        try {     
            c = connection.con();
            pst = (PreparedStatement) c.prepareStatement("insert into User (user_name,password,address,mobile,type) values(?,?,?,?,?) ");
            

            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, address);
            pst.setString(4, mobile);
            pst.setBoolean(5, type);

            
            
            pst.execute();
           

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         finally{
        try{
            c.close();
            pst.close();
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        }
        
        

    }
    
    
    
    
    
    
    
    
    

    public ArrayList<Owner> display_data() {
        c = connection.con();

        ArrayList<Owner> userList = new ArrayList<>();

        try {
            // Connection c= connection.con();
            pst = (PreparedStatement) c.prepareStatement("select * from User ");

            ResultSet r = pst.executeQuery();
            while (r.next()) {
                userList.add(new Owner(r.getString("user_name"), r.getString("password"), r.getString("address"), r.getString("mobile"), r.getBoolean("type"), r.getString("rest_name")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
         finally{
        try{
            c.close();
            pst.close();
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        }
        
        

        return userList;

    }
    
    
    
    
    
   /* public String getRestaurant (String username)
    {
        
         c = connection.con();

       String x = null;

        try {
           
            pst = (PreparedStatement) c.prepareStatement("select rest_name from User where user_name=? ");
            
            pst.setString(1, username);

            ResultSet r = pst.executeQuery();
           
               x=r.getString("user_name");
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
         finally{
        try{
            c.close();
            pst.close();
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        }
        
        return x;
        
    }
*/
}
