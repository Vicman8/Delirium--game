package Level;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
    //Metho to hold items and quantities
    private static Map<String, Integer> inventory = new HashMap<>();

    public static void addItem(String itemName, int quantity){
        inventory.put(itemName, inventory.getOrDefault(itemName,0)+ quantity);


    }

    public static void removeItem(String itemName, int quantity){
        if(inventory.containsKey(itemName)){
            int currentQuantity = inventory.get(itemName);
            if(currentQuantity <= quantity){
                inventory.remove(itemName);
            } else{
                inventory.put(itemName, currentQuantity-quantity);
            }
            
        }
        else{
            System.out.println("Item not in inventory");
        }
    }
    public static int getItemQuantity(String itemName){
        return inventory.getOrDefault(itemName, 0);
    }
}
