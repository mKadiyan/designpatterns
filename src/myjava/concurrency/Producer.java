package myjava.concurrency;

import java.util.concurrent.locks.Lock;

class Producer extends Thread
{
   // l is final because it's initialized on the main thread and accessed on the
   // producer thread.

   private final Lock l;

   // s is final because it's initialized on the main thread and accessed on the
   // producer thread.

   private final Shared s;
   
   Producer(Shared s)
   {
      this.s = s;
      l = s.getLock();
   }

   @Override
   public void run()
   {
      for (char ch = 'A'; ch <= 'Z'; ch++)
      {
         l.lock();
         s.setSharedChar(ch);
         System.out.println(ch + " produced by producer.");
         l.unlock();
      }
   }
}