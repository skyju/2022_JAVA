package day0719;

public class Test_String {
	public static void main(String[] args) {
		String s3 = "abcDeFgHij";

		System.out.println(s3);
		System.out.println("길이 :" + s3.length());
		System.out.println("0번째 위치의 글자 :" + s3.charAt(0));
		System.out.println("대문자 변환 :" + s3.toUpperCase());
		System.out.println("소문자 변환 :" + s3.toLowerCase());
		System.out.println("부분 문자열 추출 :" + s3.substring(3, 7));
		System.out.println("포함 여부 :" + s3.contains("DeF"));
		System.out.println("끝부분 맞는지 :" + s3.endsWith(".txt"));
		System.out.println("이어 붙임 :" + s3.concat("xyz"));
		System.out.println("문자열 대체 :" + s3.replace("cD", "Cd"));
		System.out.println("문자가 발견된 위치 :" + s3.indexOf('F'));
		System.out.println("      a  b c     d e  f     ".trim());
		// trim은 앞뒤만 제거

		String s4 = new String("hello"); // 객체 생성 기본 방법
		String s5 = "hello";

		// 이렇게 비교하면 안됨 왜? 주소를 비교함
		System.out.println(s4 == s5);

		// 이렇게 비교해야함
		System.out.println(s4.equals(s5));
		
		// 대소문자 무시
		String s6 = "HELLO";
		System.out.println(s4.equalsIgnoreCase(s6));
	}
}
