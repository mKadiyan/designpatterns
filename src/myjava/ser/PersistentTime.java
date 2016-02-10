package myjava.ser;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PersistentTime implements Serializable
{
    private Date time;
    private String name = "ravinder";
    
    public PersistentTime()
    {
        time = Calendar.getInstance().getTime();
    }

    public Date getTime()
    {
        return time;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return "PersistentTime [time=" + time + ", name=" + name + "]";
    }

}