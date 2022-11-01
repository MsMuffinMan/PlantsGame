public class PlantItem extends NormalItem{

    public PlantItem(ItemModel itemModel, Rarity rarity, Quality quality){
        super(itemModel, rarity, quality);
    }

    public SeedItem convertToSeed(){
        return (SeedItem) ItemFactory.createItem(itemModel.index(), quality, ItemTypes.SEED);
    }

}
