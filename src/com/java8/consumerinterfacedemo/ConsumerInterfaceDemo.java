package com.java8.consumerinterfacedemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceDemo {
	public static void main(String[] args) {
		
		System.out.println("***** Consumer Interface Demo *****");
		
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		// By creating separate class we are setting Consumer param to forEach.
		System.out.println("\n***** Consumer object creation with separate class. ******");
		Consumer<Integer> c = new ConsumerImpl();
		values.forEach(c);
		
		System.out.println("\n***** Consumer object creation with anonymous class. ******");
		Consumer<Integer> cAnon = new Consumer<Integer>() {
										@Override
										public void accept(Integer i) {
											System.out.print(i + " ");	
										}
								  };
		values.forEach(cAnon);
		
		System.out.println("\n***** Consumer object creation with Lambda expressions. ******");
		// We already know from Lamda expressions if the class is implementing
		// only one interface then we can write Lambda expression for the same.
		// We already know that since there is only one paramter for accept method we don't need to put that in braces.
		// Since there is only one statement for the accept method implementation in our code we don't even need those braces.
	    // Consumer<Integer> cLambda = (i) -> { System.out.print(i + " "); }; will become
		Consumer<Integer> cLambda = i -> System.out.print(i + " ");
		values.forEach(cLambda);							
		
		
		System.out.println("\n***** Consumer object creation optimized with Lambda expressions. ******");
		// Here instead of forEach referencing Consumer we can directly give the implementation.
		// This is the final statement which we wrote in ForEach example.
		values.forEach(i -> System.out.print(i + " "));
	}
}

class ConsumerImpl implements Consumer<Integer> {
	
	@Override
	public void accept(Integer i) {
		System.out.print(i + " ");
	}
}