package com.example.demo;

public class Student{
	
	public Student(int i)
	{
		this("efg");
		System.out.println("integer is called");
	}
   private Student(String s)
   {
	   System.out.println("string "+s);
   }
}
