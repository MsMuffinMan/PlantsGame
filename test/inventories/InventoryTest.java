package inventories;

import enums.ItemTypes;
import enums.Quality;
import enums.Rarity;
import factories.ItemFactory;
import factories.Database;
import items.Item;
import items.NormalItem;
import org.junit.jupiter.api.*;
import src.Player;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InventoryTest {
    Player player = new Player();
    Inventory inv = player.getPlayerInventory();

    @BeforeAll
    static void setUp(){
        Database.initModels();
    }

    @Test
    void AddItemToInventory(){
        ItemTypes[] types = {ItemTypes.SEED, ItemTypes.QUEST, ItemTypes.FOOD};
        Inventory inv2 = new Inventory(types);

        NormalItem testItem = ItemFactory.createItem(ItemTypes.SEED, "Wheat", Quality.NORMAL, 1);
        ItemTypes type = testItem.getItemType();
        inv2.addItem(testItem);
        assertEquals(1, inv2.masterInventory.get(type).get(testItem));
    }

    @Test
    void addMultipleItems(){
        ItemTypes type = ItemTypes.SEED;
        for(int i = 0; i < 10; i++) {
            NormalItem testItem = ItemFactory.createItem(ItemTypes.SEED,"Wheat", Quality.NORMAL, 1);
            inv.addItem(testItem);
        }
        //System.out.println(inv.masterInventory.get(type));
        assertEquals(4, inv.masterInventory.get(type).size());
    }

    @Test
    void addOneThousandItems(){
        for(int i = 0; i < 1000; i++) {
            NormalItem testSeed = ItemFactory.createItem(ItemTypes.SEED,"Carrot", Quality.NORMAL,1);
            inv.addItem(testSeed);
            NormalItem testPlant = ItemFactory.createItem(ItemTypes.PLANT,"Carrot", Quality.NORMAL,  1);
            inv.addItem(testPlant);
            NormalItem testFood = ItemFactory.createItem(ItemTypes.FOOD,"Carrot", Quality.NORMAL, 1);
            inv.addItem(testFood);
        }
//        System.out.println(inv.masterInventory.get(ItemTypes.SEED));
//        System.out.println(inv.masterInventory.get(ItemTypes.PLANT));
//        System.out.println(inv.masterInventory.get(ItemTypes.FOOD));
    }

    @Test
    void addOneThousandItemsToList(){
        for(int i = 0; i < 1000; i++) {
            NormalItem testSeed = ItemFactory.createItem(ItemTypes.SEED,"Carrot", Quality.NORMAL,1);
            inv.addItem2(testSeed);
            NormalItem testPlant = ItemFactory.createItem(ItemTypes.PLANT,"Carrot", Quality.NORMAL,  1);
            inv.addItem2(testPlant);
            NormalItem testFood = ItemFactory.createItem(ItemTypes.FOOD,"Carrot", Quality.NORMAL, 1);
            inv.addItem2(testFood);
        }

        for(ItemTypes type : inv.masterInventory2.keySet()){
            System.out.println(type);
            for(NormalItem items : inv.masterInventory2.get(type)){
                System.out.println(items + " - " + items.getAmount());
            }
        }
    }

    @Test
    void retrieveItemFromInventory(){
        NormalItem carrotSeed = ItemFactory.createItem(ItemTypes.SEED, "Carrot", Quality.NORMAL, 1);
        carrotSeed.setRarity(Rarity.COMMON);
        int amountInInventory = inv.masterInventory.get(ItemTypes.SEED).get(carrotSeed);
        System.out.println(amountInInventory);;
    }

    @Test
    void retrieveItemFromListInventory(){
        NormalItem carrotSeed = ItemFactory.createItem(ItemTypes.SEED, "Carrot", Quality.NORMAL, 1);
        carrotSeed.setRarity(Rarity.COMMON);
        int indexOfItem = inv.masterInventory2.get(ItemTypes.SEED).indexOf(carrotSeed);
        int amount = inv.masterInventory2.get(ItemTypes.SEED).get(indexOfItem).getAmount();
        System.out.println(amount);
    }

}