package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 
 * @author SSAFY
 *
 *         TreeSet 내부적으로 항상 정렬된 상태 유지 입력 시마다 정렬된 상태를 유지해야 하는 경우 부분 정렬된 집합을 꺼내야
 *         하는 경우
 * 
 *         내부 비교기 : Comparable Comparable Interface 구현, compareTo(YourCar o)
 *         method overriding
 * 
 *         외부 비교기 : Comparator Comparator Interface 사용, compare(YourCar a,
 *         YourCar b) method overriding
 * 
 *         우선 순위는 외부 > 내부
 */

public class Test_TreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();

		ts.add(new Integer(4));
		ts.add(2); // AutoBoxing
		ts.add(6);
		ts.add(1);
		ts.add(3);
		ts.add(7);

		System.out.println(ts);
		System.out.println(ts.ceiling(5)); // 해당 값과 가장 가까운 값
		ts.containsAll(new ArrayList<Integer>()); // 매개변수로 포함된 리스트가 다 포함되어잇으면 true
		System.out.println(ts.subSet(2, 7));

		System.out.println("=============================");
		TreeSet<YourCar> set = new TreeSet<>();
		set.add(new YourCar(3000, "박박박"));
		set.add(new YourCar(9999, "이싸피"));
		set.add(new YourCar(8080, "김가네"));
		set.add(new YourCar(2316, "최고집"));
		set.add(new YourCar(1317, "최고집"));

		TreeSet<YourCar> set2 = new TreeSet<YourCar>(new Comparator<YourCar>() {

			@Override
			public int compare(YourCar o1, YourCar o2) {
				if (o1.name.equals(o2.name)) { // 이름이 같으면
					return o1.compareTo(o2);
				} else
					return o1.name.compareTo(o2.name);
			}
		});
		set2.add(new YourCar(3000, "박박박"));
		set2.add(new YourCar(9999, "이싸피"));
		set2.add(new YourCar(8080, "김가네"));
		set2.add(new YourCar(2316, "최고집"));
		set2.add(new YourCar(1317, "최고집"));

		System.out.println(set);
		System.out.println(set2);

	} // end of main

} // end of class

class YourCar implements Comparable<YourCar> {
	int number;
	String name;

	public YourCar() {
	}

	public YourCar(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[number=" + number + ", name=" + name + "]";
	}

	@Override
	public int compareTo(YourCar o) {
		// 내꺼 - 니꺼 : 오름차순
		return this.number - o.number;
	}

}