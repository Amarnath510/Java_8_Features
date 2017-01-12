package com.java8.lambdademo;

public class LambdaExpressionDemo {
	public static void main(String[] args) {
		
		System.out.println("***** Lambda Expressions Demo. *****\n");
		
		// Traditional way. Do this if the interface has more than one method or
		// if the implementation class will be used in other places also.
		new CLambdaA().show();

		// Or we can write traditional anonymous class as follows.
		ILambdaA anonyObj = new ILambdaA() {
			
			@Override
			public void show() {
				System.out.println("Anonymous class implementation WITHOUT Lambda expression.");
			}
		};
		anonyObj.show();
		
		// Else try Lambda expressions which is nothing but Anonymous function.
		// We should implement it only when we are sure that the interface has only one method. 
		// It can have default methods no problem with that.
		// Use "{ //your code }" after "->" only if we have more than one statement else it is not necessary. 
		// But for understanding lets use it even there is only one statement.
		// Also here "()" is nothing but parameters of that method.
		ILambdaA iObj = () -> {
								System.out.println("Anonymous class using Lamdba expressions.");
							  };
		
		iObj.show();
		
		
		// What happens if the method have parameters?
		ISum iSumObj = (x, y) -> {
								int sum = x + y;
								return sum;
							 };
							 
		System.out.println(iSumObj.sum(10, 20));					 
	}
}

interface ISum {
	int sum(int a, int b);
	
	// Subtraction default implementation. 
	// Since this is default there is no problem for Lambda expression.
	// If this is abstract then we will have a problem.
	default int substract(int a, int b) {
		return a - b;
	}
}

interface ILambdaA {
	void show();
}

class CLambdaA implements ILambdaA {
	
	@Override
	public void show() {
		System.out.println("Implementing Concrete class for Interface.");
	}
}