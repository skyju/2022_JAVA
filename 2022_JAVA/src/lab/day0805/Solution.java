package com.ssafy.corona.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		
//		1 2
//		5 2
//		6 1
//		3 4
//		5 3

		// 배열에 저장하고 정렬하고 싶음
		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] {1, 2});
		list.add(new int[] {5, 2});
		list.add(new int[] {6, 1});
		list.add(new int[] {3, 4});
		list.add(new int[] {5, 3});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o2[0] - o1[0];
				return o1[1] - o2[1];
			}
		});
		
		System.out.println("====================");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
		
	}
}
