package edu.school21.printer.app;

import java.io.IOException;
import edu.school21.printer.logic.*;

public class Program {
    public static void exit()
    {
        System.out.println("Usage: --b=%COLOR_CHAR% --w=%COLOR_CHAR%");
        System.exit(-1);
    }
    public static void main(String[] args) {

        Character[][] bitMapArray;
        Character black = null;
        Character white = null;
        ImageService imageService;
        String path = null;

        imageService = new ImageService();
        if (args.length != 2)
            exit();
        try {
            String[] split = args[0].split("=");
            if (split[0].equals("--b"))
                black = split[1].charAt(0);
            else if (split[0].equals("--w"))
                white = split[1].charAt(0);
            split = args[1].split("=");
            if (split[0].equals("--b"))
                black = split[1].charAt(0);
            else if (split[0].equals("--w"))
                white = split[1].charAt(0);
            if (black == null || white == null)
                exit();
            path = System.getProperty("user.dir") + "/target/resources/image.bmp";
            bitMapArray = imageService.getBitMapArray(path, black, white);
            for (int i = 0; i < bitMapArray.length; ++i)
            {
                for (int j = 0; j < bitMapArray[i].length; ++j)
                    System.out.print(bitMapArray[i][j]);
                System.out.print("\n");
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            exit();
        }
        catch (IOException e)
        {

        }
    }
}
