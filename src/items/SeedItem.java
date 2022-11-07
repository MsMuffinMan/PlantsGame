package items;

import enums.ItemTypes;
import enums.Quality;
import enums.Rarity;
import factories.PlantFactory;
import models.ItemModel;
import src.Plant;
import src.Plantable;

public class SeedItem extends NormalItem implements Plantable {

    public SeedItem(ItemModel itemModel, Rarity rarity, Quality quality, int stackSize){
        super(itemModel, rarity, quality, stackSize);
        type = ItemTypes.SEED;
    }

    public Plant plant(){
        //Create a plant object based on the quality of the seed
        return PlantFactory.createPlantFromSeed(itemModel.name(), quality);
    }

    //a plant method should place a Plant in the world


}