package src;

import enums.ItemTypes;
import inventories.Inventory;
import items.NormalItem;
import items.SeedItem;

import java.math.BigDecimal;

public class Player implements PlayerActions {
    private String name;
    private BigDecimal savings;
    private final Inventory playerInventory = new Inventory(ItemTypes.values());

    public Player(){
        name = "Test";
        savings = new BigDecimal("100");
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public void move() {

    }

    public void pickUpItem(NormalItem groundItem) {
        playerInventory.addItem(groundItem);
    }

    public void dropItem(NormalItem itemToDrop) {
        playerInventory.removeItem(itemToDrop);
    }

    public void plantSeed(SeedItem seed) {

    }

    public void harvestPlant(Plant plant) {

    }
}
