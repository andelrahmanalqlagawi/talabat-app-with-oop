
package Database;

import static Database.Meal_db.c;
import static Database.Meal_db.pst;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import talabat_clone.Meal;
import talabat_clone.Order;


public class Order_db {
    
    
     static Connection c;
    static PreparedStatement pst;
static PreparedStatement pst1;

    public Order_db() {
        
    }

    
    public void insert_data(String notes,String date, int quantity,String username_customer,String meal_name  ) {
        try {    
            c = connection.con();
            pst = (PreparedStatement) c.prepareStatement(" insert into new (notes,date,quantity,username_customer,meal_name) values(?,?,?,?,?) ");

           
            
            pst.setString(1, notes);
            pst.setString(2, date);
            pst.setInt(3, quantity);
            pst.setString(4, username_customer);
           pst.setString(5, meal_name);
           
         
            
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
    
    
    public void insert_RestName(String meal_name) {
        try {    
            c = connection.con();
             pst = (PreparedStatement) c.prepareStatement(" UPDATE new\n" +
                                                          "SET rest_name   = (   SELECT rest_name FROM Meal  WHERE name = ?  )"
                                                        + "where meal_name=?  \n" );
            
            pst.setString(1, meal_name);
            pst.setString(2, meal_name);
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
    
    
     public void insert_price(int orderPrice,int id ) {
        try {    
            c = connection.con();
             pst = (PreparedStatement) c.prepareStatement(" UPDATE new\n" +
                                                          "SET order_price=?   "
                                                        + "where id=?  \n" );
            
            pst.setInt(1, orderPrice);
            pst.setInt(2, id);
            
            
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
    
    
    
    
    
    
    
    
     public ArrayList<Order> display_order() {
         
         c = connection.con();

        ArrayList<Order> orderList = new ArrayList<>();

        try {
            pst = (PreparedStatement) c.prepareStatement("select * from new ");

            ResultSet r = pst.executeQuery();
            while (r.next()) {
                orderList.add(new Order(r.getInt("id"),r.getString("notes"), r.getString("date") , r.getInt("quantity"),r.getInt("order_price"),r.getString("meal_name"),r.getString("rest_name")));
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
        
        return orderList;

    }
     
     
     public int displayPrice(int id ) {
         
         c = connection.con();

       int x=0;

        try {
            pst = (PreparedStatement) c.prepareStatement("select order_price from new where id=? ");

            pst.setInt(1, id);
            
            ResultSet r = pst.executeQuery();
            x= r.getInt("order_price");

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
     
     
     
     
     public ArrayList<Order> display_orders_my_order(String username_cus ) {
         
         c = connection.con();

        ArrayList<Order> orderList = new ArrayList<>();

        try {
            pst = (PreparedStatement) c.prepareStatement("select id ,notes ,date , quantity ,order_price , meal_name ,rest_name from new where username_customer=? ");

            pst.setString(1, username_cus);
            
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                orderList.add(new Order(r.getInt("id"),r.getString("notes"), r.getString("date") , r.getInt("quantity"),r.getInt("order_price"),r.getString("meal_name"),r.getString("rest_name")));
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
        
        return orderList;

    }
     
     
     
   /*  public static void refresh_table( )
     {
         c = connection.con();
          try {
            pst = (PreparedStatement) c.prepareStatement("select * from new  ");

            ResultSet r = pst.executeQuery();
           
            DbUtils.resultSetToTableModel(r);

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
     */
     
     
    
    
    
    
   
    
    
    
}
