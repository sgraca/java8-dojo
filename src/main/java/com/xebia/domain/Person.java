package com.xebia.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Person
{
	private final String name;
	private final int age;
	private final boolean male;
	private final Role role;
	private final List<String> hobbies;

	public Person(final String name, final int age, final boolean isMale)
	{
		this.age = age;
		this.name = name;
		male = isMale;
		role = Role.UNKOWN;
		hobbies = new ArrayList<>();
	}

	public Person(final String name, final int age, final boolean isMale, final Role role)
	{
		this.age = age;
		this.name = name;
		male = isMale;
		this.role = role;
		hobbies = new ArrayList<>();
	}

	public Person(final String name, final int age, final boolean isMale, final Role role, final String... hobby)
	{
		this.age = age;
		this.name = name;
		male = isMale;
		this.role = role;
		hobbies = Arrays.asList(hobby);
	}

	public int getAge()
	{
		return age;
	}

	public boolean isMale()
	{
		return male;
	}

	public String getName()
	{
		return name;
	}

	public boolean isAdult()
	{
		return age >= 18;
	}

	public List<String> getHobbies()
	{
		return hobbies;
	}

	public Role getRole()
	{
		return role;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + hobbies.hashCode();
		result = prime * result + (male ? 1231 : 1237);
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (role == null ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Person other = (Person) obj;
		if (age != other.age)
		{
			return false;
		}
		if (!hobbies.equals(other.hobbies))
		{
			return false;
		}
		if (male != other.male)
		{
			return false;
		}
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		}
		else if (!name.equals(other.name))
		{
			return false;
		}
		if (role != other.role)
		{
			return false;
		}
		return true;
	}

	public String toString()
	{
		return String.format("Person[name=%s, age=%s, role=%s, hobbies=%s]", name, age, role, hobbies);
	}

	public enum Role
	{
		PROGRAMMER, SCRUMMASTER, ARCHITECT, PROJECT_MANAGER, TESTER, UNKOWN;
	}
}
