package classJAVA;

import java.util.Scanner;

public class Test_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드로부터 사용자 입력을 받을 객체 준비

//		//1. 기본형 타입계열
//		//	데이터가 나오기 전의 white space를 모두 제거 후 data를 가져감
//		//
//		sc.next(); //String
//		sc.nextInt();
//		sc.nextBoolean();
//		
//		//2. line입력
//		//	줄바꿈이 나올떄까지 데이터를 가져감 (줄바꿈은 삭제)
//		sc.nextLine();

		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		System.out.println("당신의 나이는 " + age + "살 입니다.");
		System.out.println("이름을 알려주세요.");
		String name = sc.nextLine();
		System.out.println("당신의 이름은 " + name + "입니다.");
		
		sc.close();
	}
}
