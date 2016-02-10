package myjava.ser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FlattenTime
{
    public static void main(String[] args)
    {
        String filename = "time.ser";
        if (args.length > 0)
        {
            filename = args[0];
        }
        PersistentTime time = new PersistentTime();
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try
        {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            System.out.println("first== " + time);
            out.writeObject(time);
            out.reset();// gg
            time.setName("sikander");
            System.out.println("second== " + time);
            out.writeObject(time);
            out.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}