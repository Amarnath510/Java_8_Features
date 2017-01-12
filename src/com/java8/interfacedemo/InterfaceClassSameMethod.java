package com.java8.interfacedemo;

/**
 * If parent class and interface has same method defined 
 * then which one will be called by a class which extends and implementing the 
 * parent class and interface respective?
 * => In this scenario, extends has more priority over interface. 
 *
 */
public class InterfaceClassSameMethod {
	public static void main(String[] args) {
		new ConcreteA().show();
	}
}

class ParentA {

	public void show() {
		System.out.println("Parent class method.");
	}
}

interface InterfaceA {

	default public void show() {
		System.out.println("interface defaul method.");
	}
}

class ConcreteA extends ParentA implements InterfaceA {

}