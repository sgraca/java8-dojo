package com.xebia.java8_3.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// In this lab we will construct part of the Phone code benchmark link.
// The original task is more difficult but in this lab you will learn a lot more about String,
// maps and collectors together in a real example.
//
// In this lab we take the following phone mnemonics:
//  ABC DEF GHI JKL MNO PQRS TUV WXYZ
//   2   3   4   5   6   7    8   9
//
// We will build a PhoneCoder which will translate a phone number to all phrases of words in a dictionary that can
// serve as mnemonics for the phone number. For example 5282 should translate to Java if this was supplied in the dictionary.
public class PhoneCoder
{
	@SuppressWarnings("serial")
	private static final Map<Character, String> MNEMONICS = new HashMap<Character, String>()
	{
		{
			put('2', "ABC");
			put('3', "DEF");
			put('4', "GHI");
			put('5', "JKL");
			put('6', "MNO");
			put('7', "PQRS");
			put('8', "TUV");
			put('9', "WXYZ");
		}
	};
	private static final Map<Character, Character> CHAR_TO_DIGIT = charToDigit(MNEMONICS);
	private Map<String, List<String>> numbers;

	public PhoneCoder(final List<String> words)
	{
		numbers = distributeWords(words);
	}

	public static Map<Character, Character> charToDigit(final Map<Character, String> mnemonics)
	{
		//TODO: 5.1 This method is a helper function which should return a Map<Character, Character>
		// for example if we take mnemonics = new HashMap<Character, String>('2', "ABC") then the returned map should contain:
		// 'A' --> '2'
		// 'B' --> '2'
		// 'C' --> '2'
		//
		// Tip use the String method chars().
		final Map<Character, Character> charCodes = new HashMap<>();
		return charCodes;
	}

	public static String getNumberFrom(final String word)
	{
		//TODO: 5.2 This method should translate a given word into a number, for example 'Java' should return 5282.
		return word;
	}

	public static Map<String, List<String>> distributeWords(final List<String> words)
	{
		//TODO: 5.3 This method takes a list of words as input and as a result creates a map from number to the word.
		// So for example if you take Java, Lava as your words the method should return a map which contains:
		// 5282 --> [ Java, Lava ]
		return null;
	}

	public List<String> translate(final String number)
	{
		//TODO: 5.4 Implement the method translate which will return the words based on the given number.
		return Arrays.asList(number);
	}
}
