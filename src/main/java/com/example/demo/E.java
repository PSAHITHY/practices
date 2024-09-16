package com.example.demo;

public class E extends Thread{
	
  public void run()
  {
	  for(int i=0; i<5;i++)
	  {
		  System.out.println("My Self Sahithya");
		  try {
			  sleep(10);

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	 
	  System.out.println("I am a Developer");
  }
 

}
