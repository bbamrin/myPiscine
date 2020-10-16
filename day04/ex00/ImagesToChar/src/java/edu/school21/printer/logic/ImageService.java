package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageService {

	public Character[][] getBitMapArray(String fileName, char black, char white) throws IOException
	{
		BufferedImage image = ImageIO.read(new File(fileName));
		Character[][] array = new Character[image.getHeight()][image.getWidth()];

		for (int x = 0; x < image.getHeight(); x++)
		{
			for (int y = 0; y < image.getWidth(); y++)
			{
				int color = image.getRGB(y, x);
				if (color == Color.BLACK.getRGB()){
					array[x][y] = black;
				}
				else {
					array[x][y] = white;
				}
			}
		}
		return array;
	}
}
