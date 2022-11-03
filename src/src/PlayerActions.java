package src;

import items.NormalItem;
import items.SeedItem;

public interface PlayerActions {

    void move();
    void pickUpItem(NormalItem groundItem);
    void dropItem(NormalItem itemToDrop);
    void plantSeed(SeedItem seed);
    void harvestPlant(Plant plant);
}
