package myjava.concept.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import myjava.concept.vendingmachine.vendingAdmin.AdminService;
import myjava.concept.vendingmachine.vendingAdmin.AdminServiceImpl;
import myjava.concept.vendingmachine.vendingUser.UserVendingService;
import myjava.concept.vendingmachine.vendingUser.UserVendingServiceImpl;

public class MainSimulator
{
    public static void main(String[] args)
    {
        AdminService adminService = initializeVendingMachine();
        
        System.out.println(adminService.getCurrencyMap());
        System.out.println(adminService.totalAvailableCashInVendingMachine());
        
        
        UserVendingService userVendingService = new UserVendingServiceImpl(adminService);
        
        transaction1(userVendingService);
//        transaction2(userVendingService);
    }
    
    public static void transaction1(UserVendingService userVendingService)
    {
    	// User deciding on items
    	userVendingService.buyItem(Item.ITEM_2, 1);
    	userVendingService.buyItem(Item.ITEM_4, 3);
    	
    	// Checkout by user
    	userVendingService.checkout();
    	
    	// Currencies that he inserts
    	HashMap<Currency, Integer> currenciesInserted = new HashMap<Currency, Integer>();
    	currenciesInserted.put(Currency.TWENTY, 1);
    	currenciesInserted.put(Currency.FIFTY, 1);
    	currenciesInserted.put(Currency.TEN, 1);
    	currenciesInserted.put(Currency.FIVE, 1);
    	Map<Currency, Integer> change = userVendingService.payBill(currenciesInserted);
    	
    	// Returned Change
    	for (Entry<Currency, Integer> entry : change.entrySet())
    	{
    		System.out.println(entry.getKey() + " : " + entry.getValue());
    	}
    }
    
    public static void transaction2(UserVendingService userVendingService)
    {
        userVendingService.buyItem(Item.ITEM_1, 1);
        userVendingService.checkout();
        HashMap<Currency, Integer> currenciesInserted = new HashMap<Currency, Integer>();
        currenciesInserted.put(Currency.TWENTY, 1);
        
        Map<Currency, Integer> change = userVendingService.payBill(currenciesInserted);
        
        // Returned Change
        for (Entry<Currency, Integer> entry : change.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    
    
    public static AdminService initializeVendingMachine()
    {
        AdminService adminService = new AdminServiceImpl();
        
        adminService.addItem(Item.ITEM_1, 10);
        adminService.addItem(Item.ITEM_2, 10);
        adminService.addItem(Item.ITEM_3, 10);
        adminService.addItem(Item.ITEM_4, 10);
        
        adminService.addCurrency(Currency.FIVE, 1);
        adminService.addCurrency(Currency.TEN, 1);
        adminService.addCurrency(Currency.TWENTY, 1);
        adminService.addCurrency(Currency.FIFTY, 1);
        return adminService;
    }
    
}
