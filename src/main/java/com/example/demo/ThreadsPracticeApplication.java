package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadsPracticeApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ThreadsPracticeApplication.class, args);
		/* if we want to run two methods parallel that can be done by using threads.
		 Threads can be created in 2 ways.
		 1.using Thread class
		    methods in thread class are start(),sleep() and stop().
		 2.Using Runnable interface
		   method in runnable interface is run().
		 */
		A a= new A();
		B b= new B();
		//without sleep method in respective class A,B
		
		a.start();
//		a.start();//we can't start single thread 2 times will throw an exception called Illegal Thread State exception.
		b.start();
		a.join();
		b.join();
		a.show();
		
		//with the above lines 2 methods are running parallel. but if we observe out first thread A is executed for some time after that thread b after that thread a.
		//if we want that to be in optimized way i.e one after the other then  we need to use sleep method in thread classes.
		//sleep method throws checked exception called Interrupted exception.
		// creating threads using runnable interface.
		Runnable c= new C();
//		C c= new C();
//		c.show();
		Runnable d= new D();
		//as we don't have start method in runnable interface we need to created thread class and pass those objects.
		Thread t1= new Thread(c);
		Thread t2= new Thread(d);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		//If there are any methods other than run method then we need to call those methods explicitly.
		
		/*Creating threads using runnable interface is preferred because, if we are creating thread for any class suppose A, if that class is inherited from parents class that is not possible because it will be multilevel inheritance.
		 * so using runnable is preferred.*/
		
		
		//Threads and mutation
		/*Thread safe is nothing but, if one variable is using in multiple threads . we can't get accurate results. That can be achieved by using synchronized keyword. */
		
		Runnable r1=() ->{
			for(int i=0; i<100;i++)
			{
				Counter.increment();
			}
		};
		
		Runnable r2=() ->{
			for(int i=0; i<100;i++)
			{
				Counter.increment();
			}
		};
		
		Thread t3= new Thread(r1);
		Thread t4=new Thread(r2);
		t3.start();
		t4.start();
		//Join method throws checked exception called Interrupted exception.join method will wait for a thread to die.
		t3.join();
		t4.join();
		//even after using join also we will not get exact value.
		//so to avoid this racing means only one thread can be use that variable at a time. This can be achieved by synchronization keyword.
		//after using synchronized keyword we will get exact value.
		System.out.println(Counter.c);//The output should be 200. but we will not get the exact value.To get exact value use join method on both threads.
		
		E e = new E();
		e.start();
		
		Runnable r= new F();
		Thread tr= new Thread(r);
		tr.start();
	}

}
