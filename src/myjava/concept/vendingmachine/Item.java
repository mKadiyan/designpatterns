package myjava.concept.vendingmachine;

/**
 * 
 * Can be made as class if items are unlimited
 *
 */
public enum Item
{
    ITEM_1(15), ITEM_2(10), ITEM_3(20), ITEM_4(25);
    
    private final int price;
    
    private Item(int price)
    {
        this.price = price;
    }
    
    public int getPrice()
    {
        return price;
    }
}
