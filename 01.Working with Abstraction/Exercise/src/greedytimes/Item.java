package greedytimes;



public class Item {

    private final ItemType itemType;
    private final String itemName;
    private final long amount;

    public Item(ItemType itemType, String itemName, long amount) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.amount = amount;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public long getAmount() {
        return amount;
    }

}
