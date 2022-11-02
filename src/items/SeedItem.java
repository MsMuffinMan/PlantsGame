package items;

import enums.Quality;
import enums.Rarity;
import factories.PlantFactory;
import items.NormalItem;
import models.ItemModel;
import src.Plant;
import src.Plantable;

public class SeedItem extends NormalItem implements Plantable {

    public SeedItem(ItemModel itemModel, Rarity rarity, Quality quality){
        super(itemModel, rarity, quality);
    }

    public Plant plant(){
        //Create a plant object based on the quality of the seed
        return PlantFactory.createPlantFromSeed(itemModel.index(), quality);
    }


}