package items;

import enums.ItemTypes;
import enums.Quality;
import enums.Rarity;
import models.FoodModel;
import models.ItemModel;

public class FoodItem extends NormalItem implements Edible{
    private final FoodModel foodModel;

    public FoodItem(ItemModel itemModel, FoodModel foodmodel, Quality quality, int stackSize){
        super(itemModel, Rarity.COMMON, quality, stackSize);
        this.foodModel = foodmodel;
        type = ItemTypes.FOOD;
    }

    public void eat(){

    }
}
