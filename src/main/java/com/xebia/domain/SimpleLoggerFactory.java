package com.xebia.domain;

import java.util.ArrayList;
import java.util.List;

public class SimpleLoggerFactory
{
	private static final List<SimpleLogger> LOGGERS = new ArrayList<>();

	public static SimpleLogger getLogger(final Class<?> clazz)
	{
		return LOGGERS.stream().filter(logger -> logger.getLoggerClass() == clazz).findFirst().orElse(createAndAdd(clazz));
	}

	private static SimpleLogger createAndAdd(final Class<?> clazz)
	{
		final SimpleLogger logger = new SimpleLogger(clazz);
		LOGGERS.add(logger);
		return logger;
	}
}
