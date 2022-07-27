package classJAVA.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test_LinkedList {
	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();

		ll.add(9);
		ll.addFirst(8);
		ll.addLast(10);

		System.out.println(ll.toString());

		System.out.println("==== 그냥 get ====");
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i)); // 접근 속도가 아주 느리다.
		}

		System.out.println("==== iterator ====");
		// c로 따지면 ->로 접근, next는 단방향으로 감
		// 순차적으로 읽을때는 빠름, 여기저기 읽을때는 안되지만
		Iterator<Integer> iter = ll.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("==== 양방향으로 ListIter ====");
		ListIterator<Integer> lIter = ll.listIterator();
		System.out.print(lIter.next() + ", ");
		System.out.print(lIter.next() + ", ");
		System.out.print(lIter.next() + ", ");
		System.out.print(lIter.previous() + ", ");
		System.out.print(lIter.previous() + ", ");
		System.out.println(lIter.previous());

	}
}
