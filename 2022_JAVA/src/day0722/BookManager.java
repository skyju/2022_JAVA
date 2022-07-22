package day0722;

import java.util.Arrays;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {

	private static int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;

	// + 추가.. 싱글톤
	private static BookManager bm;

	private BookManager() {
	}

	public static BookManager getInstance() {
		if (bm == null)
			bm = new BookManager();
		return bm;
	}

	// 도서 정보 등록
	public void add(Book book) {
		if (this.size >= MAX_SIZE) {
			System.out.println("도서 정보가 가득 차서 더 이상 추가할 수 없습니다.");
			return;
		}
		books[size++] = book;
	}

	// 도서 정보 삭제
	public void remove(String isbn) {
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				flag = true;
				// 쉬프트
				for (int j = i; j < MAX_SIZE - 1; j++)
					books[j] = books[j + 1];
				this.size -= 1;
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

	public Book[] searchByTitle(String title) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title))
				count++;
		}
		if (count == 0)
			return null;

		Book[] ans = new Book[count];

		count = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title))
				ans[count++] = books[i];
		}
		return ans;
	}

	public Magazine[] getMagazines() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine)
				count++;
		}

		if (count == 0)
			return null;

		Magazine[] ans = new Magazine[count];

		count = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine)
				ans[count++] = (Magazine) books[i];
		}
		return ans;
	}

	public Book[] getBooks() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine))
				count++;
		}

		if (count == 0)
			return null;

		Book[] ans = new Book[count];

		count = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine))
				ans[count++] = books[i];
		}
		return ans;
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
