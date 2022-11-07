package inventories;

import enums.ItemTypes;
import items.NormalItem;

public interface InventoryManager {

    void addType(ItemTypes type);
    void addItem(NormalItem item);

    void removeItem(NormalItem item);
    void removeItemByStacksize(NormalItem item, int numberToRemove);

}
