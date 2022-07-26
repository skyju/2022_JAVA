package day0722;

import java.util.Arrays;

public class UserTest {

	public static void main(String[] args) {
				
		User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김싸피");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);

		User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);
		VipUser vuser = new VipUser("vip1", "vip1", "김싸피" , "ssafy3@ssafy.com", 29, "Gold", 300);
		
		UserManagerImpl um = UserManagerImpl.getInstance();
		UserManagerImpl um2 = UserManagerImpl.getInstance();
		
		um.add(user1);
		um.add(user2);
		um.add(vuser);
		
		// "김" 이라는 단어를 이름에 포함하는 사용자 검색 결과 toString 으로 출력
		System.out.println("김씨 성 가진 유저 리스트-------");
		System.out.println(Arrays.toString(um.searchByName("김")));
		
		// 일반 사용자 리스트만 가져와서 toString 으로 출력
		System.out.println("일반 사용자 리스트-------");
		System.out.println(Arrays.toString(um.getUsers()));
		
		// 사용자들의 평균 나이 출력
		System.out.println("사용자 평균 나이 출력-------");
		System.out.println(um.getAgeAvg());
		
		
		// vip 리스트만 가져오기
		System.out.println("vip 유저 리스트-------");
		System.out.println(Arrays.toString(um.getVipUsers()));
		
		// UserManager 2개가 같은 인스턴스를 참조하는지 검사
		System.out.println(um.equals(um2));
	
	}

}
