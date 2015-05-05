package com.xebia.java8_5.defaultmethods;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultipleInheritanceConflictLab
{

	public interface Car
	{
		default String startEngine()
		{
			return "Brrrum";
		}
	}

	public interface Plane
	{
		default String startEngine()
		{
			return "Wrrrrrrr";
		}
	}

	// TODO: 7.1 Add declaration to implement Car and Plane interfaces.
	// It doesn't compile - look at the error message.
	public class FlyingCar implements Car, Plane
	{
		// TODO: 7.2 Fix the compilation error by writing startEngine() method which resolves the conflict.
		// Make the FlyingCar sound like Plane by delegating call to startEngine() method of Plane.

		@Override
		public String startEngine()
		{
			return Plane.super.startEngine();
		}
	}


	@Test
	public void shouldSoundLikePlane()
	{
		// given
		FlyingCar flyingCar = new FlyingCar();
		String sound = null;

		// when
		// TODO: 7.3 Uncomment and run test - it should pass
		sound = flyingCar.startEngine();

		// then
		assertEquals("Wrrrrrrr", sound);
	}
}
