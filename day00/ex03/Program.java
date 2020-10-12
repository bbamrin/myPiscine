package com.company;

import java.util.Scanner;

public class Main {

    public static long pow(int i, int p)
    {
        long res;

        if (p == 0)
            return (1);
        res = 1;
        while (p > 0)
        {
            res *= i;
            p--;
        }
        return (res);
    }

    public static void exit()
    {
        System.err.println("Illegal Argument");
        System.exit(-1);
    }

    public static int getMinTestVal(Scanner scanner)
    {
        int i;
        int min;
        int inp;

        i = -1;
        min = 10;
        while (++i < 5 && scanner.hasNext())
        {
            if (scanner.hasNextInt() == false)
                exit();
            if ((inp = scanner.nextInt()) <= min)
                min = inp;
        }
        return (min);
    }

    public static void printGraph(long data)
    {
        int i;
        long c;
        boolean flag;
        String format;

        i = 1;
        flag = false;
        if (data >= 1000000000)
            flag = true;
        while (data > 0)
        {
            c = data % 10;
            if (c > 0)
            {
                if (flag && i <= 9)
                    System.out.printf("Week %d  ", i);
                else
                    System.out.printf("Week %d ", i);
            }
            while (c > 0) {
                System.out.print("=");
                if (c == 1)
                    System.out.println(">");
                c--;
            }
            data /= 10;
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner;
        int     i;
        int     tmp;
        long    result;
        String  input;

        scanner = new Scanner(System.in);
        i = -1;
        result = 0;
        while (!(input = scanner.next()).equals("42") && scanner.hasNext())
        {
            if (input.equals("Week"))
            {
                if (scanner.hasNextInt() == false)
                    exit();
                tmp = scanner.nextInt();
                if (tmp == 42)
                    break;
                if (tmp > 18 || tmp < 1)
                    exit();
                if (i == -1)
                    i = tmp;
                else if (tmp <= i)
                    exit();
                i = tmp;
                result += pow(10, i - 1) * getMinTestVal(scanner);
            }
            else
                exit();
        }
        printGraph(result);
    }
}
