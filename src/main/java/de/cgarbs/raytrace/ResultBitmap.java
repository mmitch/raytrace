/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.raytrace;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.cgarbs.raytrace.color.Color;

public class ResultBitmap
{
	public final static int WIDTH = 320;
	public final static int HEIGHT = 200;

	private final static int SCALE = 2;
	private final BufferedImage image;

	public ResultBitmap()
	{
		image = new BufferedImage(WIDTH * SCALE, HEIGHT * SCALE, BufferedImage.TYPE_INT_RGB);
	}

	public void drawPixel(int x, int y, Color color)
	{
		if (SCALE == 1)
		{
			image.setRGB(x, y, color.getRgbInt());
		}
		else
		{
			int startX = x * SCALE;
			int startY = y * SCALE;
			for (int offsetX = 0; offsetX < SCALE; offsetX++)
			{
				for (int offsetY = 0; offsetY < SCALE; offsetY++)
				{
					image.setRGB(startX + offsetX, startY + offsetY, color.getRgbInt());
				}
			}
		}
	}

	public void writeToPngFile(String filename) throws IOException
	{
		ImageIO.write(image, "png", new File(filename));
	}
}
