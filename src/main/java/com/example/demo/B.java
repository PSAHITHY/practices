package com.example.demo;

public class B extends Thread {
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("Thread B");
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}
