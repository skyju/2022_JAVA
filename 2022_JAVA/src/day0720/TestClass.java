package day0720;

import java.util.Arrays;

/**
 * 
 * @author SSAFY
 * 
 *         클래스 구성요소 : 변수, 메서드, 생성자, 초기화 블럭, 또 다른 클래스
 * 
 *         naming rule class name : First character is must be UPPERCASE.
 *         Constructor : of course .. must be UPPERCASE(). variable name : //
 *         lower case. method name : // lower case().
 *
 *         "if" switch~case "for" "while" do~while method, class ""쳐진 것은 {} 생략
 *         가능
 */
public class TestClass {
	
	int x;
	public TestClass(int x) {
		this.x = x;
	}
	
	public static void main(String[] args) {
		a(3);

		//TestClass tc = new TestClass();
		
		int a = 1;
		System.out.println("main 시작");
		b(a);
		System.out.println("main 종료");
	}

	private static void b(int a) {
		int x = 2;
		System.out.println("b 시작");
		c(a + x);
		System.out.println("b 종료");
	}

	private static void c(int x) {
		int y = 3;
		System.out.println("c 시작");
		System.out.println(x + y);
		System.out.println("c 종료");
	}

	private static void a(int... i) {
		// 내부적으로 매개변수 i는 배열이다.
		// ...표현은 가변배열로 method의 매개변수에만 사용할 수 있다.
		System.out.println(Arrays.toString(i));
	}
}

class ABC {
	int a;
	int b;

	class X {

	}

	// 초기화 블럭
	{

	}

	static {

	}

	void ppp() {
	}
}
