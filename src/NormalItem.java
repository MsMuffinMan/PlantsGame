public class NormalItem {
    ItemModel itemModel;
    protected Rarity rarity;
    protected Quality quality;

    public NormalItem(ItemModel itemModel, Rarity rarity, Quality quality){
        this.itemModel = itemModel;
        this.rarity = rarity;
        this.quality = quality;
    }

    public NormalItem(){
        this.itemModel = PlantDatabase.itemModelMap.get(0); // Index 0 for error objects
        this.rarity = Rarity.COMMON ;
        this.quality = Quality.NORMAL;
    }

}
