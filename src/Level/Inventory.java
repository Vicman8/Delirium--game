package Level;
import java.util.HashMap;
import java.util.Map;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import GameObject.GameObject;

import java.awt.Color;


public class Inventory extends GamePanel {

    //Metho to hold items and quantities
    private static Map<String, Integer> inventory = new HashMap<>();

    public static void addItem(String itemName, int quantity){
        inventory.put(itemName, inventory.getOrDefault(itemName,0)+ quantity);
        //Prints the inventory items to the terminal
        System.out.print(itemName +  "" + quantity+ " ");
    }

    //Method to remove an item from the inventory
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

    
    public static void showInventory() {
        // .drawFilledRectangle(100, 0, 400, 100, Color.white);
        
    }
}
