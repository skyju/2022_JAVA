package day0720;

public class Solution_사용자객체생성 {
	public static void main(String[] args) {
		// 기본 생성자를 통해 사용자 객체 생성
		User user1 = new User();
		user1.id = "user1";
		user1.password = "user1";
		user1.name = "김싸피";
		user1.email = "ssafy1@ssafy.com";
		user1.age = 27;

		// 객체 생성과 동시에 멤버 변수를 초기화 하는 생성자 호출
		User user2 = new User("user2", "user2", "박싸피", "ssafy1@ssafy.com", 28);

		System.out.println(user1.name);
		System.out.println(user2.name);

	}
}

class User {
	String id;
	String password;
	String name;
	String email;
	int age;

	public User() {
	}

	public User(String id, String password, String name, String email, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}

}
