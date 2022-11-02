package items;

import enums.ItemTypes;
import enums.Quality;
import enums.Rarity;
import factories.ItemFactory;
import models.ItemModel;

public class PlantItem extends NormalItem {

    public PlantItem(ItemModel itemModel, Rarity rarity, Quality quality){
        super(itemModel, rarity, quality);
    }

    public SeedItem convertToSeed(){
        return (SeedItem) ItemFactory.createItem(itemModel.index(), quality, ItemTypes.SEED);
    }

}
