/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.raytrace;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import de.cgarbs.raytrace.color.Color;
import de.cgarbs.raytrace.color.HSV;
import de.cgarbs.raytrace.color.RGB;

public class RayTrace
{
	@Test
	public void doSometing() throws IOException
	{
		ResultBitmap result = new ResultBitmap();

		final double FOV = 45d;

		Color white = new RGB(255, 255, 255);
		for (int x = 0; x < result.WIDTH; x++)
		{
			double angleH = calculateAngle(x, result.WIDTH, FOV);
			for (int y = 0; y < result.HEIGHT; y++)
			{
				double angleV = calculateAngle(y, result.HEIGHT, FOV);
				result.drawPixel(x, y, new HSV(angleH, Math.abs(angleV * 2d / FOV), 1));
			}
		}

		result.writeToPngFile("/tmp/render.png");
	}

	@Test
	public void calculatedAngleOfMiddleValueIs0()
	{
		assertThat(calculateAngle(50, 101, 30), is(0d));
	}

	@Test
	public void calculatedAngleOfLowestValueIsMinusHalfFov()
	{
		assertThat(calculateAngle(0, 100, 30), is(-15d));
	}

	private double calculateAngle(int current, int max, final double fov)
	{
		double delta = current - ((max - 1) / 2d);
		return delta / (max - 1d) * fov;
	}
}
