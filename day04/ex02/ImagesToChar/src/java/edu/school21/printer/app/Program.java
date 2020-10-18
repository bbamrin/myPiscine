package edu.school21.printer.app;

import java.io.IOException;
import edu.school21.printer.logic.*;
import com.beust.jcommander.*;

public class Program {

    public static void exit(String s)
    {
        //"Usage: --b=%COLOR_CHAR% --w=%COLOR_CHAR%"
        System.out.println(s);
        System.exit(-1);
    }

    public static void exit()
    {
        System.out.println("Error");
        System.exit(-1);
    }

    public static void main(String[] args) {

        Character[][] bitMapArray;
        Character black = null;
        Character white = null;
        ImageService imageService;
        String PATH = System.getProperty("user.dir") + "/target/resources/image.bmp";

        Args argsCommander = new Args();
        try {
            JCommander.newBuilder()
                    .addObject(argsCommander)
                    .build()
                    .parse(args);
        } catch (ParameterException e)
        {
            exit(e.getMessage());
        }
        imageService = new ImageService(PATH, argsCommander.getWhite(), argsCommander.getBlack());
        try {
            imageService.printBitMapArray();
        }
        catch (IOException e)
        {

        }
    }
}
