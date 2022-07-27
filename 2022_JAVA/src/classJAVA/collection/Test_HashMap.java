package classJAVA.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author SSAFY
 * 
 * Hashing : 검색 빠르게.. -> 정렬이 한번만 필요하면 OK
 * Tree : 정렬된 상태.. -> 중간중간 여러번 정렬해야 한다면...
 * + sorted ..
 * 
 *         Set은 중복 넣지 않음 <-> Map은 key가 같으면 덮어씀(수정)
 *         Key로 내가 만든 class를 넣으면 꼭 hashCode와 equals를 구현해놔야함
 *         구현하지 않는다면 중복제거를 못한다. (에러는 아님)
 */
public class Test_HashMap {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("배", 4000);
		hm.put("바나나", 3000);
		hm.put("사과", 3500);
		hm.put("귤", 3000);

		System.out.println(hm);
		System.out.println(hm.size());
		System.out.println(hm.toString());

		// Iterator 가능하게
		Set<Entry<String, Integer>> s = hm.entrySet();
		for (Entry<String, Integer> entry : s) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}

		// key만 가져오기
		Set<String> ss = hm.keySet();
		for (String str : ss) {
			System.out.println(str + ", " + hm.get(str));
		}

		// Value만 가져오기
		Collection<Integer> c = hm.values();
		System.out.println(c);

		// entry로 받아서 list로 만든 후, value기준 정렬하기
		List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());
		System.out.println(list);

		list.sort(Entry.comparingByValue());
		System.out.println(list);
		
		
		System.out.println("==========================");
		// Cup을 Key로 써보기
		HashMap<Cup, Integer> ch = new HashMap<>();
		ch.put(new Cup("본차이나"), 2000);
		ch.put(new Cup("에르메스"), 300000);
		ch.put(new Cup("르꾸르제"), 50000);
		ch.put(new Cup("르꾸르제"), 60000); // 나중에 추가한 것으로 덮어쓴다.
		
		System.out.println(ch);
		
		System.out.println("[방법1] ==========================");
		// 르꾸르제 가격 60000원 모양대로 출력하기!
		
		// 방법 1
		// entry 전체를 list로 만들어서 for문 돌리기!
		List<Map.Entry<Cup, Integer>> lst = new ArrayList<>(ch.entrySet());
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i).getKey() + " 가격 " + lst.get(i).getValue() + "원");
		}
		
		System.out.println("[방법2] ==========================");
		
		// 방법2
		// key만 set으로 만들어서 iterator 돌리기~
		Set<Cup> chs = ch.keySet();
		Iterator<Cup> iter = chs.iterator();
		while(iter.hasNext()) {
			Cup tmp = iter.next();
			System.out.println(tmp.name + " 가격 " + ch.get(tmp) + "원");
		}
		
		System.out.println("[방법3] ==========================");
		// 방법3
		Set<Entry<Cup, Integer>> chSet = ch.entrySet();
		Iterator<Entry<Cup, Integer>> iter2 = chSet.iterator();
		while(iter2.hasNext()) {
			Entry<Cup, Integer> tmp = iter2.next();
			System.out.println(tmp.getKey().name + " 가격 " + tmp.getValue() + "원");
		}
		
		System.out.println("==========================");
		Cup cup = new Cup("테스트");
		ch.put(cup, 1000);
		
		System.out.println(ch);
		System.out.println(ch.get(cup));
		System.out.println(ch.get(new Cup("테스트")));
		
		// Map에 들어간 객체를 변경하면.. 해쉬코드 값에 의한 써칭이 안되므로 더 이상 찾을 수 없게 됨..
		// 여전히 iter로는 찾을 수 있지만!!..
		cup.name = "테스팅";
		System.out.println(ch);
		System.out.println(ch.get(cup));
		System.out.println(ch.get(new Cup("테스트")));
		System.out.println(ch.get(new Cup("테스팅")));
		
		// 심지어 또들어감ㅋㅋ
		ch.put(cup, 2000);
		System.out.println(ch);
		
	}
}

class Cup {
	String name;

	public Cup() {
	}

	public Cup(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cup other = (Cup) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return name;
	}
}