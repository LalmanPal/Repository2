package com.pal.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestFilter {

	public static void main(String[] args) {
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(10);
		l.add(12);
		l.add(5);
		l.add(0);
		l.add(8);
		l.add(7);
		//find even values			
		List<Integer> collect = l.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(collect);		
		
		//if we want to add 5 in every values
		List<Integer> collect2 = l.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println(collect2);
		
		//if we want to add 5 only in even number
		List<Integer> collect3 = l.stream().filter(i->i%2==0).map(i->i+5).collect(Collectors.toList());
		System.out.println(collect3);
		
		
		//
		
		
		

	}

}
