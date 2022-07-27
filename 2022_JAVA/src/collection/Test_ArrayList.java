package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test_ArrayList {
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("3");
		al.add("hi");
		al.add("dog");
		al.add("cat");
		
		System.out.println(al.get(0));
		System.out.println(al.get(1));
		System.out.println(al.get(2));
		System.out.println(al.get(3));
		
		//ArrayOutOfBoundsException이 아니라
		//IndexOutOfBoundsException이 발생
		//System.out.println(al.get(4));
		
		System.out.println(al.toString());
		al.add(2, "rabbit");
		System.out.println(al.toString());
		
		ArrayList<String> x = new ArrayList<String>();
		x.add("3");
		x.add("4");
		x.add("5");
		al.addAll(x);
		System.out.println(al);
		
		System.out.println(al.indexOf("3"));
		
		Iterator<String> iter = al.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
//		Object[] obj = al.toArray();
//		System.out.println(Arrays.toString(obj));
		
		String[] srr = new String[al.size()];
		al.toArray(srr);
		System.out.println(Arrays.toString(srr));
		
		System.out.println(al.subList(0, 4));
		
	}
}
