package com.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Stream.collect() Method=>  it returns mutable result container such as List, Set or Map according to supplied Collector.
public class CollectorsTest {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(2,4,5,6,3,9,8,7);
		
		// Stream.collect() Method=>  it returns mutable result container such as List, Set or Map according to supplied Collector.
		List<Integer> list1=list.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(list1);
		
		

	}

}
