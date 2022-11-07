package items;

import enums.ItemTypes;
import enums.Quality;
import enums.Rarity;
import factories.ItemFactory;
import models.ItemModel;

public class PlantItem extends NormalItem {

    public PlantItem(ItemModel itemModel, Rarity rarity, Quality quality, int stackSize){
        super(itemModel, rarity, quality, stackSize);
        type = ItemTypes.PLANT;
    }

    public SeedItem convertToSeed(){
        return (SeedItem) ItemFactory.createItem(ItemTypes.SEED, itemModel.name(), quality, 1);
    }

}
