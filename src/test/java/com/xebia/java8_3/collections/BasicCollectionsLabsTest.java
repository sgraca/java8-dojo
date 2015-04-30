package com.xebia.java8_3.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.xebia.domain.Person;

import static com.xebia.domain.Person.Role.PROGRAMMER;
import static com.xebia.domain.Person.Role.TESTER;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.allPersonsAboveAge;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.calculateSafeMax;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.calculateTheSumOfARangeUsingReduce;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.containsFemale;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.extractAllHobbiesToUppercase;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.filterAdults;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.filterEvenNumbers;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.filterMinorsAndExtractName;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.findTheOldestPerson;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.sumAgeWithMapFunction;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.sumAllAgesWithReducerFunction;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.sumWithCollectors;
import static com.xebia.java8_3.collections.BasicCollectionsLabs.timesAlphabet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertTrue;

public class BasicCollectionsLabsTest
{

	Person p1;
	Person p2;
	Person p3;
	List<Person> persons;

	@Before
	public void setUp() throws Exception
	{
		p1 = new Person("Jack", 31, true, PROGRAMMER, "Sailing", "Cycling");
		p2 = new Person("Benjamin", 12, true, PROGRAMMER, "Playing Piano");
		p3 = new Person("Suse", 37, false, TESTER, "Sailing", "Swimming");
		persons = Arrays.asList(p1, p2, p3);
	}

	@Test
	public void exercise_1_evenIntegersFilter()
	{
		assertThat(filterEvenNumbers(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)).toArray(),
				equalTo(new int[]{2, 4, 6, 8}));
	}

	@Test
	public void exercise2_shouldFilterAdults()
	{
		assertThat(filterAdults(persons), equalTo(Arrays.asList(p1, p3)));
	}

	@Test
	public void exercise_3_shouldFilterMinorsAndExtractNames()
	{
		assertThat(filterMinorsAndExtractName(persons), equalTo(Arrays.asList("Benjamin")));
	}

	@Test
	public void exercise_4_timesAlphabet()
	{
		assertThat(timesAlphabet(), allOf(startsWith("a,b,b,c,c,c,d,d,d,d,e,e,e,e,e"), endsWith("z,z,z,z,z,z,z")));
	}

	@Test
	public void exercise_5_uppercaseAllHobbies()
	{
		assertThat(extractAllHobbiesToUppercase(persons),
				equalTo(Arrays.asList("SAILING", "CYCLING", "PLAYING PIANO", "SWIMMING")));
	}

	@Test
	public void exercise_6_calculateTheSumOfARangeUsingReduce()
	{
		assertThat(
				calculateTheSumOfARangeUsingReduce(IntStream.rangeClosed(0, 5).boxed().collect(Collectors.toList())),
				equalTo(15));
	}

	@Test
	public void exercise_7_sumAllAgesWithReducerFunction()
	{
		final Person p1 = new Person("Anna", 32, false);
		final Person p2 = new Person("Peter", 21, true);
		final List<Person> persons = Arrays.asList(p1, p2);

		assertThat(sumAllAgesWithReducerFunction(persons), is(53));
	}

	@Test
	public void exercise_8_sumAgeWithMapFunction()
	{
		final Person p1 = new Person("Anna", 32, false);
		final Person p2 = new Person("Peter", 21, true);
		final List<Person> persons = Arrays.asList(p1, p2);

		assertThat(sumAgeWithMapFunction(persons), is(53));
	}

	@Test
	public void exercise_9_sumAllAges()
	{
		final Person p1 = new Person("Anna", 32, false);
		final Person p2 = new Person("Peter", 21, true);
		final List<Person> persons = Arrays.asList(p1, p2);

		assertThat(sumWithCollectors(persons), is(53));
	}

	@Test
	public void exercise_10_findOldestPerson()
	{
		assertThat(findTheOldestPerson(persons), equalTo(p3));
	}

	@Test
	public void exercise_11_allPersonsAboveAge()
	{
		assertTrue(allPersonsAboveAge(persons, 5));
	}

	@Test
	public void exercise_12_containsFemale()
	{
		assertTrue(containsFemale(persons));
	}

	@Test
	public void exercise_13_calculateSafeMax()
	{
		final List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5);
		assertThat(calculateSafeMax(integers), equalTo(5));
		assertThat(calculateSafeMax(new ArrayList<>()), equalTo(0));
	}
}
