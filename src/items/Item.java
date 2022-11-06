package items;

import enums.ItemTypes;
import models.ItemModel;

public abstract class Item {
    protected ItemModel itemModel;
    protected ItemTypes type;
    protected int amount;

    public ItemTypes getItemType(){
        return type;
    }
    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
