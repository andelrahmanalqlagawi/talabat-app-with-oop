package talabat_clone;

import Database.*;
import java.sql.Date;
import java.util.ArrayList;

public class Customer extends User {

   
    
    
    
    
    
    
    public void register(String username, String password, String address, String mobile, boolean type) {
        User_db user = new User_db();

        user.insert_data2(username, password, address, mobile, type);
        
    }
    
    
   /* public int login(String username, String password) {
        //if x=3 correct username and password and type is false
        //if x=2 correct username and correct password and type is true
        //if x=1 correct username and incorrect password
        //if x=0 incorrect both

        User_db u = new User_db();
        ArrayList<Owner> user = u.display_data();
        int x = 0;

        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getUsername().equalsIgnoreCase(username)) {
                if (user.get(i).getPassword().equalsIgnoreCase(password) ) {
                    if(user.get(i).isType()==false){
                    x = 3;
                    break;
                    }
                    else{
                    x=2;
                    }
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

    public void make_order(String notes, String date, int quantity, String username_customer, String mealCheck) {
     
        //rest_naem add from Meal which i choose to order
        Order_db order =new Order_db();
        
        order.insert_data(notes, date, quantity, username_customer,mealCheck);
       
        order.insert_RestName(mealCheck);
        
        //order.insert_RestName(mealCheck);
        
        
        
        
        
        
    }

}
