package com.example.demo;

public class CheckedExceptionPropagation {

	public void x() throws ClassNotFoundException
	{
		throw new ClassNotFoundException("Class not found exception checked exception propagation");
	}
	public void y() throws ClassNotFoundException
	{
		x();
	}
	public void z() throws ClassNotFoundException
	{
		y();
	}
}
