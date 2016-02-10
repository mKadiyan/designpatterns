/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package myjava.concept;

import java.util.LinkedHashMap;

public class LRUCache1 extends LinkedHashMap<String, String>
{
    private int cap;
    
    public LRUCache1(int cap)
    {
        super(cap);
        this.cap = cap;
    }


    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<String, String> eldest)
    {
        System.out.println(size() > cap);
        return size() > cap;
    }
    
    public static void main(String[] args)
    {
        LRUCache1 cache1 = new LRUCache1(2);
        cache1.put("a1", "a1");
        cache1.put("a2", "a2");
        System.out.println(cache1.get("a1"));
        cache1.put("a3", "a3");
        System.out.println(cache1);
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
