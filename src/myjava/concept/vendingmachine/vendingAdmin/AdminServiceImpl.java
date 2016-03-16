package myjava.concept.vendingmachine.vendingAdmin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import myjava.concept.vendingmachine.Currency;
import myjava.concept.vendingmachine.Item;
import myjava.concept.vendingmachine.exception.VendingMachineException;

public class AdminServiceImpl implements AdminService
{
    private Map<Item, Integer> itemMap = new HashMap<>();
    
    private Map<Currency, Integer> currencyMap = new TreeMap<>(new Comparator<Currency>()
    {
        @Override
        public int compare(Currency o1, Currency o2)
        {
            if (o1.getValue() > o2.getValue())
                return -1;
            if (o1.getValue() < o2.getValue())
                return 1;
            return 0;
        }
    });
    
    private int totalValue = 0;
    
    @Override
    public void addItem(Item item, int quantity)
    {
        validateQuantity(quantity);
        Integer availableQuantity = itemMap.get(item);
        if (availableQuantity == null)
            availableQuantity = new Integer(0);
        availableQuantity = availableQuantity + quantity;
        itemMap.put(item, availableQuantity);
    }
    
    private void validateQuantity(int quantity)
    {
        if (quantity < 0)
            throw new VendingMachineException("Invalid Quantity");
    }
    
    @Override
    public void removeItem(Item item, int quantity)
    {
        validateQuantity(quantity);
        Integer availableQuantity = itemMap.get(item);
        if (availableQuantity == null || availableQuantity < quantity)
            throw new VendingMachineException("Invalid Quantity");
        availableQuantity = availableQuantity + quantity;
        itemMap.put(item, availableQuantity);
    }
    
    @Override
    public void addCurrency(Currency currency, int quantity)
    {
        validateQuantity(quantity);
        Integer availableNotes = currencyMap.get(currency);
        if (availableNotes == null)
            availableNotes = new Integer(0);
        
        availableNotes = availableNotes + quantity;
        totalValue += quantity * currency.getValue();
        currencyMap.put(currency, availableNotes);
    }
    
    @Override
    public void removeCurrency(Currency currency, int quantity)
    {
        validateQuantity(quantity);
        Integer availableNotes = currencyMap.get(currency);
        if (availableNotes == null || availableNotes < quantity)
            throw new VendingMachineException("Invalid quantity");
        
        availableNotes = availableNotes - quantity;
        totalValue -= quantity * currency.getValue();
        currencyMap.put(currency, availableNotes);
    }
    
    @Override
    public int getAvailbleNotes(Currency currency)
    {
        Integer availability = currencyMap.get(currency);
        if (availability == null)
            return 0;
        
        return availability;
    }
    
    @Override
    public int getItemQuantity(Item item)
    {
        Integer availability = itemMap.get(item);
        if (availability == null)
            return 0;
        
        return availability;
    }
    
    @Override
    public int totalAvailableCashInVendingMachine()
    {
        return totalValue;
    }
    
    @Override
    public Map<Currency, Integer> getCurrencyMap()
    {
        return currencyMap;
    }
    
    @Override
    public void updateCurrencyMap(Map<Currency, Integer> tempMap, Map<Currency, Integer> currenciesInserted)
    {
        Set<Entry<Currency, Integer>> entrySet = currenciesInserted.entrySet();
        for (Entry<Currency, Integer> entry : entrySet)
        {
            addCurrency(entry.getKey(), entry.getValue());
        }
        Set<Entry<Currency, Integer>> returnChange = tempMap.entrySet();
        for (Entry<Currency, Integer> returnCurrency : returnChange)
        {
            removeCurrency(returnCurrency.getKey(), returnCurrency.getValue());
        }
    }
    
    @Override
    public void updateItemMap(Map<Item, Integer> buyingCart)
    {
        Set<Entry<Item, Integer>> boughtItems = buyingCart.entrySet();
        for (Entry<Item, Integer> boughtItem : boughtItems)
        {
            removeItem(boughtItem.getKey(), boughtItem.getValue());
        }
    }
}
