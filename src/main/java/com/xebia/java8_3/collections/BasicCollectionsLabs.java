package com.xebia.java8_3.collections;

import java.util.List;
import java.util.stream.IntStream;

import com.xebia.domain.Person;

public class BasicCollectionsLabs
{

	public static IntStream filterEvenNumbers(final IntStream stream)
	{
		//TODO: 3.1 This method must filter out even numbers. The returned stream should only contain even numbers.
		return stream;
	}

	public static List<Person> filterAdults(final List<Person> persons)
	{
		//TODO: 3.2 Implement the method filterAdults which filters all the adults from a given list of persons.
		return null;
	}

	public static List<String> filterMinorsAndExtractName(final List<Person> persons)
	{
		//TODO: 3.3 Implement the method filterMinorsAndExtractName which filters and extracts the names.
		// Hint: use the map and filter methods from the stream.
		return null;
	}

	public static String timesAlphabet()
	{
		//TODO: 3.4 In this exercise we will introduce the flatMap operation, implement the method timesAlphabet which returns the following sequence: a,b,b,c,c,c,.....z,z,z,z (26 times) So each index of the letter in the alphabet should be printed 'x' times.
		// Hint: first create a sequence of [1], [2,2] [3,3,3] etc then use flatMap.
		return "";
	}

	public static List<String> extractAllHobbiesToUppercase(final List<Person> persons)
	{
		//TODO: 3.5 This method should return all the hobbies in uppercase.
		// Hint: take a look at flatMap, there are two ways (even more) to make sure the hobbies are distinct. You can convert to a set or you can use distinct.
		return null;
	}

	public static int calculateTheSumOfARangeUsingReduce(final List<Integer> integers)
	{
		//TODO: 3.6 Implement this method using the reduce method.
		return 0;
	}

	public static int sumAllAgesWithReducerFunction(final List<Person> persons)
	{
		//TODO: 3.7 Implement the method sumWithReducerFunction which given a list of persons uses a reducer to sum the age of all the persons.
		return 0;
	}

	public static int sumAgeWithMapFunction(final List<Person> persons)
	{
		//TODO: 3.8 Implement the method sumAgeWithMapFunction which calculates the sum of all ages using sum() and a map function.
		return 0;
	}

	public static int sumWithCollectors(final List<Person> persons)
	{
		//TODO: 3.9 Implement the method sumWithCollectors which is the same as exercise 8 but now try to use a collect and a Collector.
		return 0;
	}

	public static Person findTheOldestPerson(final List<Person> persons)
	{
		//TODO: 3.10 Implement the method findTheOldestPerson which returns the oldest person in the list.
		// Hint: try using Collectors.maxBy
		return null;
	}

	public static boolean allPersonsAboveAge(final List<Person> persons, final int minimumAge)
	{
		//TODO: 3.11 This method must return true if all the persons in the list are above the given minimum age.
		// Hint: take a look at the method Stream.allMatch
		return false;
	}

	public static boolean containsFemale(final List<Person> persons)
	{
		//TODO: 3.12 Check whether the list of persons contains a female using Stream.anyMatch.
		return false;
	}

	public static int calculateSafeMax(final List<Integer> integers)
	{
		//TODO: 3.13 Return the maximum value of a range or zero in case the range is empty using Stream and Optional
		// Hint: Do not check for empty lists.
		return 0;
	}
}
