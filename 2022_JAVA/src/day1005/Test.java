package day1005;

import java.util.ArrayList;
import java.util.List;

public class Test {
	static class Node {
		int r, c, s, d, z;

		public Node(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (z != other.z)
				return false;
			return true;
		}
	}
	public static void main(String[] args) {
		List<Node> list = new ArrayList<Node>();
		List<Integer> list2 = new ArrayList<>();
		
		list.add(new Node(0,0,0,0,0));
		list.add(new Node(0,0,0,0,0));
		list.add(new Node(0,0,0,0,0));
		
		list2.add(0);
		list2.add(0);
		list2.add(0);
		list2.add(0);
		
		Node node = list.get(0);
		node.c = 23;
		Integer n = list2.get(0);
		n = 23;
		
		System.out.println(list.get(0).c);
		System.out.println(list2.get(0));
		System.out.println(n);
		
		System.out.println((int)'a');
		System.out.println((int)'A');
		System.out.println((char)('f' - 32));
	}
}
