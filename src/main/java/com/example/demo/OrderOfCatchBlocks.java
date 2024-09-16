package com.example.demo;

public class OrderOfCatchBlocks {

	public void b() {
		String[] s = new String[10];
		try {
//			System.out.println(s[11]);
			int a=30/0;
		}
		 catch (ArithmeticException a) {
			System.out.println(a.getMessage());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
