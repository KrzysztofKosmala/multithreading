public class QuiteSafeMethod
{
    private int value=0;

    public QuiteSafeMethod()
    {
    }
    public synchronized int getNext()
    {
        value++;
        return value;
    }


}
