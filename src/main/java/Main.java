import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MAin
{
    public static void main(String args[])
    {


        /*
        SPOSOB 1

        */
        Thread t1 = new ByExtend();

        /*
        SPOSOB 2

        */
        Thread t2 = new Thread(new ByImplement());

        /*
        SPOSOB 3

        */
        Thread t3 = new Thread(
                () ->
        {
            for (int i =0;i<100;i++)
        {
            System.out.println(i+" "+Thread.currentThread().getName());
        }
        }
        );



        t1.start();
        System.out.println("t1 Done");
        t2.start();
        System.out.println("t2 Done");
        t3.start();
        System.out.println("t3 Done");
        //GŁÓWNY PROCES
       /* for (int i =0;i<100;i++)
        {
            System.out.println(i+" "+Thread.currentThread().getName());
        }
        System.out.println("MAin Done");*/

        try
        {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Złączenie wątków");
        /*
        SPOSOB 4
        Operacja na zmiennej przy dostępie tylko jednego wątku na raz
        */
        QuiteSafeMethod s = new QuiteSafeMethod();
        Thread t00 = new ByExtend2(s);
        Thread t01 = new ByExtend2(s);



        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(t00);
        pool.submit(t01);
        try
        {
            pool.shutdown();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        pool.shutdown();

        /*try
        {
            t01.join();
            t00.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }*/
        System.out.println("Złączenie wątków pracujących na zmiennej");
        //GŁÓWNY PROCES
        for (int i =0;i<100;i++)
        {
            System.out.println(i+" "+Thread.currentThread().getName());
        }
        System.out.println("MAin Done");

    }

}