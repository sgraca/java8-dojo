package com.xebia.java8_3.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.xebia.domain.Company;
import com.xebia.domain.Person;

import static com.xebia.domain.Person.Role.ARCHITECT;
import static com.xebia.domain.Person.Role.PROGRAMMER;
import static com.xebia.domain.Person.Role.TESTER;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.findCompanyWithOldestEmployee;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.findWhichRoleIsMostPopularAcrossCompanies;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.groupByNamesOfEmployee;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.personToString;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.removeYoungestAndOldestChildrenFromList;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.takeWhile;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.zip;
import static com.xebia.java8_3.collections.IntermediateCollectionsLab.zipWithSum;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class IntermediateCollectionsLabTest
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
		persons = asList(p1, p2, p3);
	}


	@Test
	public void exercise_1_personWithCollectorToString()
	{
		final Person p1 = new Person("Anna", 32, false);
		final Person p2 = new Person("Peter", 21, true);
		final List<Person> persons = asList(p1, p2);
		assertThat(persons.stream().collect(personToString()), equalTo("(Anna -> F),(Peter -> M)"));
	}

	@Test
	@SuppressWarnings({"serial"})
	public void exercise_2_removeYoungestAndOldestPersons()
	{
		final Person p1 = new Person("John", 22, true);
		final Person p2 = new Person("Peter", 21, true);
		final Person p3 = new Person("Steven", 49, true);
		final Person p4 = new Person("Dave", 49, true);
		final Person p5 = new Person("Michael", 32, true);

		final List<Person> result = removeYoungestAndOldestChildrenFromList(new ArrayList<Person>()
		{
			{
				add(p1);
				add(p2);
				add(p3);
				add(p4);
				add(p5);
			}
		});
		assertThat(result, equalTo(asList(p1, p5)));
	}

	@Test
	public void exercise_3_combineAllEmployeesWithSameName()
	{
		final List<Company> companies =
				asList(//
						new Company("Xebia", //
								asList(new Person("Anna", 23, false), new Person("Peter", 35, false), new Person("Steven", 32,
										false))),//
						new Company("Ordina", //
								asList(new Person("Anna", 22, false), new Person("Steven", 21, false))) //
						, new Company("Atos", asList(new Person("Anna", 22, false))));
		assertThat(groupByNamesOfEmployee(companies).get("Anna"), hasSize(3));
	}

	@Test
	public void exercise_4_groupByAdultsAndMinors()
	{
		final Map<String, List<Person>> expected = new HashMap<>();
		expected.put("adults", asList(p1, p3));
		expected.put("minors", asList(p2));
		assertThat(IntermediateCollectionsLab.groupByAdultsAndMinors(persons), equalTo(expected));
	}

	@Test
	public void exercise_5_findMostPopularRole()
	{
		final List<Company> companies =
				asList(//
						new Company("Xebia", asList(new Person("a", 23, false, PROGRAMMER), new Person("b", 35, false,
								PROGRAMMER), new Person("b", 35, false, ARCHITECT))), //
						new Company("Ordina", asList(new Person("a", 22, false, PROGRAMMER), new Person("b", 21, false,
								PROGRAMMER))), //
						new Company("Capgemini", asList(new Person("a", 22, false, ARCHITECT))));
		assertThat(findWhichRoleIsMostPopularAcrossCompanies(companies), equalTo(PROGRAMMER));
	}

	@Test
	public void exercise_6_findOldestEmployeeOverCompanies()
	{
		final List<Person> expectedEmployees = asList(new Person("a", 23, false), new Person("b", 35, false));
		final List<Company> companies = asList(//
				new Company( //
						"Xebia", expectedEmployees //
				), new Company( //
						"Ordina", asList(new Person("a", 22, false), new Person("b", 21, false))//
				), new Company( //
						"Capgemini", asList(new Person("a", 22, false))));
		final Company company = findCompanyWithOldestEmployee(companies);
		assertThat(company.employees, equalTo(expectedEmployees));
	}

	@Test
	public void exercise_7_takeWhileEvenNumberInfiniteStream()
	{
		final List<Integer> result =
				takeWhile(Stream.iterate(1, i -> i++), i -> i % 2 == 0).limit(1).collect(Collectors.toList());
		assertThat(result, hasSize(0));
	}

	@Test
	public void exercise_8_zipWithSameSize()
	{
		final Stream<String> streamA = Stream.of("Xe", "Or", "At", "Co");
		final Stream<String> streamB = Stream.of("Xebia", "Ordina", "Atos", "Codecentric");
		final List<String> zipped = zip(streamA, streamB, (a, b) -> a + " is short for " + b).collect(Collectors.toList());

		assertThat(
				zipped,
				contains("Xe is short for Xebia", "Or is short for Ordina", "At is short for Atos",
						"Co is short for Codecentric"));
	}

	@Test
	public void exercise_8_zipFirstSmaller()
	{
		final Stream<String> streamA = Stream.of("Xe");
		final Stream<String> streamB = Stream.of("Xebia", "Ordina", "Atos", "Codecentric");
		final List<String> zipped = zip(streamA, streamB, (a, b) -> a + " is short for " + b).collect(Collectors.toList());

		assertThat(zipped, contains("Xe is short for Xebia"));
	}

	@Test
	public void exercise_8_zipLastSmaller()
	{
		final Stream<String> streamA = Stream.of("Xe", "Or", "At", "Co");
		final Stream<String> streamB = Stream.of("Xebia", "Ordina");
		final List<String> zipped = zip(streamA, streamB, (a, b) -> a + " is short for " + b).collect(Collectors.toList());

		assertThat(zipped, contains("Xe is short for Xebia", "Or is short for Ordina"));
	}

	@Test
	public void exercise_9_zipWithSumFunction()
	{
		final Stream<Integer> s1 = Stream.iterate(0, i -> i + 1).filter(i -> i % 2 == 0);
		final Stream<Integer> s2 = Stream.iterate(0, i -> i + 1).filter(i -> i % 2 == 1);
		final List<Integer> sum = zipWithSum(s1, s2).limit(4).collect(Collectors.toList());
		assertThat(sum, contains(1, 5, 9, 13));
	}
}
