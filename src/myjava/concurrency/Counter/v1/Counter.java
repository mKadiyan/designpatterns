package myjava.concurrency.Counter.v1;

public class Counter 
{
   private int value;

   public synchronized int getValue() 
   { 
      return value; 
   }

   public synchronized int increment() 
   { 
      return ++value; 
   }
}