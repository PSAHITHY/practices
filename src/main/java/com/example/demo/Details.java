package com.example.demo;

public class Details extends Student{
	
	public static int a=10;
	public int b=30;

	public Details(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	public Details(String s)
	{
		this(1);
		System.out.println("Details constructor is called."+ s);
	}
	//non static methods and variables can not be accessed in static methods.
	//need to create an object if you want to access.
	public static void getNumber()
	{
		int a=20;
		Details d= new Details(10);
		System.out.println(d.b);
		System.out.println(a);
		System.out.println(Details.a);
		
	}
	//static methods and variables can be accessed in non static methods.
	public void getInteger() {
		int b=40;
		System.out.println(b);
		System.out.println(this.b);
		System.out.println(a);
		getNumber();
	}

}
