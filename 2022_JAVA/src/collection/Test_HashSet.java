package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author SSAFY
 *
 *         hashing 기법으로 데이터의 중복을 체크한다. 
 *         => hashCode(), equals() 두 method를 overriding 해야 함.
 */
public class Test_HashSet {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();

		set.add(10);
		set.add(20);
		set.add(8);
		set.add(1);
		set.add(9);
		set.add(9);

		System.out.println(set);

		Set<MyCar> s = new HashSet<>();
		MyCar mc = new MyCar(1008);
		s.add(new MyCar(1004));
		s.add(new MyCar(1234));
		s.add(new MyCar(500));
		s.add(new MyCar(1004));
		s.add(mc);
		s.add(mc);

		System.out.println(s);

		// set이 equals로 비교하기 때문에 같은 내용물을 가진 객체를 두번 넣어도 들어감
		// 내가 만든 객체에서 중복을 잘 잡으려면??
		// 두 method를 오버라이딩 해야!

	} // end of main
} // end of class

class MyCar {
	int number;

	public MyCar() {
	}

	public MyCar(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "[" + number + "]";
	}

//	@Override
//	public int hashCode() {
//		return number;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof MyCar))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		MyCar mc = (MyCar) obj;
//		if (number != mc.number)
//			return false;
//		return true;
//	}

}