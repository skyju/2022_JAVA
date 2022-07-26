package day0722;

import java.util.Arrays;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager {

	private static int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;
	private static IBookManager instance;

	// + 추가.. 싱글톤
	private BookManagerImpl() {
	}
	public static IBookManager getInstance() {
		if (instance == null)
			instance = new BookManagerImpl();
		return instance;
	}

	// 도서 정보 등록
	public void add(Book book) {
		if (this.size >= MAX_SIZE) {
			System.out.println("도서 정보가 가득 차서 더 이상 추가할 수 없습니다.");
			return;
		}
		books[size++] = book;
	}

	// 고유번호로 도서정보 삭제
	// 하나씩 쉬트프하는 거보다 System.arraycopy가 훨씬 빠름
	public void remove(String isbn) {
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				flag = true;
				System.arraycopy(books, i + 1, books, i, size - i - 1);
				size--;
				break;
			}
		}
		if (flag) {
			System.out.println("해당 도서를 삭제했습니다.");
		} else {
			System.out.println("해당하는 도서를 찾지 못했습니다.");
		}
	}

	// 도서 리스트 반환
	public Book[] getList() {
		/*
		 * Book[] result = new Book[size]; System.arraycopy(books, 0, result, 0, size);
		 * return result;
		 */
		return Arrays.copyOfRange(books, 0, size);
	}

	// 도서 정보 반환
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn))
				return books[i];
		}
		return null;
	}

	// 갯수 세는 for문을 돌리는 거보다
	// size로 일단 만들고 내보낼때 짤라 보내는게 빠를거 같아요!! 수정 -> 메모리는 낭비됨
	// contains 보다 indexOf 쓰는게 속도는 더 빨라요!
	public Book[] searchByTitle(String title) {

		Book[] ans = new Book[size];
		
		//대소문자 상관없이 검색되도록
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().toLowerCase().contains(title.toLowerCase()))
				ans[index++] = books[i];
		}
		if (index == 0)
			return null;
		return Arrays.copyOfRange(ans, 0, index);
	}

	public Magazine[] getMagazines() {

		Magazine[] ans = new Magazine[size];

		int index = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine)
				ans[index++] = (Magazine) books[i];
		}
		if (index == 0)
			return null;
		return Arrays.copyOfRange(ans, 0, index);
	}

	public Book[] getBooks() {
		
		Book[] ans = new Book[size];
		
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine))
				ans[index++] = books[i];
		}
		if (index == 0)
			return null;
		return Arrays.copyOfRange(ans, 0, index);
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		return getTotalPrice() / size;
	}
}
