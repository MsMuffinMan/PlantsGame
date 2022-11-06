package factories;

import enums.ItemTypes;
import enums.Quality;
import enums.Rarity;
import items.FoodItem;
import items.NormalItem;
import items.PlantItem;
import items.SeedItem;
import models.FoodModel;
import models.ItemModel;


public abstract class ItemFactory {
    private static SeedItem createSeedItem(int index, Quality quality, int stackSize){
        int seedIndex = index + 1; // Seed versions of the plant item will always immediately follow plant item
        ItemModel templateSeed = PlantDatabase.itemModelMap.get(seedIndex);
        return new SeedItem(templateSeed, Rarity.rollForRarity(quality), quality, stackSize);
    }

    private static PlantItem createPlantItem(int index, Quality quality, int stackSize){
        ItemModel templatePlant = PlantDatabase.itemModelMap.get(index);
        return new PlantItem(templatePlant, Rarity.rollForRarity(quality), quality, stackSize);
    }

    private static FoodItem createFoodItem(int index, Quality quality, int stackSize) {
        ItemModel templateItem = PlantDatabase.itemModelMap.get(index);
        String name = templateItem.name();
        FoodModel dummyFood = PlantDatabase.foodModelMap.get("Dummy Food");
        FoodModel templateFood = PlantDatabase.foodModelMap.getOrDefault(name, dummyFood);
        return new FoodItem(templateItem, templateFood, quality, stackSize);
    }
    private static NormalItem createDummyItem(){
        return new NormalItem();
    }

    public static NormalItem createItem(int index, Quality quality, ItemTypes type, int stackSize){
        switch(type){
            case SEED: return createSeedItem(index, quality, stackSize);
            case PLANT: return createPlantItem(index, quality, stackSize);
            case FOOD: return createFoodItem(index, quality, stackSize);
            default: return createDummyItem();
        }
    }


}
