package com.collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TestAllCollectorsMethods {

	public static List<Student> allStudent(){
		List<Student> studentList = new ArrayList<Student>();
        
		studentList.add(new Student("Paul", 11, "Economics", 78.9));
		studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
		studentList.add(new Student("Harish", 13, "History", 83.7));
		studentList.add(new Student("Xiano", 14, "Literature", 71.5));
		studentList.add(new Student("Soumya", 15, "Economics", 77.5));
		studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
		studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
		studentList.add(new Student("Mitshu", 18, "History", 73.5));
		studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
		studentList.add(new Student("Harry", 20, "History", 71.9));
		return studentList;
	}
	public static void main(String[] args) {
		
		System.out.println(getNewListObject(allStudent()));
		System.out.println(getAllSubjects(allStudent()));
		System.out.println(getNameAndPersentage(allStudent()));
		System.out.println(getSpecificStudents(allStudent()));
		System.out.println(getNamesOfAllStudents(allStudent()));
		System.out.println(countStudents(allStudent()));
		System.out.println(findMaxPercentage(allStudent()));
		System.out.println(findMinPercentage(allStudent()));
		
	}
	
	//Collectors.toList() :It returns a Collector which collects all input elements into a new List.
	public static List<Student> getNewListObject(List<Student> list){
		List<Student> collect = list.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).collect(Collectors.toList());
		return collect;
	}
	
	//Collectors.toSet() :It returns a Collector which collects all input elements into a new Set.
	//to find all subject
	public static Set<String> getAllSubjects(List<Student> list){
		Set<String> collect = list.stream().map(Student::getSubject).collect(Collectors.toSet());
		return collect;
	}
	
	//Collectors.toMap() :This method returns a Collector which collects input elements into a Map whose keys and values are the result of applying mapping functions to input elements.
	//collecting name and persentage of each student into a map
	public static  Map<String, Double> getNameAndPersentage(List<Student> list){
		return list.stream().collect(Collectors.toMap(Student::getName, Student::getPercentage));
		
	}
	
	//Collectors.toCollection() :This method returns a Collector which collects all input elements into a new Collection.
	//Collecting first 3 students into LinkedList
	public static LinkedList<Student>  getSpecificStudents(List<Student> list){
		LinkedList<Student> studentLinkedList = list.stream().limit(3).collect(Collectors.toCollection(LinkedList::new));
		return studentLinkedList;		
		
	}
	
	//Collectors.joining() :This method returns a Collector which concatenates input elements separated by the specified delimiter.
	//Collecting the names of all students joined as a string
	public static String getNamesOfAllStudents(List<Student> list) {
		String collect = list.stream().map(Student::getName).collect(Collectors.joining(","));
		return collect;
	}
	
	//Collectors.counting() :It returns a Collector that counts number of input elements.
	//Counting number of students
	public static long countStudents(List<Student> list) {
		long count = list.stream().collect(Collectors.counting());//.count(); we can use this also
		return count;
	}
	
	//Collectors.maxBy() :This method returns a Collector that collects largest element in a stream according to supplied Comparator.
	//Collecting highest percentage.
	public static Double  findMaxPercentage(List<Student> list) {
		Optional<Double> collect = list.stream().map(Student::getPercentage).collect(Collectors.maxBy(Comparator.naturalOrder()));
		return collect.get();
	}
	
	//Collectors.minBy() :This method returns a Collector which collects smallest element in a stream according to supplied Comparator.
	//Collecting lowest percentage.
	public static Double findMinPercentage(List<Student> list) {
		return list.stream().map(Student::getPercentage).collect(Collectors.minBy(Comparator.naturalOrder())).get();
	}
	
	//summingInt(), summingLong(), summingDouble(): These methods returns a Collector which collects sum of all input elements.
	// Collecting sum of percentages
	public static Double findSumOfPercentage(List<Student> list) {
		Double sumOfPercentages = list.stream().collect(Collectors.summingDouble(Student::getPercentage));
		return sumOfPercentages;
		 
	}
	
	
	
	

}
