package Level;
import java.util.HashMap;
import java.util.Map;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import GameObject.GameObject;
import Screens.InventoryScreen;

import java.awt.Color;


public class Inventory  {

    //Metho to hold items and quantities
    private static Map<String, Integer> inventory = new HashMap<>();
    protected int quantity = 0;
    
    // InventoryScreen inventoryScreen = new InventoryScreen();

    public static void addItem(String itemName, int quantity){
        quantity = 0;
        inventory.put(itemName, inventory.getOrDefault(itemName,0)+ quantity);
        quantity += 1;
        //Prints the inventory items to the terminal
        System.out.print(itemName +  "" + quantity+ " ");
    }

public static void isInInventory(){
    if(inventory.isEmpty()){
        System.out.println("Inventory Empty");
    }   else{

        for(Map.Entry<String, Integer> entry : inventory.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
       // System.out.println(inventory.get(itemName, quantity);

    }
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

    
    public void showInventory() {
        // .drawFilledRectangle(100, 0, 400, 100, Color.white);
        // inventoryScreen.showInventoryScreen();
     //showInventory(inventoryScreen);
    }
}
