/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.raytrace.color;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RGBTest
{
	@Test
	public void toStringShowsRGBValues()
	{
		assertThat(new RGB(0, 50, 128).toString(), is("C(0,50,128)"));
	}
}
