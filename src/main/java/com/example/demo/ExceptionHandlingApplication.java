package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExceptionHandlingApplication {
   
	
	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlingApplication.class, args);
		
		try {
			int a=50/0;
		}
		catch(ArithmeticException e)
		{
//			e.printStackTrace();
			System.out.println(e.getMessage());
//			System.exit(0); this will stop finally block and rest of the code from running.
		}
		finally {
			System.out.println("Finally is executed");
		}
		//if we are not handling the exception using catch , finally block will execute and the rest of the code will not be executed.
		//if we are handling exception using catch block, finally block, rest of the code will be executed.
		System.out.println("rest of the code");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the age");
		int age= sc.nextInt();
		if(age<18)
		{
			try {
			throw new ArithmeticException("Invalid age");
			}
			catch(ArithmeticException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
		
		System.out.println("remaining code");//as the exception which is not handled in line 35, remaining code is not executed.
		//after implementing catch block remaining code will be executed.
		
		
		//exception propagation for unchecked exception in class Propagation.
		//can be handle the exception in any one of the method or in main method.
		//nothing but one method m is throwing an unchecked exception but it is not handling in the same method, but that method is being called is another method n that is also not handling , n method is being called in p method here the exception is handling. This is called exception propagation.
		Propagation p1= new Propagation();
		p1.p();
		System.out.println("unchecked exception Propogation ");
		
		//exception propagation for checked exception in class CheckedExceptionPropagation.
		//nothing but method x is throwing checked exception , we need to add throws declaration on all the methods which are interlinked with that method x. as y and z are interlinked with x so we need to add throws declaration on y and z methods.
		CheckedExceptionPropagation ce= new CheckedExceptionPropagation();
		try {
			ce.z();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("checked exception propagation13");
		
		//order of catch blocks
		//order of catch blocks should be most specific to general.If any of the particular exception is not handling  with default exception class can be handled as shown in OrderOfCatchBlocks class.
		OrderOfCatchBlocks or= new OrderOfCatchBlocks();
		or.b();
		System.out.println("order of catch blocks");
		
		//custom exception
		
		System.out.println("please enter the age to check eligibility");
		int age1=sc.nextInt();
		try
		{
			if(age1<18)
			{
				throw new InvalidAgeException(age1+" is not valid for Driving liscenec");
			}
			else
				System.out.println("continue");
		}
		catch(InvalidAgeException i)
		{
			System.out.println(i.getMessage());
		}
		//if you are not handling runtime exceptions using try and catch block, the code after the exception will not be executed.
		System.out.println("custom exception");
	}

}
