/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.raytrace.color;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HSVTest
{
	@Test
	public void hsvBlackIsRgbBlack()
	{
		assertThat(new HSV(0, 0, 0), is(new RGB(0, 0, 0)));
	}

	@Test
	public void hsvMaroonIsRgbMaroon()
	{
		assertThat(new HSV(0, 1, .5), is(new RGB(127, 0, 0)));
	}

	@Test
	public void hsvTealIsRgbTeal()
	{
		assertThat(new HSV(180, 1, .5), is(new RGB(0, 127, 127)));
	}
}
