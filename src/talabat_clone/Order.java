package talabat_clone;

import Database.Meal_db;
import Database.Order_db;
import java.sql.Date;
import java.util.ArrayList;

public class Order {

    private int id;
    private String notes;
    private String date;
    private int quantity;
    private int price;

    private String meal_name;
    private String rest_name;

    
    public Order() {
    }

    

    public Order(int id, String notes, String date, int quantity, int price, String meal_name ,String rest_name) {
        this.id = id;
        this.notes = notes;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.meal_name = meal_name;
        this.rest_name=rest_name;
    }

    public void calc_price() {
        Order_db order = new Order_db();
        ArrayList<Order> orderList = order.display_order();

        Meal_db meal = new Meal_db();
        ArrayList<Meal> mealList = meal.display_meals();

        for (int i = 0; i < orderList.size(); i++) {
            for (int j = 0; j < mealList.size(); j++) {
                if (orderList.get(i).meal_name.equals(mealList.get(j).getName())) {
                    //mealList.get(j).getPrice()*orderList.get(i).quantity;
                    order.insert_price(mealList.get(j).getPrice() * orderList.get(i).quantity, orderList.get(i).id);
                    

                }
            }
        }

    }
    
    
    

    public int getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public String getRest_name() {
        return rest_name;
    }
}
