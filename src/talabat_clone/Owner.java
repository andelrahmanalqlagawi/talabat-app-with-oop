package talabat_clone;

import Database.Meal_db;
import Database.User_db;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Owner extends User {

    Meal_db m;
    private String rest_name;
    
    
    
    public Owner (){}
    
    public Owner(String user_name, String password ,String address, String mobile,boolean type, String rest_name)
    {
        super(user_name ,password,address,mobile,type);
        this.rest_name=rest_name;
    }

    public String getRest_name() {
        return rest_name;
    }
    
    
    
    @Override
    public void register(String username, String password, String address, String mobile, boolean type, String rest_name) {
        User_db user = new User_db();

        user.insert_data(username, password, address, mobile, type, rest_name);

    }
    
    
    
   /* public int login(String username, String password) {
        //if x=2 correct username and password 
        //if x=1 correct username and incorrect password 
        //if x=0 incorrect both 

        User_db u = new User_db();
        ArrayList<Owner> user = u.display_data();
        int x = 0;

        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getUsername().equalsIgnoreCase(username)) {
                if (user.get(i).getPassword().equalsIgnoreCase(password) && user.get(i).isType()==true) {

                    x = 2;

                    break;
                } else {

                    x = 1;
                    break;

                }
            } else {

                x = 0;

            }
        }
        return x;
    }*/
    
    

    public void addMeal(String name, int price, String description,String username_owner,String rest_name) {
        
        m =new Meal_db();
        
        m.insert_data(name ,price ,description , username_owner ,rest_name);
        
    }

    public void EditMeal( String name , int price , String description ,String name_edit) {
        m =new Meal_db();
        m.edit_data(name, price, description, name_edit);
        
    }

    
    public void DeleteMeal(String name_remove)
    {
        m=new Meal_db();
        m.remove_data(name_remove);
    }
    
    
    public String getRest_name2(String username)
    {
        User_db user =new User_db();
        ArrayList<Owner> list =user.display_data();
        String x = null;
        for(int i=0 ;i<list.size();i++)
        {
            if(list.get(i).getUsername().equals(username)){
                x=list.get(i).rest_name;
               
            }
        }
        
       return x;
        
    }
    
    
}
    
    
    
    
 