package inventories;

import enums.ItemTypes;
import items.NormalItem;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements InventoryManager {
    public final HashMap<ItemTypes, HashMap<NormalItem, Integer>> masterInventory = new HashMap<>();
    public final HashMap<ItemTypes, ArrayList<NormalItem>> masterInventory2 = new HashMap<>(); // add amount variable to items
    public Inventory(){}

    public Inventory(ItemTypes[] types){
        for(ItemTypes type:types){
            masterInventory.putIfAbsent(type, new HashMap<>());
            masterInventory2.putIfAbsent(type, new ArrayList<NormalItem>());
        }
    }

    public void addType(ItemTypes type){
        masterInventory.putIfAbsent(type, new HashMap<>());
    }
    public void addItem(NormalItem item){
        ItemTypes type = item.getItemType();
        if(masterInventory.get(type).containsKey(item)){
            int currentAmount = masterInventory.get(type).get(item);
            masterInventory.get(type).replace(item, currentAmount + item.getAmount());
        } else {
            masterInventory.get(type).put(item, item.getAmount());
        }
    }

    public void addItem2(NormalItem item){
        ItemTypes type = item.getItemType();
        int indexOfItem;
        int currentAmount = 0;
        if(masterInventory2.get(type).contains(item)){
            indexOfItem = masterInventory2.get(type).indexOf(item);
            currentAmount = masterInventory2.get(type).get(indexOfItem).getAmount();
        } else {
            masterInventory2.get(type).add(item);
            indexOfItem = masterInventory2.get(type).indexOf(item);
        }
        int newAmount = currentAmount + item.getAmount();
        masterInventory2.get(type).get(indexOfItem).setAmount(newAmount);
    }

}
