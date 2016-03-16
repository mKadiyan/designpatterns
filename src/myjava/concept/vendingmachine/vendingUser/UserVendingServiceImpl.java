package myjava.concept.vendingmachine.vendingUser;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import myjava.concept.vendingmachine.Currency;
import myjava.concept.vendingmachine.Item;
import myjava.concept.vendingmachine.exception.VendingMachineException;
import myjava.concept.vendingmachine.vendingAdmin.AdminService;

public class UserVendingServiceImpl implements UserVendingService
{
    private AdminService adminService;
    
    private boolean checkOut = false;
    
    private int billingAmount = 0;
    
    private Map<Item, Integer> buyingCart = new HashMap<>();
    
    public UserVendingServiceImpl(AdminService adminService)
    {
        this.adminService = adminService;
    }
    
    @Override
    public void buyItem(Item item, int quantity)
    {
        if (!checkOut)
        {
            int itemQuantity = adminService.getItemQuantity(item);
            if (itemQuantity < quantity)
            {
                System.out.println("Asked quantity is not available");
                return;
            }
            
            billingAmount += quantity * item.getPrice();
            buyingCart.put(item, quantity);
        }
        else
        {
            throw new VendingMachineException("Another Transaction Pending");
        }
    }
    
    @Override
    public int checkout()
    {
        if (!checkOut)
        {
            checkOut = true;
            return billingAmount;
        }
        else
        {
            throw new VendingMachineException("Another Transaction Pending");
        }
    }
    
    @Override
    public Map<Currency, Integer> payBill(Map<Currency, Integer> currenciesInserted)
    {
        int insertedAmount = 0;
        Map<Currency, Integer> change = new HashMap<>();
        for (Entry<Currency, Integer> entry : currenciesInserted.entrySet())
        {
            insertedAmount += entry.getKey().getValue() * entry.getValue();
        }
        
        if (insertedAmount < billingAmount)
        {
            System.out.println("Please insert more money : " + (billingAmount - insertedAmount));
            return change;
        }
        
        if ((insertedAmount - billingAmount) > adminService.totalAvailableCashInVendingMachine())
        {
            System.out.println("Please insert less ammount as vending machine don't have enough change");
            return change;
        }
        
        change = getChange(insertedAmount - billingAmount, currenciesInserted);
        return change;
    }
    
    private Map<Currency, Integer> getChange(int change, Map<Currency, Integer> currenciesInserted)
    {
        int currentAmmount = change;
        Map<Currency, Integer> tempMap = new HashMap<>();
        Set<Entry<Currency, Integer>> entrySet = adminService.getCurrencyMap().entrySet();
        for (Entry<Currency, Integer> mapEntry : entrySet)
        {
            int value = mapEntry.getKey().getValue();
            int requiredNotes = currentAmmount / value;
            Integer availableNotes = getAvailableNotes(mapEntry, currenciesInserted);
            if (requiredNotes > availableNotes)
                requiredNotes = availableNotes;
            
            currentAmmount -= requiredNotes * value;
            tempMap.put(mapEntry.getKey(), requiredNotes);
            if (currentAmmount == 0)
            {
                adminService.updateCurrencyMap(tempMap, currenciesInserted);
                adminService.updateItemMap(buyingCart);
                resetAll();
                checkOut = false;
                return tempMap;
            }
        }
        
        if (currentAmmount != 0)
        {
            System.out.println("Can't have changes");
            resetAll();
            return new HashMap<Currency, Integer>();
        }
        
        return new HashMap<Currency, Integer>();
    }
    
    private void resetAll()
    {
        checkOut = false;
        
        billingAmount = 0;
        
        buyingCart = new HashMap<>();
    }
    
    public Integer getAvailableNotes(Entry<Currency, Integer> mapEntry, Map<Currency, Integer> currenciesInserted)
    {
        Integer insertNotes = currenciesInserted.get(mapEntry.getKey());
        if (insertNotes == null)
        {
            insertNotes = new Integer(0);
        }
        return mapEntry.getValue() + insertNotes;
    }
}
