package com.xebia.java8_5.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Collection;


public class Solution implements ExcerciseInterface
{

	@Override
	public LocalDate getCurrentDate()
	{
		return LocalDate.now();
	}

	@Override
	public LocalDate getEinsteinBirthday()
	{
		return LocalDate.of(1879, 3, 14);
	}

	@Override
	public LocalDate addOneMonthAndThreeDays(final LocalDate date)
	{
		return date.plusMonths(1).plusDays(3);
	}

	@Override
	public LocalDate addThreeWorkDays(final LocalDate date)
	{
		final int toAdd;
		switch (date.getDayOfWeek())
		{
			case WEDNESDAY:
			case THURSDAY:
			case FRIDAY:
				toAdd = 5;
				break;
			case SATURDAY:
				toAdd = 4;
				break;
			default:
				toAdd = 3;
				break;
		}
		return date.plusDays(toAdd);
	}

	@Override
	public LocalDate getFriday()
	{
		return LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
	}

	@Override
	public LocalDate getEarliestDate(final Collection<LocalDate> dates)
	{
		return dates.stream().min(LocalDate::compareTo).get();
	}

	@Override
	public LocalTime getCurrentTime()
	{
		return LocalTime.now();
	}

	@Override
	public LocalTime getWorkEndTime()
	{
		return LocalTime.of(17, 0);
	}

	@Override
	public LocalTime addTwoHoursAndNineMinutes(final LocalTime time)
	{
		return time.plusHours(2).plusMinutes(9);
	}

	@Override
	public LocalTime getCoffeeTime()
	{
		final LocalTime now = LocalTime.now();
		final int minutes = now.getMinute();
		if (minutes > 30)
		{
			return now.plusMinutes(90 - minutes);
		}
		else
		{
			return now.plusMinutes(30 - minutes);
		}
	}

	@Override
	public LocalDateTime getCurrentDateTime()
	{
		return LocalDateTime.now();
	}

	@Override
	public LocalDateTime getNextWeekendStart()
	{
		final LocalTime workEnd = getWorkEndTime();
		LocalDate friday = getFriday();
		if (friday.equals(LocalDate.now()))
		{
			if (LocalTime.now().isAfter(workEnd))
			{
				friday = friday.plusDays(7);
			}
		}
		return LocalDateTime.of(friday, workEnd);
	}

	@Override
	public LocalDateTime subtractOneWeekAndEightySeconds(final LocalDateTime dateTime)
	{
		return dateTime.minusWeeks(1).minusSeconds(80);
	}

	@Override
	public String getNextWeekendStartISONotation()
	{
		return getNextWeekendStart().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	@Override
	public Period getDaysUntilFriday()
	{
		return Period.between(LocalDate.now(), getFriday());
	}

	@Override
	public Period getPeriodOfLunarCycle()
	{
		return Period.ofDays(30);
	}

	@Override
	public Period getPeriodSinceEinsteinBirthday()
	{
		return Period.between(getEinsteinBirthday(), getCurrentDate());
	}

	@Override
	public Duration getTimeUntilNextWeekend()
	{
		return Duration.between(LocalDateTime.now(), getNextWeekendStart());
	}

	@Override
	public Duration getWorkDuration()
	{
		return Duration.ofHours(8);
	}
}
