package com.example.demo;

public class Counter {
 
	public static int c=0;
	public static synchronized void increment()
	{
		c++;
	}
}
