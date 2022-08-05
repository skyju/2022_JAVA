package com.ssafy.corona.app;

import java.util.*;

import com.ssafy.corona.book.Book;
import com.ssafy.corona.book.BookManagerImpl;
import com.ssafy.corona.virus.*;

public class MainTest {
	public static void main(String[] args) {

		// navigation 단축키
		// F3 : 변수, 메서드, 클래스 정의한 코드로 화면 이동 (ctrl + click)
		// alt + <-, -> : 이전화면, 이후화면

		// 10.질병관리 문제 //
		//
		// 아래 11~13번 주석을 해제하여
		// "정상 출력 예" 와 같이 출력될 수 있도록
		// 코드들을 디버깅 하세요!
		//
		System.out.println("10.질병관리(코로나,메르스) =================================");
		VirusMgr vmgr = new VirusMgrImpl();
		System.out.println();

		// <- 주석 해제 후 작성 : start ////////////////////////////////
		System.out.println("11.코로나19 등록");
		// 정상 출력 예:
		// 11.코로나19 등록
		// 코로나19: 등록된 바이러스입니다.
		try {
			vmgr.add(new Mers("메르스15", 2, 1.5));
			vmgr.add(new Corona("코로나19", 3, 2));
			vmgr.add(new Corona("코로나19", 2, 2));
		} catch (DuplicatedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("12.바이러스 전체검색");
		// 정상 출력 예:
		// 12.바이러스 전체검색
		// 메르스15 2 1.5
		// 코로나19 3 2
		Virus[] virus = vmgr.search();
		for (Virus v : virus) {
			System.out.println(v);
		}
		System.out.println();

		System.out.println("13.코로나15 조회");
		// 정상 출력 예:
		// 13.코로나15 조회
		// 코로나15: 미등록 바이러스입니다.
		try {
			Virus v = vmgr.search("코로나15");
			System.out.println(v);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		// <- 주석 해제 후 작성 : end /////////////////////////////////

		// 60. BookManagerImpl
//		BookManager bookManagerImpl1 = new BookManagerImpl();
//		BookManager bookManagerImpl2 = new BookManagerImpl();
		BookManagerImpl manage = BookManagerImpl.getInstance();
		manage.add(new Book("홍길동전", 60000));
		manage.add(new Book("심청전", 30000));
		manage.add(new Book("슈퍼맨", 25000));
		manage.add(new Book("스파이더맨", 90000));
		manage.add(new Book("아이언맨", 40000));
		Book book = manage.search(new Book("아이언맨", 40000));
		System.out.println(book);

		System.out.println("=======================");
		// 61. bookManagerImpl에 저장된 책을 가격순으로 출력 (오름차순)
		List<Book> bookList = manage.search();
		for (Book b : bookList)
			System.out.println(b);
		manage.save();
	}
}
