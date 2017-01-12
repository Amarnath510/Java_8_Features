package com.java8.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		
		System.out.println("***** Java 8 Stream API tutorial *****");
		
		// Get all the persons.
		List<Person> persons = PersonFactory.createPeople();
		
		System.out.println("\n----- Get all persons whose age is > 18 -----");
		
		// Get all the persons whose age is > 18.
		// Traditional way.
		System.out.println("\n***** Traditional Approach *****");
		List<String> names1 = new ArrayList<String>();
		for (Person p : persons) {
			if (p.getAge() > 18) {
				names1.add(p.getName().toUpperCase());
			}
		}
		System.out.println(names1);

		// Using Streams
		System.out.println("\n***** Using Streams *****");
		List<String> names2 = persons.stream()
									 .filter(person -> person.getAge() > 18)  // for every person in persons get the one whose age is > 18.
									 .map(Person::getName)	/* or .map(person -> person.getName()) */ // then for the person after filter get the name.
									 .map(String::toUpperCase)		/* or .map(name -> name.toUpperCase()) */ // then for name from above convert to upper case.
									 .collect(Collectors.toList());  // finally convert the output to a list.
		System.out.println(names2);
		
		// Stream example 2
		// Get the sum of all ages of all persons.
		System.out.println("\n***** Sum of ages of all persons (using Streams) *****");
		System.out.println(
				persons.stream()
						.map(Person :: getAge)
						.reduce(0, (carry, age) -> carry + age)
				);
	}
}