package com.example.demo;

import java.util.Comparator;

public class SortByNameAndSalary implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int n=0;
		if(o1.getEmployee_salary()<o2.getEmployee_salary())
		{
			n=-1;
		}
		if(o1.getEmployee_salary()>o2.getEmployee_salary())
		{
			n=1;
		}
		if(o1.getEmployee_salary()==o2.getEmployee_salary())
		{
			n=o1.getEmployee_name().compareTo(o2.getEmployee_name());
		}
		return n;
	}




}
