package myjava.concurrency.Counter.v3;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter 
{
   private AtomicInteger value = new AtomicInteger();

   public int getValue() 
   {
      return value.get();
   }

   public int increment() 
   {
      int readValue = value.get();
      while (!value.compareAndSet(readValue, readValue+1))
         readValue = value.get();
      return readValue+1;
   }
}