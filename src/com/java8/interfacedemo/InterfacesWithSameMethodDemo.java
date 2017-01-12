package com.java8.interfacedemo;

/**
 * When two interfaces define the same default method then which one will be called 
 * by the class which is implementing these classes?
 * => If both are having the default method with same signature 
 *    then the concrete class has to implement that particular method.
 */
public class InterfacesWithSameMethodDemo {
	public static void main(String[] args) {
		new ConcreteAB().show();
	}
}

interface IA {
	default void show() {
		System.out.println("Show from interface IA.");
	}
}


interface IB {
	default void show() {
		System.out.println("Show from interface IB.");
	}
}

class ConcreteAB implements IA, IB {
	
	@Override
	public void show() {
		// You can call either of the methods or you can define your own implementation.
		IA.super.show();
		IB.super.show();
		System.out.println("Concrete class own implementation.");
	}
}