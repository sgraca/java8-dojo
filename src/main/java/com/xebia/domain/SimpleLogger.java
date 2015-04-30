package com.xebia.domain;

import java.util.ArrayList;
import java.util.List;

public class SimpleLogger
{

	private static final String LOG_FORMAT = "%s: %s";
	private static final List<String> logged = new ArrayList<>();
	private final Class<?> className;

	protected SimpleLogger(final Class<?> clazz)
	{
		className = clazz;
	}

	public static boolean isLogged(final String s)
	{
		return logged.stream().map(log -> log.substring(log.indexOf(":") + 2)).anyMatch(log -> log.equals(s));
	}

	public static void clear()
	{
		logged.clear();
	}

	public void info(final Object s)
	{
		logged.add(String.format(LOG_FORMAT, className, s));
	}

	protected Class<?> getLoggerClass()
	{
		return className;
	}
}

