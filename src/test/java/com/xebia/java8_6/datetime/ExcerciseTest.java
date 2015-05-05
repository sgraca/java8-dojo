package com.xebia.java8_6.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExcerciseTest
{

	private static final int ATTEMPTS = 5;

	private final ExcerciseInterface solution = new Solution();
	private final ExcerciseInterface attempt = new Attempt();

	private static LocalDate getRandomLocalDate()
	{
		return LocalDate.ofEpochDay((int) (Math.random() * 10000000));
	}

	private static LocalTime getRandomLocalTime()
	{
		return LocalTime.ofSecondOfDay((int) (Math.random() * 86400));
	}

	private static LocalDateTime getRandomLocalDateTime()
	{
		return LocalDateTime.of(getRandomLocalDate(), getRandomLocalTime());
	}

	@Test
	public void testGetCurrentDate()
	{
		assertEquals(solution.getCurrentDate(), attempt.getCurrentDate());
	}

	@Test
	public void testEinsteinBirthday()
	{
		assertEquals(solution.getEinsteinBirthday(), attempt.getEinsteinBirthday());
	}

	@Test
	public void testAddOneMonthAndThreeDays()
	{
		for (int i = 0; i < ATTEMPTS; i++)
		{
			final LocalDate date = getRandomLocalDate();
			assertEquals(solution.addOneMonthAndThreeDays(date), attempt.addOneMonthAndThreeDays(date));
		}
	}

	@Test
	public void testAddThreeWorkDays()
	{
		for (int i = 0; i < ATTEMPTS; i++)
		{
			final LocalDate date = getRandomLocalDate();
			assertEquals(solution.addThreeWorkDays(date), attempt.addThreeWorkDays(date));
		}
	}

	@Test
	public void testGetFriday()
	{
		assertEquals(solution.getFriday(), attempt.getFriday());
	}

	@Test
	public void testGetCurrentTime()
	{
		final LocalTime solutionTime = solution.getCurrentTime();
		final LocalTime attemptTime = attempt.getCurrentTime();
		assertNotNull(attemptTime);
		final Duration difference = Duration.between(solutionTime, attemptTime);
		assertTrue(difference.getSeconds() == 0 || difference.getSeconds() == 1);
	}

	@Test
	public void testGetWorkEndTime()
	{
		assertEquals(solution.getWorkEndTime(), attempt.getWorkEndTime());
	}

	@Test
	public void testAddTwoHoursAndNineMinutes()
	{
		for (int i = 0; i < ATTEMPTS; i++)
		{
			final LocalTime time = getRandomLocalTime();
			assertEquals(solution.addTwoHoursAndNineMinutes(time), attempt.addTwoHoursAndNineMinutes(time));
		}
	}

	@Test
	public void testGetCoffeeTime()
	{
		assertEquals(solution.getCoffeeTime(), attempt.getCoffeeTime());
	}

	@Test
	public void testGetCurrentDateTime()
	{
		final LocalDateTime solutionDateTime = solution.getCurrentDateTime();
		final LocalDateTime attemptDateTime = attempt.getCurrentDateTime();
		assertNotNull(attemptDateTime);
		final Duration difference = Duration.between(solutionDateTime, attemptDateTime);
		assertTrue(difference.getSeconds() == 0 || difference.getSeconds() == 1);
	}

	@Test
	public void testGetEarliestDate()
	{
		for (int i = 0; i < ATTEMPTS; i++)
		{
			final Collection<LocalDate> dates = new HashSet<>();
			for (int j = 0; j < ATTEMPTS; j++)
			{
				dates.add(getRandomLocalDate());
			}
			assertEquals(solution.getEarliestDate(dates), attempt.getEarliestDate(dates));
		}
	}

	@Test
	public void testGetNextWeekendStart()
	{
		assertEquals(solution.getNextWeekendStart(), attempt.getNextWeekendStart());
	}

	@Test
	public void testSubtractOneWeekAndEightySeconds()
	{
		for (int i = 0; i < ATTEMPTS; i++)
		{
			final LocalDateTime dateTime = getRandomLocalDateTime();
			assertEquals(solution.subtractOneWeekAndEightySeconds(dateTime), attempt.subtractOneWeekAndEightySeconds(dateTime));
		}
	}

	@Test
	public void testGetNextWeekendStartLongNotation()
	{
		assertEquals(solution.getNextWeekendStartISONotation(), attempt.getNextWeekendStartISONotation());
	}

	@Test
	public void testGetDaysUntilFriday()
	{
		assertEquals(solution.getDaysUntilFriday(), attempt.getDaysUntilFriday());
	}

	@Test
	public void testGetPeriodOfLunarCycle()
	{
		assertEquals(solution.getPeriodOfLunarCycle(), attempt.getPeriodOfLunarCycle());
	}

	@Test
	public void testGetTimeUntilNextWeekend()
	{
		final Duration solutionDuration = solution.getTimeUntilNextWeekend();
		final Duration attemptDuration = attempt.getTimeUntilNextWeekend();
		assertNotNull(attemptDuration);
		final Duration difference = solutionDuration.minus(attemptDuration);
		assertTrue(difference.getSeconds() == 0 || difference.getSeconds() == 1);
	}

	@Test
	public void testGetWorkDuration()
	{
		assertEquals(solution.getWorkDuration(), attempt.getWorkDuration());
	}
}
