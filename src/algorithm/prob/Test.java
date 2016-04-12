package algorithm.prob;
class Test{
    int a=20;
    static int b=10;
    void m1()
    {
        Test t= new Test();
        System.out.println(t.b);
    }
    public static void main(String args[])
    {
        Test t1= new Test();
        t1.m1();
    }
}