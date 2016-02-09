/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package algorithm.sorting;

import java.util.LinkedHashMap;

public class LruCache extends LinkedHashMap<Integer, String>
{
    private int capacity;

    public LruCache(int capacity)
    {
        super(capacity);
        this.capacity = capacity;
    }
    
    public static void main(String[] args)
    {
        LruCache cache = new LruCache(3);
        
        cache.put(1, "One");
        cache.put(4, "Three");
        cache.put(3, "Three");
        cache.put(3, "Three1");
        cache.put(3, "Three2");
        System.out.println(cache.size() + "==" + cache);
    }
    
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, String> eldest)
    {
        System.out.println(size() > capacity);
        return size() > capacity;
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
