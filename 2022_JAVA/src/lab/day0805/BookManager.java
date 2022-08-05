package com.ssafy.corona.book;

import java.util.List;

public interface BookManager {
	Book search(Book book);

	// default를 달아주면 구현체에서 구현해도 되고 안해도 됨
	default List<Book> search() {
		return null;
	}
}
