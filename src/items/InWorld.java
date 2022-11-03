package items;

import inventories.Inventory;

//Used for things which can be picked up or dropped
public interface InWorld {

    void drop();
    void pickUp(Inventory inventoryToAddItemTo);
    void destroy();
}
