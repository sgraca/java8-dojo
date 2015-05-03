package com.xebia.java8_3.collections;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.xebia.domain.Company;
import com.xebia.domain.Person;
import com.xebia.domain.Person.Role;

public class IntermediateCollectionsLab
{
	public static Collector<Person, StringJoiner, String> personToString()
	{
		//TODO: 4.1 Implement the method personToString which requires you to write a new collector which prints out the name and the gender as a comma separated string.
		//
		// Example:
		// Person p = new Person("Frank", 32, true) should create: (Frank -> M),
		//
		// Hint: Look at the method signature of Collector#of(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BinaryOperator, java.util.stream.Collector.Characteristics...)}
		return Collector.of(
				() -> new StringJoiner(","),
				(joiner, p) -> joiner.add(String.format("(%s -> %s)", p.getName(), p.isMale() ? "M" : "F")),
				StringJoiner::merge,
				StringJoiner::toString
		);
	}

	public static List<Person> removeYoungestAndOldestChildrenFromList(final List<Person> persons)
	{
		//TODO: 4.2 Implement the method removeYoungestAndOldestChildrenFromList which removes the youngest and the oldest persons from the list.
		// Hint: take a look at IntSummaryStatistics and use a collector to collect these statistics.
		final IntSummaryStatistics statistics = persons.stream()
				.collect(Collectors.summarizingInt(Person::getAge));
		final Predicate<Person> isYoungest = p -> p.getAge() == statistics.getMin();
		final Predicate<Person> isOldest = p -> p.getAge() == statistics.getMax();
		return persons.stream()
				.filter(isYoungest.negate().and(isOldest.negate()))
				.collect(Collectors.toList());
	}

	public static Map<String, List<Person>> groupByNamesOfEmployee(final List<Company> companies)
	{
		//TODO: 4.3 Implement the method groupByNamesOfEmployee which will return a map with the key the name of the person and the value a list of persons with that name.
		return companies.stream()
				.flatMap(c -> c.employees.stream())
				.collect(Collectors.groupingBy(Person::getName));
	}

	public static Map<String, List<Person>> groupByAdultsAndMinors(final List<Person> persons)
	{
		//TODO: 4.4 Group the list of persons in adults and minors the result has to be a Map with key: 'adults' or 'minors' and value the list of persons belonging to the classifier.
		return persons.stream()
				.collect(Collectors.groupingBy(p -> p.isAdult() ? "adults" : "minors"));
	}

	public static Role findWhichRoleIsMostPopularAcrossCompanies(final List<Company> companies)
	{
		//TODO: 4.5 Implement the method findWhichRoleIsMostPopularAcrossCompanies which will return the role which is most available across companies.
		return companies.stream()
				.flatMap(c -> c.employees.stream())
				.collect(Collectors.groupingBy(Person::getRole)).entrySet().stream()
				.max(Comparator.comparing(e -> e.getValue().size()))
				.map(Map.Entry::getKey)
				.orElse(Role.UNKOWN);
	}

	public static Company findCompanyWithOldestEmployee(final List<Company> companies)
	{
		//TODO: 4.6 Implement the method findCompanyWithOldestEmployee which finds the oldest employee over all the companies. Hint: Don't forget you need to keep track of the company grouping on age will loose the companies.
		return companies.stream()
				.collect(Collectors.toMap(
						Function.identity(),
						c -> c.employees.stream().mapToInt(Person::getAge).max().orElse(0)))
				.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.map(Map.Entry::getKey)
				.orElse(null);
	}

	public static <T> Stream<T> takeWhile(final Stream<T> stream, final Predicate<T> predicate)
	{
		//TODO: 4.7 Implement the method takeWhile which continues consuming elements of the stream until the predicate returns false.
		// Hint: take a look at the Spliterators class.
		return StreamSupport.stream(
				new Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, 0)
				{
					final Iterator<T> iterator = stream.iterator();

					@Override
					public boolean tryAdvance(final Consumer<? super T> action)
					{
						if (iterator.hasNext()) {
							final T next = iterator.next();
							if (predicate.test(next))
							{
								action.accept(next);
								return true;
							}
						}
						stream.close();
						return false;
					}
				},
				stream.isParallel()
		);
	}

	public static <A, B, C> Stream<C> zip(final Stream<? extends A> a, final Stream<? extends B> b,
			final BiFunction<? super A, ? super B, ? extends C> zipFunction)
	{
		//TODO: 4.8 Implement the method zip which creates a combined Stream whose elements are the result of combining the elements of two streams. The function will be applied until one of the streams is exhausted.
		// Hint: take a look at the test cases first to get a feeling on how the zip method should work
		return StreamSupport.stream(
				new Spliterators.AbstractSpliterator<C>(Long.MAX_VALUE, Spliterator.NONNULL)
				{
					final Iterator<? extends A> i1 = a.iterator();
					final Iterator<? extends B> i2 = b.iterator();

					@Override
					public boolean tryAdvance(final Consumer<? super C> action)
					{
						if (i1.hasNext() && i2.hasNext())
						{
							final A itemA = i1.next();
							final B itemB = i2.next();
							action.accept(zipFunction.apply(itemA, itemB));
							return true;
						}
						a.close();
						b.close();
						return false;
					}
				},
				a.isParallel() && b.isParallel()
		);
	}

	public static Stream<Integer> zipWithSum(final Stream<Integer> s1, final Stream<Integer> s2)
	{
		//TODO: 4.9 Implement this method which will take two streams of integers and returns a new stream by applying a stream which sums the elements of the zip method.
		return zip(s1, s2, Integer::sum);
	}

}
