package myjava.concept.vendingmachine.vendingUser;

import java.util.Map;

import myjava.concept.vendingmachine.Currency;
import myjava.concept.vendingmachine.Item;

public interface UserVendingService
{
    public void buyItem(Item item, int quantity);
    
    public int checkout();
    
    public Map<Currency, Integer> payBill(Map<Currency, Integer> currenciesInserted);
}
