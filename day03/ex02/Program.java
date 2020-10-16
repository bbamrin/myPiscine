import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    public static Integer[] generateRandomRange(Integer size)
    {
        Integer[] arr;
        Random random;

        arr = new Integer[size];
        random = new Random();
        for (int i = 0; i < size; ++i)
        {
            arr[i] = random.nextInt(2001) - 1000;
        }
        return arr;
    }

    public static Integer getRangeSum(Integer[] arr)
    {
        Integer sum;

        sum = 0;
        for (int i = 0; i < arr.length; ++i)
            sum += arr[i];
        return sum;
    }

    public static void exit()
    {
        System.err.println("Illegal argument");
        System.exit(-1);
    }

    public static void main(String[] args) {
        Integer[] randomArr;
        Integer trueSum;
        Integer ARRAY_SIZE = 0;
        SumContainer sumContainer;
        Integer THREADS_COUNT = 0;
        List<Thread> threads = new ArrayList<>();
        int step = 1;
        int i;
        int count = 0;

        if (args.length != 2)
            exit();
        try {
            ARRAY_SIZE = Integer.parseInt(args[0].split("=")[1]);
            THREADS_COUNT = Integer.parseInt(args[1].split("=")[1]);
            if (ARRAY_SIZE <= 0 || THREADS_COUNT <= 0)
                exit();
        }
        catch (RuntimeException e)
        {
            exit();
        }
        sumContainer = new SumContainer(0);
        if (ARRAY_SIZE % THREADS_COUNT == 0)
            step = ARRAY_SIZE / THREADS_COUNT;
        else
            step =  (ARRAY_SIZE + THREADS_COUNT - ARRAY_SIZE%THREADS_COUNT)/THREADS_COUNT;
        randomArr = generateRandomRange(ARRAY_SIZE);
        trueSum = getRangeSum(randomArr);
        System.out.println("Sum: " + trueSum);
        for (i = step; i <= ARRAY_SIZE; i += step)
        {
            threads.add(new Thread(new SumRunnable(i - step, i - 1, sumContainer, randomArr, count)));
            threads.get(count).start();
            count++;
        }
        if (ARRAY_SIZE % THREADS_COUNT != 0) {
            threads.add(new Thread(new SumRunnable(i - step, ARRAY_SIZE - 1, sumContainer, randomArr, count)));
            threads.get(count).start();
            count++;
        }
        for (int j = 0; j < count; j++) {
         try{
             threads.get(j).join();
         }
         catch (InterruptedException e)
         {

         }
        }
        System.out.printf("Sum by threads: %d\n", sumContainer.getSum());
    }
}
