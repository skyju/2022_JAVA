package day0722;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author SSAFY
 *
 * 모든 클래스는 반드시 하나 이상의 생성자를 선언해야 한다.
 * 생성자를 하나도 만들지 않으면, 컴파일러가 자동으로 기본생성자를 호출해준다.
 * 모든 생성자는 첫번째 줄에 다른 생성자를 호출해야한다.
 * 생성자에 다른 생성자 호출코드를 작성하지 않으면, 컴파일러가 super()를 호출해준다.
 *
 */
public class Test_Debug {
	
	static int staticVar = 100;
	int var = 200;
	
	public static void main(String[] args) throws FileNotFoundException {
		int a = -3 % 2; // -1
		// 수학에서의 나머지 r, 0 <= r < 피제수2
		// 내부적 구현 : -3 - ( -3 / 2 ) * 2
		// 내부적으로 오래걸리는 연산
		// ++ --, + -, *, /, %  순으로 느려짐
		// 비트마스킹 개빠름
		System.out.println(a);
		
		
		int localvar = 300;
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input.txt"));
		int[][] b = new int[5][5];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				b[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0 ; i < b.length; i++) {
			System.out.println(Arrays.toString(b[i]));
		}
		
	}
}

class Parent {
	int money = 1000000;

	public Parent() {
	}

	public Parent(int money) {
		this.money = money;
	}
}

class Child extends Parent {

}
