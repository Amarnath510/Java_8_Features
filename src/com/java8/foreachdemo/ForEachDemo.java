package com.java8.foreachdemo;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
		
		// There are many ways to print a list here we will try to print in few traditional ways.
		// Traditional way - 1
//		for (int val : values) {
//			System.out.print(val + " ");
//		}
		
		// Another traditional way - 2
//		for (int i = 0; i < values.size(); i++) {
//			System.out.print(values.get(i) + " ");
//		}
		
		System.out.println("Using forEach (a new Java 8 feature)");
		values.forEach(index -> System.out.println(index));
	}
}
