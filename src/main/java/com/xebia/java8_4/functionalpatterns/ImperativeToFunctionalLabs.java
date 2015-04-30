package com.xebia.java8_4.functionalpatterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xebia.domain.Person;

import static com.xebia.domain.Person.Role.PROGRAMMER;

public class ImperativeToFunctionalLabs
{


	public static class Lab1
	{

		public static class Imperative
		{

			/**
			 * Given imperative approach for filtering persons with role
			 * Programmer, sorting them by name and group them by age
			 *
			 * @param persons list of persons
			 * @return Map with key= age group (10, 20, 30 etc.) and value=List
			 * of Persons belonging to this group
			 */
			public static Map<Integer, List<Person>> filterAndGroupPersons(final List<Person> persons)
			{
				// filter programmers
				final List<Person> programmers = new ArrayList<>();
				for (final Person p : persons)
				{
					if (p.getRole() == PROGRAMMER)
					{
						programmers.add(p);
					}
				}

				// sort
				Collections.sort(programmers, new Comparator<Person>()
				{
					public int compare(final Person p1, final Person p2)
					{
						return p1.getName().compareTo(p2.getName());
					}
				});

				// group by age group
				final Map<Integer, List<Person>> programmersPerAgeGroup = new HashMap<>();
				for (final Person programmer : programmers)
				{
					final int ageGroup = programmer.getAge() / 10 * 10;
					final List<Person> ageGroupProgrammers =
							programmersPerAgeGroup.getOrDefault(ageGroup, new ArrayList<>());
					ageGroupProgrammers.add(programmer);
					programmersPerAgeGroup.put(ageGroup, ageGroupProgrammers);
				}
				return programmersPerAgeGroup;
			}
		}

		public static class Functional
		{
			public static Map<Integer, List<Person>> filterAndGroupPersons(final List<Person> persons)
			{
				//TODO: 7.1 Provide a functional solution in Lab1.Functional.filterAndGropupPersons that yields the same result as the imperative example using the Stream API.
				// The goal is to provide a functional approach for filtering persons with role Programmer,
				// sorting them by name and group them by age. The method should return a map where the
				// with key=age group (10, 20, 30 etc.) and value is a list of persons belonging to this group.
				// Look at the imperative implementation Lab1.Imperative.filterAndGroupPersons.
				return null;
			}
		}
	}

	public static class Lab2
	{

		public static class Imperative
		{

			/**
			 * Given imperative approach for calculating the longest word in a
			 * list of lines. The words in a line can be separated by a space.
			 *
			 * @param lines containing words separated by a space
			 * @return length of longest word found
			 */
			public static int calculateLengthOfLongestWord(final List<String> lines)
			{

				int lengthLongestWord = 0;
				for (final String line : lines)
				{
					for (final String word : line.split(" "))
					{
						if (word.length() > lengthLongestWord)
						{
							lengthLongestWord = word.length();
						}
					}
				}
				return lengthLongestWord;
			}
		}

		public static class Functional
		{

			public static int calculateLengthOfLongestWord(final List<String> lines)
			{
				//TODO: 7.2 Given the imperative implementation of the method calculateLengthOfLongestWord provide a functional
				// approach for calculating the longest word in a list of lines. The words in a line can be separated by a space.
				return 0;
			}

			/**
			 * Enhance the functional approach above to execute in parallel
			 *
			 * @return length of longest word found
			 */
			public static int calculateLengthOfLongestWordInParallel(final List<String> lines)
			{
				//TODO: 7.3 Enhance the implementation of Lab2.Functional.calculateLengthOfLongestWord so that the calculation of the longest word per line is executed in parallel.
				return 0;
			}
		}
	}
}
