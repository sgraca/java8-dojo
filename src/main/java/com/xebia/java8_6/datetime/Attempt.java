package com.xebia.java8_6.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Collection;

public class Attempt implements ExcerciseInterface
{
	@Override
	public LocalDate getCurrentDate()
	{
		//TODO: 8.1 return the current date
		return null;
	}

	@Override
	public LocalDate getEinsteinBirthday()
	{
		//TODO: 8.2 return the date of Albert Einsteins birthday: March 14, 1879
		return null;
	}

	@Override
	public LocalDate addOneMonthAndThreeDays(final LocalDate date)
	{
		//TODO: 8.3 Add exactly one month and three days to any given date
		return null;
	}

	@Override
	public LocalDate addThreeWorkDays(final LocalDate date)
	{
		//TODO: 8.4 Add three workdays to any given date. For example, Monday goes to Thursday and Thursday goes to Tuesday.
		//Hint: This is the same as adding three days, skpping over Saturday and Sunday
		return null;
	}

	@Override
	public LocalDate getFriday()
	{
		//TODO: 8.5 return the next or current date which is on a Friday
		return null;
	}

	@Override
	public LocalDate getEarliestDate(final Collection<LocalDate> dates)
	{
		//TODO: 8.6 return the earliest of the provided dates
		return null;
	}

	@Override
	public LocalTime getCurrentTime()
	{
		//TODO: 8.7 return the current time
		return null;
	}

	@Override
	public LocalTime getWorkEndTime()
	{
		//TODO: 8.8 returns the time at which work ends. For this exercise, thats 17:00
		return null;
	}

	@Override
	public LocalTime addTwoHoursAndNineMinutes(final LocalTime time)
	{
		//TODO: 8.9 add two hours and nine minutes to any given time
		return null;
	}

	@Override
	public LocalTime getCoffeeTime()
	{
		//TODO: 8.10 Return the next time to have coffee. For this exercise, coffee is had every 30 minutes past the whole hour.
		// For example, if the current time is 9:50, the next coffee time would be 10:30.
		// If the current time is 12:17, the next coffee time would be 12:30.
		return null;
	}

	@Override
	public LocalDateTime getCurrentDateTime()
	{
		//TODO: 8.11 return the current date and time
		return null;
	}

	@Override
	public LocalDateTime subtractOneWeekAndEightySeconds(final LocalDateTime dateTime)
	{
		//TODO: 8.12 Subtract one week and eighty seconds from any date and time
		return null;
	}

	@Override
	public LocalDateTime getNextWeekendStart()
	{
		//TODO: 8.13 the start of the next weekend, Friday at work end time
		return null;
	}

	@Override
	public String getNextWeekendStartISONotation()
	{
		//TODO: 8.14 return the date and time the next weekend starts, represented in long String notation.
		// The notation is defined in DateTimeFormatter.ISO_LOCAL_DATE_TIME
		return null;
	}

	@Override
	public Period getDaysUntilFriday()
	{
		//TODO: 8.15 return the number of days until the next (or this) Friday
		return null;
	}

	@Override
	public Period getPeriodOfLunarCycle()
	{
		//TODO: 8.16 Return the period of one lunar cycle in days (29.5), rounded up
		return null;
	}

	@Override
	public Period getPeriodSinceEinsteinBirthday()
	{
		//TODO: 8.17 return the period between Albert Einsteins birthday and the current date
		return null;
	}

	@Override
	public Duration getTimeUntilNextWeekend()
	{
		//TODO: 8.18 return the duration until the start of the next weekend
		return null;
	}

	@Override
	public Duration getWorkDuration()
	{
		//TODO: 8.19 return the duration of one work day, 8 hours
		return null;
	}
}
