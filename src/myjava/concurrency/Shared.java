package myjava.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Shared
{
   // Fields c and available are volatile so that writes to them are visible to 
   // the various threads. Fields lock and condition are final so that they're
   // initial values are visible to the various threads. (The Java memory model 
   // promises that, after a final field has been initialized, any thread will 
   // see the same [correct] value.)

   private volatile char c;
   private volatile boolean available;
   private final Lock lock;
   private final Condition condition;

   Shared()
   {
      c = '\u0000';
      available = false;
      lock = new ReentrantLock();
      condition = lock.newCondition();
   }

   Lock getLock()
   {
      return lock;
   }

   char getSharedChar()
   {
      lock.lock();
      try
      {
         while (!available)
            try
            {
               condition.await();
            }
            catch (InterruptedException ie)
            {
               ie.printStackTrace();
            }
         available = false;
         condition.signal();
      }
      finally
      {
         lock.unlock();
         return c;
      }
   }

   void setSharedChar(char c)
   {
      lock.lock();
      try
      {
         while (available)
            try
            {
               condition.await();
            }
            catch (InterruptedException ie)
            {
               ie.printStackTrace();
            }
         this.c = c;
         available = true;
         condition.signal();
      }
      finally
      {
         lock.unlock();
      }
   }
}