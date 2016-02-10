/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package myjava.concept;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
    Map<Integer, Node> map = new HashMap<Integer, LRUCache.Node>();
    Node start;
    Node end;

    void add(Integer key, String val)
    {
        if(start ==null)
        {
            start = new Node(val);
            end = start;
        }
        else
        {
            Node temp = new Node(val);
            temp.pre = start;
            start = temp;
        }
    }
    
    String get(Integer key)
    {
        return null;
    }
    
    boolean remove(Integer key)
    {
        return false;
    }

    static class Node
    {
        public Node(String val)
        {
            this.val = val;
        }
        Node head;
        Node pre;
        String val;
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
