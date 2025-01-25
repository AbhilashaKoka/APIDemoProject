package programsDemo.threadExample;


public class TemporarySuspendThread extends Thread{
    public static void main(String args[])
    {
        TemporarySuspendThread t1 = new TemporarySuspendThread();
        TemporarySuspendThread t2 = new TemporarySuspendThread();
        TemporarySuspendThread t3 = new TemporarySuspendThread();
        t1.start();
        t2.start();
        t2.suspend();
        t3.start();
    }

        public void run(){
            for (int i = 1; i < 5; i++)
            {
                try {
                    sleep(5);
                    System.out.println("Currently running - "+ Thread.currentThread().getName());
                }
                catch (InterruptedException e)
                {
                    System.out.println(e);
                }
                System.out.println(i);
            }
        }

    }

