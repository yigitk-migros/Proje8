package com.migros.ucg.threads.example5.program;

import com.migros.ucg.utility.Util;

public class Islemci
{
    private int sayac = 0;
    private static final int LIMIT = 500;

    public void sayaciArtir()
    {
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < LIMIT; i++)
                {
                    sayac++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < LIMIT; i++)
                {
                    sayac++;
                }
            }
        });

        thread1.start();
        thread2.start();

        try
        {
            thread1.join(); // main thread, thread1'i bekler
            thread2.join(); // main thread, thread2'yi bekler
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            Util.showGeneralExceptionInfo(e);
        }

        System.out.println("sayaç: " + sayac);
    }
}
