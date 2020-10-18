package edu.school21.printer.logic;

import com.diogonunes.jcolor.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageService {

	String path;
	String black;
	String white;

	public enum Colors {
		RED,
		GREEN,
		BLUE,
		CYAN,
		MAGENTA,
		YELLOW,
		BLACK,
		WHITE,
	}

    private Attribute getBgc(String bgc)
    {
    	if (bgc.equals(Colors.RED.toString())) {
		   return Attribute.RED_BACK();
	    }
    	else if (bgc.equals(Colors.GREEN.toString())){
		    return Attribute.GREEN_BACK();
	    }
	    else if (bgc.equals(Colors.BLUE.toString())){
		    return Attribute.BLUE_BACK();
	    }
	    else if (bgc.equals(Colors.CYAN.toString())){
		    return Attribute.CYAN_BACK();
	    }
	    else if (bgc.equals(Colors.MAGENTA.toString())){
		    return Attribute.MAGENTA_BACK();
	    }
	    else if (bgc.equals(Colors.YELLOW.toString())){
		    return Attribute.YELLOW_BACK();
	    }
	    else if (bgc.equals(Colors.BLACK.toString())){
		    return Attribute.BRIGHT_BLACK_BACK();
	    }
	    else if (bgc.equals(Colors.WHITE.toString())){
		    return Attribute.WHITE_BACK();
	    }
	    return null;
    }

	public ImageService(String path, String white, String black)
	{
		this.path = path;
		this.black = black;
		this.white = white;
	}

	public void printBitMapArray() throws IOException
	{
		BufferedImage image = ImageIO.read(new File(this.path));

		for (int x = 0; x < image.getHeight(); x++)
		{
			for (int y = 0; y < image.getWidth(); y++)
			{
				int color = image.getRGB(y, x);
				if (color == Color.BLACK.getRGB()){
					System.out.print(Ansi.colorize(" ", getBgc(this.black)));
				}
				else {
					System.out.print(Ansi.colorize(" ", getBgc(this.white)));
				}
			}
			System.out.println();
		}
	}
}
