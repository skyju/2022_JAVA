package classJAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Test_Sort {
	public static void main(String[] args) {

		int[] arr = { 4, 9, 2, 5, 1, 8, 7, 6, 3, 0 };

		System.out.println(Arrays.toString(arr));

		// 가장 빠름!!
		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(9);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(3);
		list.add(0);

//		list.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1 - o2;
//			}
//		});
		
		// method가 하나인 경우!!
		// 매개변수 1개면 ()도 생략가능
		list.sort((o1, o2) -> {return o1 - o2;}); // 람다 표현식
		System.out.println(list);

		List<Integer> li = new ArrayList<Integer>();
		li.add(4);
		li.add(9);
		li.add(2);
		li.add(5);
		li.add(1);
		li.add(8);
		li.add(7);
		li.add(6);
		li.add(3);
		li.add(0);
		System.out.println(li);
		Collections.sort(li);
		System.out.println(li);

		List<Bus> busList = new ArrayList<>();
		busList.add(new Bus(27));
		busList.add(new Bus(56));
		busList.add(new Bus(33));
		busList.add(new Bus(9));
		busList.add(new Bus(100));

//		System.out.println(busList);
//		Collections.sort(busList);
//		System.out.println(busList);

		HashMap<Bus, Integer> hm = new HashMap<>();
		hm.put(new Bus(30), 100);
		hm.put(new Bus(70), 900);
		hm.put(new Bus(10), 300);
		hm.put(new Bus(50), 500);
		hm.put(new Bus(20), 500);

		// Key 기준 정렬
		Set<Entry<Bus, Integer>> se = hm.entrySet();
		ArrayList<Entry<Bus, Integer>> all = new ArrayList<>(se);
		Collections.sort(all, new Comparator<Entry<Bus, Integer>>() {
			@Override
			public int compare(Entry<Bus, Integer> o1, Entry<Bus, Integer> o2) {
				return o1.getKey().num - o2.getKey().num;
			}
		});
		
		
		for (int i = 0; i < all.size(); i++) {
			System.out.println(all.get(i).getKey() + " : " + all.get(i).getValue());
		}
		
		// Arrays.asList!
		List<String> names = Arrays.asList("손흥민", "류현진", "김연아", "김연경");
		System.out.println(names);



	}// end of main
}// end of class

class Bus implements Comparable<Bus> {
	int num;

	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public Bus(int num) {
		super();
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int compareTo(Bus o) {
		return this.num - o.num;
	}

	@Override
	public String toString() {
		return num + "";
	}

}