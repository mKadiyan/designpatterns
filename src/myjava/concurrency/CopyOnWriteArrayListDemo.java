package myjava.concurrency;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo
{
    public static void main(String[] args)
    {
        List<String> empList = new ArrayList<>();
        empList.add("John Doe");
        empList.add("Jane Doe");
        empList.add("Rita Smith");
        Iterator<String> empIter = empList.iterator();
        while (empIter.hasNext())
            try
            {
                System.out.println(empIter.next());
                if (!empList.contains("Tom Smith"))
                    empList.add("Tom Smith");
            }
            catch (ConcurrentModificationException cme)
            {
                System.out.println("attempt to modify list during iteration");
                break;
            }
        System.out.println("===================================");
        List<String> empList2 = new CopyOnWriteArrayList<>();
        empList2.add("John Doe");
        empList2.add("Jane Doe");
        empList2.add("Rita Smith");
        empIter = empList2.iterator();
        while (empIter.hasNext())
        {
            System.out.println(empIter.next());
            boolean contains = empList2.contains("Tom Smith");
            System.out.println(contains);
            if (!contains)
                empList2.add("Tom Smith");
        }
        System.out.println("===================================");
        
        empIter = empList2.iterator();
        while (empIter.hasNext())
        {
            System.out.println(empIter.next());
            if (!empList2.contains("Tom Smith"))
                empList2.add("Tom Smith");
        }

    }
}