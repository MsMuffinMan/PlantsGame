package inventories;

import enums.ItemTypes;
import items.Item;
import items.NormalItem;
import items.SpecialItem;

import java.util.HashMap;

public class Inventory implements InventoryManager {
    public final HashMap<ItemTypes, HashMap<NormalItem, Integer>> masterInventory = new HashMap<>();
    public Inventory(){}

    public Inventory(ItemTypes[] types){
        for(ItemTypes type:types){
            masterInventory.putIfAbsent(type, new HashMap<>());
        }
    }

    public void addType(ItemTypes type){
        masterInventory.putIfAbsent(type, new HashMap<>());
    }

    public void addItem(ItemTypes type, NormalItem item){
        int currentAmount = masterInventory.get(type).get(item) != null ? masterInventory.get(type).get(item) : 0;
        masterInventory.get(type).put(item, currentAmount + 1);
    }

}
