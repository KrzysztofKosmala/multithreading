public class ByExtend extends Thread
{
    private int size;
    public ByExtend()
    {
    }

    @Override
    public void run()
    {
        increment();
    }
    public void increment()
    {
        for(int i=0; i<100; i++)
        {
            size++;
            System.out.println(size+" "+ Thread.currentThread().getName());
        }
    }
}
