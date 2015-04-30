package com.xebia.java8_1.lambdas;

import java.util.Comparator;

import com.xebia.domain.Person;
import com.xebia.domain.Persons;

public class LambdaLabs
{

	public static Persons filterUsingAnonymousInnerClass(final Persons persons)
	{
		//TODO: 1.1 Filter adults using a an anonymous inner class as input of the Persons.filter method.
		return persons.filter(new Persons.PersonFilter()
		{
			@Override
			public boolean accept(final Person person)
			{
				return person.isAdult();
			}
		});
	}

	public static Persons filterWithLambda(final Persons persons)
	{
		//TODO: 1.2 Filter adults using a Lambda Expression as input of the Persons.filter method.
		return persons.filter(p -> p.isAdult());
	}

	public static Persons filterWithMethodReference(final Persons persons)
	{
		//TODO: 1.3 Filter adults using a Method Reference as input of the Persons.filter method.
		return persons.filter(Person::isAdult);
	}

	public static Persons filterMaleAdultsWithStaticMethodReference(final Persons persons)
	{
		//TODO: 1.4 Filter male adults using a static method reference as input of the Persons.filter method.
		// Hint: use Persons.PersonSelector class
		return persons.filter(Persons.PersonSelector::maleAdults);
	}

	public static Persons sortPersonsWithLambda(final Persons persons)
	{
		//TODO: 1.5 Sort the persons by name using a Lambda Expression with two parameters as input of the Persons.sort method.
		return persons.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
	}

	public static Persons sortWithComparing(final Persons persons)
	{
		//TODO: 1.6 Sort the persons by name by creating a Comparator with the Comparator.comparing method.
		// Use a Method Reference to define the sorting key (getName) as argument of the comparing method.
		return persons.sort(Comparator.comparing(Person::getName));
	}
}
