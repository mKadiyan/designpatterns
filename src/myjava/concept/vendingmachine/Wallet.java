package myjava.concept.vendingmachine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Wallet {
	private int total = 0;
	private Map<Integer, Integer> currencyMap;

	public Wallet(Map<Integer, Integer> currencyMap) {
		this.currencyMap = new TreeMap<>(new DescendingComparator());
		Set<Entry<Integer,Integer>> entrySet = this.currencyMap.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			total +=entry.getKey()*entry.getValue();
		}
	}
	
	public int getTotal() {
		return total;
	}
	
	public Map<Integer, Integer> getChange(int givenAmount, int deductible) throws NoChangeException
	{
		Map<Integer, Integer> temp = new HashMap<>();
		int change = givenAmount - deductible;
		if(total < change)
			throw new NoChangeException("No change");
		
		if(change >  0)
		{
			Set<Entry<Integer,Integer>> entrySet = currencyMap.entrySet();
			for (Entry<Integer, Integer> entry : entrySet) {
				if(entry.getKey() < change)
				{
					int t = change/entry.getKey() ;
					
					if(entry.getValue() < t)
						t = entry.getValue();
					
					temp.put(entry.getKey(), t);
					change -=t*entry.getKey();
					
					if(change ==0)
						break;
				}
			}
			if(change > 0)
				throw new NoChangeException("No change");
		}
		updateCurrencyMap(temp);
		total -=change;
		return temp;
	}
	
	private void updateCurrencyMap(Map<Integer, Integer> temp) {
		Set<Entry<Integer,Integer>> entrySet = temp.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			int integer = currencyMap.get(entry.getKey()) - entry.getValue();
			if(integer > 0)
				currencyMap.put(entry.getKey(), integer);
			else
				currencyMap.remove(entry.getKey());
			
			
		}
		
	}

	static class DescendingComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return o1 > o2 ?1:(o1<o2?-1:0);
		}
		
	}
}
