package inventories;

import enums.ItemTypes;
import enums.Quality;
import factories.ItemFactory;
import factories.PlantDatabase;
import items.NormalItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import src.Player;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @BeforeAll
    static void setUp(){
        PlantDatabase.initModels();
    }

    @Test
    void AddItemToInventory(){
        ItemTypes[] types = {ItemTypes.SEED, ItemTypes.QUEST, ItemTypes.FOOD};
        Inventory inv = new Inventory(types);

        NormalItem testItem = ItemFactory.createItem(1, Quality.NORMAL,ItemTypes.SEED);
        ItemTypes type = testItem.getItemType();
        testItem.pickUp(inv);
        //System.out.println(testItem);
        assertEquals(1, inv.masterInventory.get(type).get(testItem));
    }

    @Test
    void addMultipleItems(){
        Player player = new Player();
        Inventory inv = player.getPlayerInventory();
        ItemTypes type = ItemTypes.SEED;
        for(int i = 0; i < 10; i++) {
            NormalItem testItem = ItemFactory.createItem(1, Quality.NORMAL, ItemTypes.SEED);
            testItem.pickUp(inv);
        }
        //System.out.println(inv.masterInventory.get(type));
        assertEquals(4, inv.masterInventory.get(type).size());
    }

}