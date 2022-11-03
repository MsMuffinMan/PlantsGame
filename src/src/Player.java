package src;

import enums.ItemTypes;
import inventories.Inventory;
import inventories.PlayerInventory;
import items.NormalItem;
import items.SeedItem;

import java.math.BigDecimal;

public class Player implements PlayerActions {
    private String name;
    private BigDecimal savings;
    private final Inventory playerInventory = new Inventory(ItemTypes.values());

    public Player(){
        name = "Test";
        savings = BigDecimal.valueOf(100L);
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public void move() {

    }

    public void pickUpItem(NormalItem groundItem) {
        groundItem.pickUp(playerInventory);
    }

    public void dropItem(NormalItem itemToDrop) {

    }

    public void plantSeed(SeedItem seed) {

    }

    public void harvestPlant(Plant plant) {

    }
}
