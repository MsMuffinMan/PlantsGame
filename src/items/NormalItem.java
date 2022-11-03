package items;

import enums.ItemTypes;
import enums.Quality;
import enums.Rarity;
import factories.PlantDatabase;
import inventories.Inventory;
import models.ItemModel;

import java.util.Objects;

public class NormalItem extends Item implements InWorld{
    protected Rarity rarity;
    protected Quality quality;

    public NormalItem(ItemModel itemModel, Rarity rarity, Quality quality){
        this.itemModel = itemModel;
        this.rarity = rarity;
        this.quality = quality;
    }

    public NormalItem(){
        this.itemModel = PlantDatabase.itemModelMap.get(0); // Index 0 for error objects
        this.rarity = Rarity.COMMON ;
        this.quality = Quality.NORMAL;
    }

    public void drop(){

    }

    public void pickUp(Inventory inventory){
        inventory.addItem(itemModel.type(), this);
    }
    public void destroy(){

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalItem that = (NormalItem) o;
        return rarity == that.rarity && quality == that.quality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rarity, quality);
    }

    @Override
    public String toString() {
        String item = itemModel.name()
                .concat(" ")
                .concat(rarity.toString())
                .concat("-")
                .concat(quality.toString());
        return item;
    }
}
