public class Program {
    public static void exit()
    {
        System.err.println("Illegal argument");
        System.exit(-1);
    }

    public static void main(String[] args) {
        Thread henThread;
        Thread eggThread;
        Object sync;
        Integer printAmount = 0;

        if (args.length != 1)
            exit();
        try {
            printAmount = Integer.parseInt(args[0].split("=")[1]);
        }
        catch (RuntimeException e)
        {
            exit();
        }
        TruthStore truthStore = new TruthStore();
        henThread = new Thread(new HenRunnable(truthStore, printAmount));
        eggThread = new Thread(new EggRunnable(truthStore, printAmount));
        eggThread.start();
        henThread.start();
        try {
            eggThread.join();
            henThread.join();
            while (printAmount-- > 0)
                System.out.println("Human");
        }
        catch (InterruptedException e)
        {

        }
    }
}
