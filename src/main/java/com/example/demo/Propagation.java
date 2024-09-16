package com.example.demo;

public class Propagation {
	public int m()
	{
		int a= 40/0;
		return a;
	}
	public void  n()
	{
		m();
	}
	public void p()
	{
		try {
			m();
		}
		catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("40 can't be divided by zero");
		}
		
	}
}
