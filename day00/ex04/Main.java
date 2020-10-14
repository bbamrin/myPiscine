package com.company;

import java.util.Scanner;

public class Main {

    public static void exit()
    {
        System.err.println("Illegal Argument");
        System.exit(-1);
    }

    public static void printIndent(int maxNum, int num)
    {
        if (num == -1)
        {
            if (maxNum / 100 > 0)
                System.out.print(" ");
            if (maxNum / 10 > 0)
                System.out.print(" ");
        }
        else
        {
            if (maxNum / 100 > 0 && num / 100 == 0)
            {
                if (num / 10 > 0)
                    System.out.print(" ");
                else
                    System.out.print("  ");
            } else if (maxNum / 10 > 0)
            {
                if (num / 10 == 0)
                    System.out.print(" ");
            }
        }
    }

    public static void printGraph(float treshold, float step, int frequencyArr[])
    {
        int i;

        i = -1;
        while (++i < 10)
        {
            if (frequencyArr[i] != -1) {
                if ((float)(frequencyArr[i] + step) >= treshold && (float)frequencyArr[i] < treshold)
                {
                    printIndent(frequencyArr[0], frequencyArr[i]);
                    System.out.print(frequencyArr[i]);
                    if (i != 9)
                        System.out.print(" ");
                }
                else if ((float)frequencyArr[i] >= treshold)
                {
                    printIndent(frequencyArr[0], -1);
                    System.out.print("#");
                    if (i != 9)
                        System.out.print(" ");
                }
            }
        }
    }

    public static void shiftArr(int arr[], int len, int start)
    {
        int i;

        i = len - 1;
        while (i > start)
        {
            arr[i] = arr[i - 1];
            i--;
        }
    }

    public static int findFreeSpace(int freqArr[], int charArr[], int start, int i)
    {

        while (start < 10)
        {
            if (charArr[start] == -1)
                return (start);
            if (freqArr[charArr[start]] < freqArr[i])
                return (start);
            if (freqArr[charArr[start]] == freqArr[i] && charArr[start] > i)
                return (start);
            start++;
        }
        return (-1);
    }

    public static int[][] findMax(int frequencyArr[], int len)
    {
        int     maxArr[];
        int     charsMax[];
        int     i;
        int     j;


        maxArr = new int[10];
        charsMax = new int[10];
        j = -1;
        while (++j < 10)
        {
            maxArr[j] = -1;
            charsMax[j] = -1;
        }
        i = -1;
        while (++i <  len)
        {
            j = -1;
            while (++j < 10)
            {
                if (frequencyArr[i] != 0 && frequencyArr[i] > maxArr[j] && maxArr[j] == -1)
                {
                    maxArr[j] = frequencyArr[i];
                    charsMax[j] = i;
                    break;
                } else if (frequencyArr[i] != 0 && frequencyArr[i] >= maxArr[j] && maxArr[j] != -1)
                {
                    shiftArr(maxArr, 10, j);
                    if (frequencyArr[i] == maxArr[j] && charsMax[j] < i) {

                        if (findFreeSpace(frequencyArr, charsMax, j + 1, i) > 0) {
                            shiftArr(charsMax, 10, findFreeSpace(frequencyArr, charsMax, j + 1, i));
                            charsMax[findFreeSpace(frequencyArr, charsMax, j + 1, i)] = i;
                        }
                    }
                    else {
                        shiftArr(charsMax, 10, j);
                        charsMax[j] = i;
                    }
                    maxArr[j] = frequencyArr[i];
                    break;
                }
            }
        }
        return new int[][]{charsMax, maxArr};
    }

    public static void print(int resultMatrix[][])
    {
        int     i;
        float     step;
        float     treshhold;

        i = 11;
        step = (((float)(resultMatrix[1][0])/10));
        treshhold = (float) resultMatrix[1][0] + step;
        while (--i >= 0)
        {
            printGraph(treshhold, step, resultMatrix[1]);
            if (i != 0)
                System.out.print("\n");
            treshhold -= step;
        }
        i = -1;
        while (++i < 10)
        {
            if (resultMatrix[1][i] != -1 && (float)resultMatrix[1][i] < treshhold)
            {
                printIndent(resultMatrix[1][0], resultMatrix[1][i]);
                System.out.print(resultMatrix[1][i]);
                if (i != 9)
                    System.out.print(" ");
            }

        }
        System.out.print("\n");
        i = -1;
        while (++i < 10)
        {
            if (resultMatrix[1][i] != -1) {
                printIndent(resultMatrix[1][0], 1);
                System.out.print((char) resultMatrix[0][i]);
                if (i != 9)
                    System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        String  input;
        int     frequencyArr[];
        int     i;
        int     resultMatrix[][];
        char    input_arr[];

        i = -1;
        input = (new Scanner(System.in)).nextLine();
        if (input.length() < 1)
            exit();
        input_arr = input.toCharArray();
        frequencyArr = new int[65536];
        while (++i < 65536)
            frequencyArr[i] = 0;
        i = -1;
        while (++i < input.length())
            frequencyArr[(int) (input_arr[i])]++;
        resultMatrix = findMax(frequencyArr, 65536);
        print(resultMatrix);
    }
}
