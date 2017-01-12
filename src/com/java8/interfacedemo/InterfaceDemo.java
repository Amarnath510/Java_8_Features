package com.java8.interfacedemo;

interface Phone {
	// existing method
	void call();
	
	// After some time you thought to add new methods.
	// You can't just add like above as it will break the code.
	// Hence we will use default method to have an concrete implementation.
	// In sub classes, we can override default methods it we want. 
	default void message() {
		System.out.println("Message Sent.");
	}
	
	// Prior to Java 8 we can't have static methods but now we can have static
	// methods too with implementation.
	// As we know we can't override static methods.
	static void settings() {
		System.out.println("Phone Settings. (Will be same for all.)");
	}
	
}

class AndroidPhone implements Phone {

	@Override
	public void call() {
		System.out.println("Calling from Android Phone.");
	}
}

class ApplePhone implements Phone {

	@Override
	public void call() {
		System.out.println("Calling from Apple Phone.");
	}
	
	// Overriding message method default implementation.
	@Override
	public void message() {
		System.out.println("Apple messages are different. We send apples along with messages.");
	}
}

class InterfaceDemo {
	public static void main(String[] args) {
		
		System.out.println("***** Java 8 Interface Demo with Default and Static Methods. *****\n");
		
		System.out.println("***** Android Phone *****");
		Phone androidPhone = new AndroidPhone();
		androidPhone.call();
		androidPhone.message();
		Phone.settings();
		
		System.out.println("\n***** Apple Phone *****");
		Phone applePhone = new ApplePhone();
		applePhone.call();
		applePhone.message();
		Phone.settings();
		
		
	}
}