package com.example.demo;

public class A extends Thread {
	
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("thread A");
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	public void show()
	{
		System.out.println("show");
	}
	

}
