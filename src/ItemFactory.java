public abstract class ItemFactory {
    private static SeedItem createSeedItem(int index, Quality quality){
        int seedIndex = index + 1; // Seed versions of the plant item will always immediately follow plant item
        ItemModel templateSeed = PlantDatabase.itemModelMap.get(seedIndex);
        return new SeedItem(templateSeed, Rarity.rollForRarity(quality), quality);
    }

    private static PlantItem createPlantItem(int index, Quality quality){
        ItemModel templatePlant = PlantDatabase.itemModelMap.get(index);
        return new PlantItem(templatePlant, Rarity.rollForRarity(quality), quality);
    }

    private static NormalItem createDummyItem(){
        return new NormalItem();
    }

    public static NormalItem createItem(int index, Quality quality, ItemTypes type){
        switch(type){
            case SEED: return createSeedItem(index, quality);
            case PLANT: return createPlantItem(index, quality);
            default: return createDummyItem();
        }
    }
}
