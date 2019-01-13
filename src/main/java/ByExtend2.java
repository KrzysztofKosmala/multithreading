public class ByExtend2 extends Thread
{
    QuiteSafeMethod safe=null;

    public ByExtend2(QuiteSafeMethod safe)
    {
        this.safe=safe;
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
            System.out.println(safe.getNext()+" - wartość inkrementowana przez różne wątki | Wątek - "+ Thread.currentThread().getName());
        }
    }
}