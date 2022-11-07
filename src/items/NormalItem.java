package items;

import enums.Quality;
import enums.Rarity;
import factories.Database;
import models.ItemModel;

import java.util.Objects;

public class NormalItem extends Item {
    protected Rarity rarity;
    protected Quality quality;

    public NormalItem(ItemModel itemModel, Rarity rarity, Quality quality, int stackSize){
        this.itemModel = itemModel;
        this.rarity = rarity;
        this.quality = quality;
        this.amount = stackSize;
    }

    public NormalItem(){
        this.itemModel = Database.itemModelMap.get(0); // Index 0 for error objects
        this.rarity = Rarity.COMMON ;
        this.quality = Quality.NORMAL;
    }

    public void setRarity(Rarity rarity){
        this.rarity = rarity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalItem that = (NormalItem) o;
        return rarity == that.rarity && quality == that.quality && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rarity, quality, type);
    }

    @Override
    public String toString() {
        String item = itemModel.name()
                .concat(" ")
                .concat(rarity.toString());
                //.concat("-")
                //.concat(quality.toString());
        return item;
    }
}
