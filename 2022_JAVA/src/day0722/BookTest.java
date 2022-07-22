package day0722;

import java.util.Arrays;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		Book book3 = new Book("21426", "이싸피의 자바 마스터하는 법", "이싸피", "싸피출판", 17000, "Java 기본 문법");
		Book book4 = new Book("21427", "자바로 최고되는 법", "김뭐뭐", "짱짱출판", 18000, "Java 응용");
		
		BookManager manage = BookManager.getInstance();
		manage.add(new Book("21424", "김싸피의 싸피생활", "김싸피", "싸피출판", 20000, "생활 정보"));
		manage.add(new Book("21425", "박싸피의 싸피꿀팁", "박싸피", "싸피출판", 12000, "생활 정보"));
		manage.add(new Book("11421", "오늘 점심 만두육개장", "점박사", "점심출판", 15000, "음식"));
		manage.add(book3);
		manage.add(book4);
		System.out.println("******도서 목록******");
		System.out.println(Arrays.toString(manage.getList()));
		
		BookManager manage2 = BookManager.getInstance();
		System.out.println("******싱글톤 테스트******"); //같은 객체를 공유
		System.out.println(Arrays.toString(manage2.getList()));
		
		System.out.println("******도서 조회: 21425******");
		System.out.println(manage.searchByIsbn("21425").toString());
		
		System.out.println("******도서 삭제: 21425******");
		manage.remove("21425");
		
		System.out.println("******도서 목록******");
		System.out.println(Arrays.toString(manage.getList()));
		
		System.out.println("******21428, 21429 매거진 도서 추가******");
		manage.add(new Magazine("21428", "점심밥 맛있게 먹는 법", "먹싸피", "맛밥출판", 17000, "음식", 2022, 7));
		manage.add(new Magazine("21429", "오늘 점심 메밀소바임", "김오늘", "밥매거진", 21000, "음식", 2022, 8));
		
		System.out.println("******도서 목록******");
		System.out.println(Arrays.toString(manage.getList()));
		
		System.out.println("******점심이 포함된 도서 목록 조회******");
		System.out.println(Arrays.toString(manage.searchByTitle("점심")));
		
		System.out.println("******매거진 목록 조회******");
		System.out.println(Arrays.toString(manage.getMagazines()));
		
		System.out.println("******일반도서 목록 조회******");
		System.out.println(Arrays.toString(manage.getBooks()));
		
		System.out.println("******도서 가격 총합******");
		System.out.println(manage.getTotalPrice());
		
		System.out.println("******도서 평균가******");
		System.out.println(manage.getPriceAvg());
	}
}
