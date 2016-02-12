package myjava.concurrency;

import java.util.concurrent.locks.Lock;

class Consumer extends Thread
{
   // l is final because it's initialized on the main thread and accessed on the
   // consumer thread.

   private final Lock l;

   // s is final because it's initialized on the main thread and accessed on the
   // consumer thread.

   private final Shared s;

   Consumer(Shared s)
   {
      this.s = s;
      l = s.getLock();
   }

   @Override
   public void run()
   {
      char ch;
      do
      {
         l.lock();
         ch = s.getSharedChar();
         System.out.println(ch + " consumed by consumer.");
         l.unlock();
      }
      while (ch != 'Z');
   }
}