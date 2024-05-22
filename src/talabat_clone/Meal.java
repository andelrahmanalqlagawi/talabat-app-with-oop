
package talabat_clone;
import Database.Meal_db;
import java.util.ArrayList;

public class Meal {

    private String name ;
    private int price ;
    private String description ;
    String rest_name;

    
    public Meal (){}
    
    public Meal(String name, int price, String description,String rest_name) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.rest_name= rest_name;
    }
    
     public Meal(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        
    }
    
    public void Display_meals (){
    
        Meal_db m =new Meal_db();
        ArrayList<Meal> list =m.display_meals();
        
        for(int i =0 ;i<list.size();i++)
        {
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getPrice());
            System.out.println(list.get(i).getDescription());
            
        }
    
        
    }
    
    
/*   
public ArrayList<String> listOfMeals (String restaurant)
{
    Meal_db meal =new Meal_db();
    ArrayList<Meal> list =meal.display_meals();
    
    ArrayList<String> List =new ArrayList<>();
    for(int i=0 ;i<list.size();i++)
    {
        if(list.get(i).rest_name ==restaurant )
        {
          List.add(i, list.get(i).name );
        }
       
    }
    
    
 return List;
}*/
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
   
    
}
