package Level;

import Utils.Point;

import Engine.Key;
import Engine.Keyboard;
import GameObject.Frame;

public class InventoryItems extends MapEntity {
    public static final Key INTERACT_KEY = Key.E;
    private static final int MAX_ITEMS = 4;
    private static InventoryItems[] inventory = new InventoryItems[MAX_ITEMS];
    private Frame frame;
    private NPC npc;

    public InventoryItems(Point location, Frame frame, NPC npc) {
        super(location.x, location.y, frame);
        this.frame = frame;
        this.npc = npc;
        addToInventory(this);
    }

    public Item convertItem(Frame frame) {
        return new Item(this.frame);
    }

    public void update(Player player) {
        double distance = Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));

        if (distance <= 50 && Keyboard.isKeyDown(INTERACT_KEY)) {
            System.out.println("test");
            this.setMapEntityStatus(MapEntityStatus.REMOVED);
        }
        super.update();
    }

    public static void addToInventory(InventoryItems item) {
        for (int i = 0; i < MAX_ITEMS; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                System.out.println("Added item to inventory at position: " + i);
                if (i < MAX_ITEMS - 1) {
                }
                printInventory();
                break;
            }
        }
    }

    public static void printInventory() {
        System.out.println("Current Inventory:");
        for (int i = 0; i < MAX_ITEMS; i++) {
            if (inventory[i] != null) {
                System.out.println("Position " + i + ": " + inventory[i]);
            } else {
                System.out.println("Position " + i + ": empty");
            }
        }
    }

    public static InventoryItems fromNPC(NPC npc) {
        Point location = new Point(npc.getX(), npc.getY());
        Frame frame = npc.getCurrentFrame();
        System.out.println("Creating InventoryItems from NPC with ID: " + npc.getId());
        return new InventoryItems(location, frame, npc);
    }

    @Override
    public String toString() {
        return "InventoryItems{" +
                "location=(" + x + ", " + y + ")" +
                ", npcId=" + npc.getId() +
                '}';
    }
}
