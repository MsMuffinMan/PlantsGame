package inventories;

import enums.ItemTypes;
import items.Item;
import items.NormalItem;
import items.SpecialItem;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements InventoryManager {
    public final HashMap<ItemTypes, HashMap<NormalItem, Integer>> masterInventory = new HashMap<>();
    public final HashMap<ItemTypes, ArrayList<NormalItem>> masterInventory2 = new HashMap<>(); // add amount variable to items
    public Inventory(){}

    public Inventory(ItemTypes[] types){
        for(ItemTypes type:types){
            masterInventory.putIfAbsent(type, new HashMap<>());
        }
    }

    public void addType(ItemTypes type){
        masterInventory.putIfAbsent(type, new HashMap<>());
    }
    public void addItem(NormalItem item){
        ItemTypes type = item.getItemType();
        int stackSize = item.getAmount();
        int currentAmount = masterInventory.get(type).get(item) != null ? masterInventory.get(type).get(item) : 0;
        masterInventory.get(type).put(item, currentAmount + stackSize);
    }

}
