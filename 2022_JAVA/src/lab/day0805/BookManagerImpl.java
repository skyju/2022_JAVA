package com.ssafy.corona.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagerImpl implements BookManager {

	private List<Book> bookList = new ArrayList<Book>();
	private static BookManagerImpl bookManager = new BookManagerImpl();
	private File file = new File("C:\\SSAFY\\Booklist.txt");

	private BookManagerImpl() {
//		파일에서 읽어서 booklist에 저장하기. (Serializable implements) // 강의 다시 보기
		load();
	}

	public static BookManagerImpl getInstance() {
		return bookManager;
	}

	@SuppressWarnings("unchecked")
	public void load() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			this.bookList = (List<Book>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(this.bookList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Book book) {
		if (search(book) != null) {
			System.out.println("이미 같은 이름의 책이 등록되어 있습니다.");
		} else {
			bookList.add(book);
		}
	}

	public void remove(String name) {
		boolean flag = false;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getName().equals(name)) {
				flag = true;
				bookList.remove(i);
				break;
			}
		}
		if (flag) {
			System.out.println("해당 도서를 삭제했습니다.");
		} else {
			System.out.println("해당하는 도서를 찾지 못했습니다.");
		}
	}

	@Override
	public Book search(Book book) {
		for (Book b : bookList) {
			if (book.equals(b)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public List<Book> search() {

		// 정렬
		// 내부비교기 외부비교기

		// 내부는 가격 오름차순으로 되어있음
		// 외부는 이름 내림차순으로 작성

		// 외부비교기를 jdk8에서 나온 lambda 식으로 변경
		// 익명클래스를 대체하기 위해 많이 사용
		Collections.sort(bookList, (Book o1, Book o2) -> o2.getName().compareTo(o2.getName()));

		return bookList;
	}

}
