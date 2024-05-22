package talabat_clone;

import Database.Meal_db.*;
import Database.User_db;
import java.util.ArrayList;

public abstract class User {

    private String username;
    private String password;
    private String address;
    private String mobile;
    private boolean type;
    

    //constructors
    public User() {
    }

    

    public User(String username, String password, String address, String mobile, boolean type) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.mobile = mobile;
        this.type = type;
        
    }

    //get and set methods
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public boolean isType() {
        return type;
    }



    public void register(String username, String password, String address, String mobile, boolean type, String rest_name) {
        User_db user = new User_db();

        user.insert_data(username, password, address, mobile, type, rest_name);

    }

    
    public int login(String username, String password) {
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
                    break;
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
    }
    
}
