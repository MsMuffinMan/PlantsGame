package src;

import enums.ItemTypes;
import enums.Quality;
import factories.ItemFactory;
import items.NormalItem;
import items.PlantItem;
import items.SeedItem;
import models.PlantModel;

public class Plant implements Growable{

    private final PlantModel plantModel;
    public int growthStage;
    public int growthMultiplier;
    private final int maxGrowthStage;
    private boolean isFullyGrown;
    protected Quality quality;

    public Plant(PlantModel plantModel, Quality quality){
        this.plantModel = plantModel;
        this.growthMultiplier = calcGrowthMultiplier(quality);
        this.growthStage = 0;
        this.maxGrowthStage = calcMaxGrowthStage(quality);
        this.isFullyGrown = false;
        this.quality = quality;

    }

    public void grow(){
        if(!isFullyGrown){
            growthStage++;
            if(growthStage == maxGrowthStage){
                isFullyGrown = true;
            }
        }
    }

    public NormalItem[] harvest(){
        // return an item of the plant and a seed based on the quality of the plant
        //items.SeedItem harvestedSeed = factories.ItemFactory.createSeedItem(plantModel.index(), quality);
        //items.PlantItem harvestedPlant = factories.ItemFactory.createPlantItem(plantModel.index(), quality);
        SeedItem harvestedSeed = (SeedItem) ItemFactory.createItem(plantModel.index(), quality, ItemTypes.SEED);
        PlantItem harvestedPlant = (PlantItem) ItemFactory.createItem(plantModel.index(), quality, ItemTypes.PLANT);

        return new NormalItem[]{harvestedSeed, harvestedPlant};
    }

    public int calcGrowthMultiplier(Quality quality){
        int multiplier = -1;
        switch (quality){
            case POOR -> multiplier = 1;
            case NORMAL -> multiplier = 2;
            case GOOD -> multiplier = 3;
            case PERFECT ->  multiplier = 5;
        }
        return multiplier;
    }

    public int calcMaxGrowthStage(Quality quality){
        int maxStage = -1;
        switch (quality){
            case POOR -> maxStage = 7;
            case NORMAL -> maxStage = 5;
            case GOOD -> maxStage = 4;
            case PERFECT ->  maxStage = 3;
        }
        return maxStage;
    }

}
