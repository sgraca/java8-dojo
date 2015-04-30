package com.xebia.util;

import java.util.function.Supplier;

public class Measure
{

	public static <T> Pair<T, Long> measure(final Supplier<T> code)
	{
		final long current = System.currentTimeMillis();
		final T result = code.get();
		final long elapsed = (System.currentTimeMillis() - current);
		System.out.printf("Time elapsed: %s ms\n", elapsed);
		return new Pair<>(result, elapsed);
	}

	public static class Pair<T1, T2>
	{

		private final T1 first;
		private final T2 second;

		public Pair(final T1 first, final T2 second)
		{
			super();
			this.first = first;
			this.second = second;
		}

		public T1 getFirst()
		{
			return first;
		}

		public T2 getSecond()
		{
			return second;
		}

	}
}
