package myjava.concept.vendingmachine.vendingAdmin;

import java.util.Map;

import myjava.concept.vendingmachine.Currency;
import myjava.concept.vendingmachine.Item;

public interface AdminService
{
    public void addItem(Item item, int quantity);
    
    public void removeItem(Item item, int quantity);
    
    public int getItemQuantity(Item item);
    
    public void addCurrency(Currency currency, int quantity);
    
    public void removeCurrency(Currency currency, int quantity);
    
    public int getAvailbleNotes(Currency currency);
    
    public int totalAvailableCashInVendingMachine();
    
    public Map<Currency, Integer> getCurrencyMap();
    
    public void updateCurrencyMap(Map<Currency, Integer> tempMap, Map<Currency, Integer> currenciesInserted);
    
    public void updateItemMap(Map<Item, Integer> buyingCart);
}
