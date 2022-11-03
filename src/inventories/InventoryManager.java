package inventories;

import enums.ItemTypes;
import items.NormalItem;

import java.util.HashMap;

public interface InventoryManager {

    void addType(ItemTypes type);
    void addItem(ItemTypes type, NormalItem item);
}
