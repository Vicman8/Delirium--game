// package Level;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// import Engine.GamePanel;
// import Engine.GraphicsHandler;
// import Engine.Key;
// import Engine.Keyboard;
// import GameObject.GameObject;

// import java.awt.Color;


// public class Inventory {

//     public boolean working = true;

//     // Array to store inventory items (size 12)
//     private static final int MAX_ITEMS = 12;
//     private static Item[] inventory = new Item[MAX_ITEMS];

//     // Nested class to represent an item with name and quantity
//     private static class Item {
//         String name;
//         int quantity;

//         Item(String name, int quantity) {
//             this.name = name;
//             this.quantity = quantity;
//         }

//         @Override
//         public String toString() {
//             return name + ": " + quantity;
//         }
//     }

//     // Method to check if the inventory has items
//     public void Exists() {
//         boolean hasItems = false;
//         for (Item item : inventory) {
//             if (item != null) {
//                 hasItems = true;
//                 break;
//             }
//         }

//         if (hasItems) {
//             System.out.println("Inventory exists and is " + (working ? "working" : "not working"));
//         } else {
//             System.out.println("Inventory is empty.");
//         }
//     }

//     // Add an item to the inventory
//     public static void addItem(String itemName, int quantity) {
//         for (int i = 0; i < MAX_ITEMS; i++) {
//             if (inventory[i] != null && inventory[i].name.equals(itemName)) {
//                 inventory[i].quantity += quantity; // Update quantity
//                 return;
//             }
//         }

//         // Add new item if there's space
//         for (int i = 0; i < MAX_ITEMS; i++) {
//             if (inventory[i] == null) {
//                 inventory[i] = new Item(itemName, quantity);
//                 return;
//             }
//         }

//         System.out.println("Inventory is full! Cannot add more items.");
//     }

//     // Check if the inventory is empty
//     public static void isInInventory() {
//         boolean isEmpty = true;
//         for (Item item : inventory) {
//             if (item != null) {
//                 isEmpty = false;
//                 System.out.println(item);
//             }
//         }

//         if (isEmpty) {
//             System.out.println("Inventory Empty");
//         }
//     }

//     // Remove an item from the inventory
//     public static void removeItem(String itemName, int quantity) {
//         for (int i = 0; i < MAX_ITEMS; i++) {
//             if (inventory[i] != null && inventory[i].name.equals(itemName)) {
//                 if (inventory[i].quantity <= quantity) {
//                     inventory[i] = null; // Remove item completely
//                 } else {
//                     inventory[i].quantity -= quantity; // Decrease quantity
//                 }
//                 return;
//             }
//         }

//         System.out.println("Item not in inventory");
//     }

//     // Get the quantity of a specific item
//     public static int getItemQuantity(String itemName) {
//         for (Item item : inventory) {
//             if (item != null && item.name.equals(itemName)) {
//                 return item.quantity;
//             }
//         }
//         return 0; // Item not found
//     }

//     // Show inventory
//     public void showInventory() {
//         boolean isEmpty = true;
//         for (Item item : inventory) {
//             if (item != null) {
//                 System.out.println(item);
//                 isEmpty = false;
//             }
//         }

//         if (isEmpty) {
//             System.out.println("Inventory is empty.");
//         }
//     }
// }