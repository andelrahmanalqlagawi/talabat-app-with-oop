package talabat_clone;

import Database.Meal_db.*;
import Database.Restaurant_db;
import java.util.ArrayList;

public class Restaurant {

    private String name;
    

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
        
    }

    public void Display_rest() {
        Restaurant_db r = new Restaurant_db();
        ArrayList<Restaurant> list = r.display_rest();
       

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}
