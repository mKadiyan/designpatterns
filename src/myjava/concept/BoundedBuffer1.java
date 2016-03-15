/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package myjava.concept;

import java.util.Random;


public class BoundedBuffer1
{
    final Object[] items = new Object[2];

    int takeptr, putptr, count;
    
    public void put(Object o) throws InterruptedException
    {
        synchronized (this)
        {
            while (count == items.length)
            {
                System.out.println(Thread.currentThread().getName() + " Buffer full  .. waiting");
                wait();
                System.out.println(Thread.currentThread().getName() + " out of  .. waiting");
                
            }
            System.out.println(Thread.currentThread().getName() + " put = " + o);
            if (putptr == items.length)
                putptr = 0;
            items[putptr++] = o;
            count++;
            System.out.println(Thread.currentThread().getName() + " notify ");
            notify();

        }
    }
    
    public Object take() throws InterruptedException
    {
        Object o = null;
        synchronized (this)
        {
            while (count == 0)
            {
                System.out.println(Thread.currentThread().getName() + " Buffer empty  .. waiting");
                wait();
                System.out.println(Thread.currentThread().getName() + " out of  .. waiting");
                
            }
            if (takeptr == items.length)
                takeptr = 0;
            o = items[takeptr++];
            System.out.println(Thread.currentThread().getName() + " take = " + o);
            count--;
            System.out.println(Thread.currentThread().getName() + " notify ");
            notify();
        }
        return o;
    }
    
    public static void main(String[] args)
    {
        BoundedBuffer1 buffer1 = new BoundedBuffer1();
        Producer producer = new Producer(buffer1);
        Consumer consumer = new Consumer(buffer1);
        
        Thread p = new Thread(producer, "Producer");
        Thread c = new Thread(consumer, "Consumer");
        p.start();
        c.start();
    }
    
    static class Producer implements Runnable
    {
        BoundedBuffer1 buffer1;
        Random random;
        
        public Producer(BoundedBuffer1 buffer1)
        {
            this.buffer1 = buffer1;
            random = new Random();
        }

        @Override
        public void run()
        {
            for (int i = 0; i < 50; i++)
            {
                try
                {

                    buffer1.put(new Integer(i));
                    Thread.sleep(random.nextInt(500));
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    
                }
            }
            
        }
    }
    
    static class Consumer implements Runnable
    {
        BoundedBuffer1 buffer1;
        Random random;
        public Consumer(BoundedBuffer1 buffer1)
        {
            this.buffer1 = buffer1;
            random = new Random();
        }
        
        @Override
        public void run()
        {
            for (int i = 0; i < 50; i++)
            {
                try
                {
                    
                    buffer1.take();
                    Thread.sleep(random.nextInt(500));
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    
                }
            }
            
        }
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
