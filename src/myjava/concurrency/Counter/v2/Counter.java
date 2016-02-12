package myjava.concurrency.Counter.v2;

public class Counter 
{
   private EmulatedCAS value = new EmulatedCAS();

   public int getValue() 
   {
      return value.getValue();
   }

   public int increment() 
   {
      int readValue = value.getValue();
      while (value.compareAndSwap(readValue, readValue+1) != readValue)
         readValue = value.getValue();
      return readValue+1;
   }
}