package com.xebia.java8_2.functions;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.xebia.domain.Person;
import com.xebia.domain.SimpleLogger;
import com.xebia.domain.SimpleLoggerFactory;

public class FunctionsLab
{

	public static Predicate<Person> selectAdultPersonWithLambda()
	{
		//TODO: 2.1 Create a predicate which uses a lambda expression to test whether a given person is an adult or not.
		return p -> true;
	}

	public static Predicate<Person> selectAdultPersonWithMethodReference()
	{
		//TODO: 2.2 Same as exercise 1 only now uses a method reference.
		return p -> true;
	}

	public static Predicate<Person> selectFemaleOrMinorsWithCombinedPredicates()
	{
		//TODO: 2.3 Use the logical operator methods in Predicate to combine predicates.
		return p -> true;
	}

	public static Predicate<Person> selectMinorMalePersonWithCombinedPredicates()
	{
		//TODO: 2.4 Use the logical operator methods in Predicate to combine new predicates.
		return p -> true;
	}

	public static Function<Person, String> convertNameToUppercase()
	{
		//TODO: 2.5 Write a function which outputs the name of the person in uppercase.
		return null;
	}

	public static BiFunction<String, String, String> comboString()
	{
		//TODO: 2.6 Write a function which takes two strings and returns a String as follows: short+long+short.
		return null;
	}

	public static BiFunction<Integer, Integer, Integer> sum()
	{
		//TODO: 2.7 Assign a Lambda to a BiFunction that calculates the sum of the two parameters passed to it
		return null;
	}

	public static BiFunction<Integer, Integer, Integer> max()
	{
		//TODO: 2.8 Assign a Static Method Reference to a BiFunction that calculates the max of two values.
		// As method reference the max method of Math.
		return null;
	}

	public static Function<Integer, Integer> square()
	{
		//TODO: 2.9 write a function which outputs the square.
		return null;
	}

	public static Function<Integer, String> sumToString()
	{
		//TODO: 2.10 Write a composition of two functions, one function which calculates the sum and one which will convert the sum to a String
		return null;
	}

	public static Consumer<Person> logWithConsumer()
	{
		//TODO: 2.11 Assign a Lambda to a {@link Consumer} that logs a {@link Person}'s toString.
		final SimpleLogger logger = SimpleLoggerFactory.getLogger(FunctionsLab.class);
		return null;
	}

	public static Consumer<Person> logWithMethodReference()
	{
		//TODO: 2.12 Instruction Assign a Method Reference of the info method of SimpleLogger to a Consumer that logs a Person's toString.
		final SimpleLogger logger = SimpleLoggerFactory.getLogger(FunctionsLab.class);
		return null;
	}

	public static Comparator<Person> sortByName()
	{
		//TODO: 2.13 Write an implementation of the comparator function using a lambda expression.
		return null;
	}

	public static Supplier<String> nameOfPersonWithLambdaSupplier(final Person p)
	{
		//TODO: 2.14 Assign a Lambda to a Supplier that returns a Person name.
		return null;
	}

	public static Supplier<String> nameOfPersonWithMethodReferenceSupplier(final Person p)
	{
		//TODO: 2.15 Assign a method reference to a Supplier that returns a Person name
		return null;
	}
}
