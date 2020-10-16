public class Program {
    public static void exit()
    {
        System.err.println("Illegal argument");
        System.exit(-1);
    }

    public static void main(String[] args) {
        Thread background1;
        Thread background2;
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
        background1 = new Thread(new BackgroundRunnable("Hen", printAmount));
        background2 = new Thread(new BackgroundRunnable("Egg", printAmount));
        background1.start();
        background2.start();
        try {
            background1.join();
            background2.join();
            while (printAmount-- > 0)
                System.out.println("Human");
        }
        catch (InterruptedException e)
        {

        }
    }
}
