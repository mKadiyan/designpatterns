package myjava.concept.vendingmachine;

public enum Currency
{
    FIVE(5), TEN(10), TWENTY(20), FIFTY(50);
    
    private final int value;
    
    private Currency(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
}
