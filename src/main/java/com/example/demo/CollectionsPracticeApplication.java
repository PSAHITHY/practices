package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectionsPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionsPracticeApplication.class, args);
		Details d = new Details(2);
		Details d1 = new Details("abc");
		Details.getNumber();
		d.getInteger();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(11);
		l1.add(1);
		l1.add(5);
		l1.add(20);
		l1.stream().sorted().forEach(System.out::println);
		Optional<Integer> result = l1.stream().max(Integer::compare);
		System.out.println(result.get());
		//using Comparator.reverseOrder() gives descending order for primitive data types.
		System.out.println("priniting numbers in descending order");
 		l1.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		Employee e1 = new Employee(1, "abc", 25000);
		Employee e2 = new Employee(2, "efg", 30000);
		Employee e3 = new Employee(3, "hij", 45000);
		Employee e4 = new Employee(4, "lmn", 10000);
		Employee e5 = new Employee(5, "sahithya", 30500);
		Employee e6 = new Employee(6, "Renuka", 30500);
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		employeeList.add(e6);
		
		// get all the employees whose salary is greater than 25,000
		System.out.println("Employee's whose salary is greater than 25,000");
		List<Employee> rl1 = employeeList.stream().filter(x -> x.getEmployee_salary() > 25000)
				.collect(Collectors.toList());
		employeeList.stream().filter(x->x.getEmployee_salary()>25000).forEach(System.out::println);//this line will print employees object address because toString method has not overridden.
		for (Employee i : rl1) {
			System.out.println(i.getEmployee_id() + " " + i.employee_name + " " + i.employee_salary);
		}
		rl1.forEach(x -> System.out.println(x.employee_id + " " + x.employee_name + " " + x.employee_salary));
		System.out.println("Sort employee based on their salary");

		// sort the employee based on their salary
		List<Employee> rl2 = employeeList.stream().sorted((x1, x2) -> x1.getEmployee_salary() - x2.getEmployee_salary())
				.collect(Collectors.toList());
		rl2.forEach(x -> System.out.println(x.employee_id + " " + x.employee_name + " " + x.employee_salary));
		System.out.println("Employee minimum salary");
		Employee employee = employeeList.stream().sorted((x1, x2) -> x1.getEmployee_salary() - x2.getEmployee_salary())
				.findFirst().get();

		System.out.println(employee.getEmployee_id() + " " + employee.employee_name + " " + employee.employee_salary);
		System.out.println("employee with maximum salary");
		Employee maxe1 = employeeList.stream()
				.max((x1, x2) -> Integer.compare(x1.getEmployee_salary(), x2.getEmployee_salary())).get();
		System.out.println(maxe1.employee_name + " " + maxe1.employee_salary + " " + maxe1.getEmployee_id());

		// average salary of all employees.
		System.out.println("avg salary of all employees");
		double avg = employeeList.stream().collect(Collectors.averagingInt(x -> x.getEmployee_salary()));
		System.out.println(avg);

		// sorting the employee based on their name
		System.out.println("sorting employees based on their names");
		List<Employee> sortedResult = employeeList.stream()
				.sorted((x1, x2) -> x1.getEmployee_name().compareTo(x2.getEmployee_name()))
				.collect(Collectors.toList());
		sortedResult.forEach(x -> System.out.println(x.getEmployee_name() + " " + x.getEmployee_salary()));
		// getting the employee details whose name length is greater
		System.out.println("Employee details with maximum length of name");
		Employee maxe2 = employeeList.stream()
				.max((x1, x2) -> Integer.compare(x1.getEmployee_name().length(), x2.getEmployee_name().length())).get();
		System.out.println(maxe2.getEmployee_name());

		// sorting the employee based on salary in descending order
		System.out.println("Sorting the employees based on salary in descending order");
		List<Employee> resultList = employeeList.stream()
				.sorted((x1, x2) -> x2.getEmployee_salary() - x1.getEmployee_salary()).collect(Collectors.toList());
		resultList.forEach(x -> System.out
				.println(x.getEmployee_id() + " " + x.getEmployee_name() + " " + x.getEmployee_salary()));

		// sorting the list permanently using comparator interface
		Collections.sort(employeeList, new SortByNameAndSalary());
		for (Employee e : employeeList) {
			System.out.println(e.getEmployee_salary() + " " + e.getEmployee_name());
		}

		Comparator<Employee> c = (er1, er2) -> {
			int n = 0;
			if (er1.getEmployee_salary() < er2.getEmployee_salary()) {
				n = 1;
			}
			if (er1.getEmployee_salary() > er2.getEmployee_salary()) {
				n = -1;
			}
			if (er1.getEmployee_salary() == er2.getEmployee_salary()) {
				n = er1.getEmployee_id() < er2.getEmployee_id() ? -1 : 1;
			}
			return n;
		};
		Collections.sort(employeeList, c);
		for (Employee e : employeeList) {
			System.out.println(e.getEmployee_id() + " " + e.getEmployee_salary() + " " + e.getEmployee_name());
		}

		// using TreeSet
		// as TreeSet will sort the objects in ascending order. as we have user
		// defined objects we need to implement that class with comparable interface.
		// if we are not implementing comparable interface we will get an exception
		// called ClassCastException which is a runtime exception.
		// as p5 and p6 contains same values only one object will be considered as because it doen't allow duplicates.
		Products p1 = new Products(2, "mobile", 80000);
		Products p2 = new Products(1, "watch", 800);
		Products p3 = new Products(10, "head set", 1000);
		Products p4 = new Products(4, "mobile", 8000);
		Products p5 = new Products(12, "charger", 500);
		Products p6 = new Products(12, "charger", 500);
		Products p7 = new Products(9, "cable", 300);
		TreeSet<Products> treeset = new TreeSet<Products>();
		treeset.add(p1);
		treeset.add(p2);
		treeset.add(p3);
		treeset.add(p4);
		treeset.add(p5);
		treeset.add(p6);
		treeset.add(p7);

		Iterator<Products> i = treeset.iterator();
		System.out.println("using iterator");
		while (i.hasNext()) {
			Products p = i.next();
			System.out.println(p.getProductId() + " " + p.getProductName() + " " + p.getProductPrice());
		}
		System.out.println("using for each");
		treeset.forEach(
				p -> System.out.println(p.getProductId() + " " + p.getProductName() + " " + p.getProductPrice()));

		System.out.println("in descending order");
		Iterator<Products> itr = treeset.descendingIterator();
		while (itr.hasNext()) {
			Products p = itr.next();
			System.out.println(p.getProductId() + " " + p.getProductName() + " " + p.getProductPrice());
		}
		//products greater than 1000
		System.out.println("products price greater than 1000");
		treeset.stream().filter(x -> x.getProductPrice()>=1000).forEach(System.out::println);
		// sum of all employee salaries.
		Optional<Integer> sum = employeeList.stream().map(x -> x.getEmployee_salary()).reduce((x1, x2) -> x1 + x2);
		System.out.println(sum.get());
		// using method reference.
		int sum1 = employeeList.stream().collect(Collectors.summingInt(Employee::getEmployee_salary));
		System.out.println(sum1);

		// toString is overridden in Products. then we can fetch that directly using
		// below
		for (Products p : treeset) {
			System.out.println(p);
		}

		//HashMap, TreeMap and HashTable
		
		//HashMap
		//only one null is allowed in keys and multiple nulls are allowed in values.
		//It doesn't maintain any order.
		HashMap<Integer, String> hm= new HashMap<>();
		hm.put(2,"abc");
		hm.put(null, null);
		hm.put(4, "efg");
		hm.put(5, null);
		hm.put(1, "xyz");
		hm.put(100, "mno");
		System.out.println(hm);
		for(Map.Entry<Integer, String> m: hm.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		hm.putIfAbsent(200, "pqrs");
		hm.size();
		hm.remove(5);
		System.out.println(hm.get(200));
		System.out.println(hm);
		
		//TreeMap
		//nulls are not allowed in keys but multiple nulls are allowed in values.
		TreeMap<Integer, Products> tm= new TreeMap<>();
		tm.put(8, null);
		tm.put(6, p1);
		tm.put(1, p2);
		tm.put(5, p3);
		tm.put(2, p4);
		tm.put(7, p5);
		tm.put(4, p6);
		tm.put(3, p7);
//		tm.put(null, p7);// this line will throw null pointer exceptions because nulls are not allowed in keys.
		for(Map.Entry<Integer, Products> m: tm.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		System.out.println(tm.getOrDefault(10, null));
		System.out.println(tm.getOrDefault(2, null));
		System.out.println(tm);
		
		
		//HashTable
		//nulls are not allowed in keys and values.
		Hashtable<Integer, Employee> ht= new Hashtable<>();
		ht.put(6, e1);
		ht.put(1, e2);
		ht.put(5, e3);
		ht.putIfAbsent(100, e2);
		ht.put(3, e4);
		ht.putIfAbsent(4,e5);
		ht.put(2, e6);
		ht.put(200, e1);
		System.out.println(ht);
		for(Map.Entry<Integer, Employee> m: ht.entrySet())
		{
			Employee e= m.getValue();
			System.out.println(m.getKey()+" "+ e.getEmployee_id()+" "+e.getEmployee_name()+" "+e.getEmployee_salary());
		}
	}

}
