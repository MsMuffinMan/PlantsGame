package items;

import enums.ItemTypes;
import models.ItemModel;

public abstract class Item {
    protected ItemModel itemModel;

    public ItemTypes getItemType(){
        return itemModel.type();
    }

}
