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
    private static SeedItem createSeedItem(String name, Quality quality, int stackSize){
        String seedName = name.concat(" Seed"); // Seed versions of the plant item will always immediately follow plant item
        ItemModel templateSeed = Database.itemModelMap.getOrDefault(seedName, Database.itemModelMap.get("Dummy Item"));
        return new SeedItem(templateSeed, Rarity.rollForRarity(quality), quality, stackSize);
    }

    private static PlantItem createPlantItem(String name, Quality quality, int stackSize){
        ItemModel templatePlant = Database.itemModelMap.getOrDefault(name, Database.itemModelMap.get("Dummy Item"));
        return new PlantItem(templatePlant, Rarity.rollForRarity(quality), quality, stackSize);
    }

    private static FoodItem createFoodItem(String name, Quality quality, int stackSize) {
        ItemModel templateItem = Database.itemModelMap.getOrDefault(name, Database.itemModelMap.get("Dummy Item"));
        FoodModel templateFood = Database.foodModelMap.getOrDefault(name, Database.foodModelMap.get("Dummy Food"));
        return new FoodItem(templateItem, templateFood, quality, stackSize);
    }
    private static NormalItem createDummyItem(){
        return new NormalItem();
    }

    public static NormalItem createItem(ItemTypes type, String name, Quality quality, int stackSize){
        switch(type){
            case SEED: return createSeedItem(name, quality, stackSize);
            case PLANT: return createPlantItem(name, quality, stackSize);
            case FOOD: return createFoodItem(name, quality, stackSize);
            default: return createDummyItem();
        }
    }


}
