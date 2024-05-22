
package Database;

import static Database.Order_db.c;
import static Database.User_db.pst;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import talabat_clone.Restaurant;
import talabat_clone.User;


public class Restaurant_db {
    
     static Connection c;
    static PreparedStatement pst;

    public Restaurant_db() {
        
    }
    
     public ArrayList<Restaurant> display_rest() {
         c = connection.con();

        ArrayList<Restaurant> restList = new ArrayList<>();

        try {
            pst = (PreparedStatement) c.prepareStatement("select * from Restaurant ");

            ResultSet r = pst.executeQuery();
            while (r.next()) {
                restList.add(new Restaurant(r.getString("name")));
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
        
        

        return restList;

    }

   
    
    
    
}
