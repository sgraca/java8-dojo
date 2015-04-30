package com.xebia.java8_3.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

import com.xebia.domain.Company;
import com.xebia.domain.Person;
import com.xebia.domain.Person.Role;

public class IntermediateCollectionsLab
{
	public static Collector<Person, StringJoiner, String> personToString()
	{
		//TODO: 4.1 Implement the method personToString which requires you to write a new collector which prints out the name(uppercase) and the gender and age as a comma separated string.
		//
		// Example:
		// Person p = new Person("Frank", 32, true) should create: (FRANK -> M),
		//
		// Hint: Look at the method signature of Collector#of(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BinaryOperator, java.util.stream.Collector.Characteristics...)}
		return null;
	}

	public static List<Person> removeYoungestAndOldestChildrenFromList(final List<Person> persons)
	{
		//TODO: 4.2 Implement the method removeYoungestAndOldestChildrenFromList which removes the youngest and the oldest persons from the list.
		// Hint: take a look at IntSummaryStatistics and use a collector to collect these statistics.
		return persons;
	}

	public static Map<String, List<Person>> groupByNamesOfEmployee(final List<Company> companies)
	{
		//TODO: 4.3 Implement the method groupByNamesOfEmployee which will return a map with the key the name of the person and the value a list of persons with that name.
		return new HashMap<>();
	}

	public static Map<String, List<Person>> groupByAdultsAndMinors(final List<Person> persons)
	{
		//TODO: 4.4 Group the list of persons in adults and minors the result has to be a Map with key: 'adults' or 'minors' and value the list of persons belonging to the classifier.
		return null;
	}

	public static Role findWhichRoleIsMostPopularAcrossCompanies(final List<Company> companies)
	{
		//TODO: 4.5 Implement the method findWhichRoleIsMostPopularAcrossCompanies which will return the role which is most available across companies.
		return null;
	}

	public static Company findCompanyWithOldestEmployee(final List<Company> companies)
	{
		//TODO: 4.6 Implement the method findCompanyWithOldestEmployee which finds the oldest employee over all the companies. Hint: Don't forget you need to keep track of the company grouping on age will loose the companies.
		return null;
	}

	public static <T> Stream<T> takeWhile(final Stream<T> stream, final Predicate<T> predicate)
	{
		//TODO: 4.7 Implement the method takeWhile which continues consuming elements of the stream until the predicate returns false.
		// Hint: take a look at the Spliterators class.
		return stream;
	}

	public static <A, B, C> Stream<C> zip(final Stream<? extends A> a, final Stream<? extends B> b,
			final BiFunction<? super A, ? super B, ? extends C> zipFunction)
	{
		//TODO: 4.8 Implement the method zip which creates a combined Stream whose elements are the result of combining the elements of two streams. The function will be applied until one of the streams is exhausted.
		// Hint: take a look at the test cases first to get a feeling on how the zip method should work
		return null;
	}

	public static Stream<Integer> zipWithSum(final Stream<Integer> s1, final Stream<Integer> s2)
	{
		//TODO: 4.9 Implement this method which will take two streams of integers and returns a new stream by applying a stream which sums the elements of the zip method.
		return null;
	}

}
