package Database;

import static Database.Restaurant_db.pst;
import static Database.User_db.pst;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import talabat_clone.Meal;
import talabat_clone.Restaurant;

public class Meal_db {

    static Connection c;
    static PreparedStatement pst;

    public Meal_db() {
        
       
    }
    
    

    public void insert_data(String mealName, int mealPrice, String mealDescription, String username_owner, String rest_name) {
        try {   
             c = connection.con();
            pst = (PreparedStatement) c.prepareStatement("insert into Meal values (?,?,?,?,?) ");

            pst.setString(1, mealName);
            pst.setInt(2, mealPrice);
            pst.setString(3, mealDescription);
            pst.setString(4, username_owner);
            pst.setString(5, rest_name);

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
    
   
    

    public void edit_data(String mealName, int mealPrice, String mealDescription, String check_name) {
        try {   
             c = connection.con();
            pst = (PreparedStatement) c.prepareStatement("update Meal set  name=? , price=? ,description=?  where name=? ");

            pst.setString(1, mealName);
            pst.setInt(2, mealPrice);
            pst.setString(3, mealDescription);

            pst.setString(4, check_name);

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

    public void remove_data(String check_name) {
        try {     
             c = connection.con();
            pst = (PreparedStatement) c.prepareStatement("delete from Meal where name=? ");

            pst.setString(1, check_name);

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
    
     
    

    public ArrayList<Meal> display_meals() {
         c = connection.con();

        ArrayList<Meal> mealList = new ArrayList<>();

        try {
            pst = (PreparedStatement) c.prepareStatement("select * from Meal ");

            ResultSet r = pst.executeQuery();
            while (r.next()) {
                mealList.add(new Meal(r.getString("name"), r.getInt("price"), r.getString("description"),r.getString("rest_name")));
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
        
        
        return mealList;
    }
    
    
    
    
    public ArrayList<String> disMeal(String rest_name) {
         c = connection.con();

        ArrayList<String> mealList = new ArrayList<>();

        try {
            pst = (PreparedStatement) c.prepareStatement("select name from Meal where rest_name=? ");

            pst.setString(1, rest_name);
            
            ResultSet r = pst.executeQuery();
            
            while (r.next()) {
                mealList.add(r.getString("name"));
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
        
        
        return mealList;
    }
    
    
    
    public ArrayList<Meal> display_mealsss(String rest_name) {
         c = connection.con();

        ArrayList<Meal> mealList = new ArrayList<>();

        try {
            pst = (PreparedStatement) c.prepareStatement("select name , price ,description  from Meal where rest_name =? ");

            pst.setString(1, rest_name);
            
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                mealList.add(new Meal(r.getString("name"), r.getInt("price"), r.getString("description")));
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
        
        
        return mealList;
    }
    
    public  void refresh_table(String rest_name, JTable table )
     {
         c = connection.con();
          try {
            pst = (PreparedStatement) c.prepareStatement("select name , price ,description  from Meal where rest_name =?  ");
            pst.setString(1, rest_name);
            ResultSet r = pst.executeQuery();
           
          table.setModel( DbUtils.resultSetToTableModel(r));

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
    
    
    
    
    
    

}
