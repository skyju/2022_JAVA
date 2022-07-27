package lab;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager {

	private List<Book> books = new ArrayList<Book>();
	private static IBookManager instance;

	// 싱글톤
	private BookManagerImpl() {
	}

	public static IBookManager getInstance() {
		if (instance == null)
			instance = new BookManagerImpl();
		return instance;
	}

	// 도서 정보 등록
	public void add(Book book) {
		books.add(book);
	}

	// 고유번호로 도서정보 삭제
	public void remove(String isbn) {
		boolean flag = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				flag = true;
				books.remove(i);
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
		Book[] ans = new Book[books.size()];
		for (int i = 0; i < books.size(); i++)
			ans[i] = books.get(i);
		return ans;
	}

	// 도서 정보 반환
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn))
				return books.get(i);
		}
		return null;
	}

	// 제목으로 검색
	public Book[] searchByTitle(String title) {

		// 대소문자 상관없이 검색되도록
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().toLowerCase().contains(title.toLowerCase()))
				cnt++;
		}
		if (cnt == 0)
			return null;

		Book[] ans = new Book[cnt];
		int ans_i = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().toLowerCase().contains(title.toLowerCase()))
				ans[ans_i++] = books.get(i);
		}
		return ans;
	}

	public Magazine[] getMagazines() {

		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine)
				cnt++;
		}
		if (cnt == 0)
			return null;

		Magazine[] ans = new Magazine[cnt];
		int ans_i = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine)
				ans[ans_i++] = (Magazine) books.get(i);
		}
		return ans;
	}

	public Book[] getBooks() {

		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine))
				cnt++;
		}
		if (cnt == 0)
			return null;

		Book[] ans = new Book[cnt];
		int ans_i = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine))
				ans[ans_i++] = books.get(i);
		}
		return ans;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		return getTotalPrice() / books.size();
	}

	// 고유번호 도서를 수량만큼 판매
	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {

		int tmp = 0;
		Book book = null;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				book = books.get(i);
				tmp = i;
			}
		}

		if (book == null) {
			throw new ISBNNotFoundException(isbn);
		} else {
			if (book.getQuantity() < quantity) {
				throw new QuantityException();
			} else {
				books.get(tmp).setQuantity(book.getQuantity() - quantity);
			}
		}
	}

	// 고유번호 도서를 수량만큼 구입
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {

		int tmp = 0;
		Book book = null;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				book = books.get(i);
				tmp = i;
			}
		}

		if (book == null) {
			throw new ISBNNotFoundException(isbn);
		} else {
			books.get(tmp).setQuantity(book.getQuantity() + quantity);
		}
	}
}
