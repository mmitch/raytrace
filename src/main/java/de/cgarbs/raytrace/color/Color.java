/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.raytrace.color;

public abstract class Color
{
	private final int r, g, b;

	protected Color(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}

	protected Color(double h, double s, double v)
	{
		while (h < 0)
		{
			h += 360;
		}
		h = h % 360;

		double c = v * s;
		double x = c * (1 - Math.abs((h / 60) % 2 - 1));
		double m = v - c;

		double r_ = 0;
		double g_ = 0;
		double b_ = 0;

		switch ((int) (h / 60))
		{
			case 0:
				r_ = c;
				g_ = x;
				break;

			case 1:
				r_ = x;
				g_ = c;
				break;

			case 2:
				g_ = c;
				b_ = x;
				break;

			case 3:
				g_ = x;
				b_ = c;
				break;

			case 4:
				r_ = x;
				b_ = c;
				break;

			case 5:
				r_ = c;
				b_ = x;
				break;
		}

		r = clip((r_ + m) * 255);
		g = clip((g_ + m) * 255);
		b = clip((b_ + m) * 255);
	}

	private int clip(double d)
	{
		// if (d < 0)
		// {
		// return 0;
		// }
		// if (d > 255)
		// {
		// return 255;
		// }
		return (int) d;
	}

	public int getRgbInt()
	{
		return r << 16 | g << 8 | b;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		if (!(o instanceof Color))
		{
			return false;
		}
		Color that = (Color) o;
		return this.r == that.r && this.g == that.g && this.b == that.b;
	}

	@Override
	public String toString()
	{
		return String.format("C(%d,%d,%d)", r, g, b);
	}
}
