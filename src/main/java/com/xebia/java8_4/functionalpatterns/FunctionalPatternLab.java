package com.xebia.java8_4.functionalpatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.xebia.domain.Person;
import com.xebia.domain.Person.Role;
import com.xebia.domain.PersonParser;

// In this lab you will learn how to create your own 'higher order function'.
// A higher order function is a method that accepts a functional interface as input parameter.
// So far you have only used existing higher order functions like e.g. map, filter, groupBy etc. in the Stream API.
// In the lab below you will convert a solution that makes use of the template design-pattern into one that uses a higher order function.
//
// As you will see, the higher order function approach is much more flexible, readable and requires less lines of code.
public class FunctionalPatternLab
{


	public static class InheritanceApproach
	{

		public abstract static class PersonFilterTemplate
		{

			/**
			 * Given imperative approach for filtering persons read from a URL.
			 * The filtering logic is delegated to a subclass that implements
			 * the abstract {@link PersonFilterTemplate#doFilterPerson} method.
			 *
			 * @param url pointing to resource with persons in csv format
			 * @return filtered persons
			 */
			public List<Person> filterPersonsImperativeImpl(final URL url)
			{
				final List<Person> collected = new ArrayList<>();
				try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())))
				{
					String csv = "";
					while ((csv = br.readLine()) != null)
					{
						final Person person = PersonParser.parse(csv);
						// filter person
						if (doFilterPerson(person))
						{
							collected.add(person);
						}
					}
				}
				catch (final IOException e)
				{
					throw new RuntimeException(e);
				}
				return collected;
			}

			public List<Person> filterPersonsFunctionalImpl(final URL url)
			{
				//TODO: 6.1 Implement FunctionalPersonFilter.filterPersonsFunctionalImpl in a functional style using the same processing logic as in the PersonFilterTemplate.filterPersonsImperativeImpl
				// Hint: use BufferedReader.lines() as a starting point to the Stream API. As you can see not only Collections return Streams but BufferedReader too.
				try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())))
				{
					return br.lines()
							.map(PersonParser::parse)
							.filter(this::doFilterPerson)
							.collect(Collectors.toList());
				}
				catch (final IOException e)
				{
					throw new RuntimeException(e);
				}
			}

			protected abstract boolean doFilterPerson(Person person);

		}

		/**
		 * Concrete filter implementation
		 */
		public static class ProgrammersFilter extends PersonFilterTemplate
		{
			@Override
			protected boolean doFilterPerson(final Person person)
			{
				return person.getRole() == Role.PROGRAMMER;
			}
		}
	}

	public static class HigherOrderFunctionApproach
	{

		public static class FunctionalPersonFilter
		{

			public static List<Person> filterPersons(final URL url, final Predicate<Person> personFilter)
			{
				//TODO: 6.2 Implement the higher order function FunctionalPersonFilter.filterPerson.
				// In this functional implementation the filtering logic can directly be defined as a Predicate without
				// the need to implement an abstract method like in the PersonFilterTemplate example.
				// Hint: Most of the processing logic written in exercise 1 (see above) can be re-used.
				try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())))
				{
					return br.lines()
							.map(PersonParser::parse)
							.filter(p -> p.getRole() == Role.PROGRAMMER)
							.collect(Collectors.toList());
				}
				catch (final IOException e)
				{
					throw new RuntimeException(e);
				}
			}

		}
	}
}
