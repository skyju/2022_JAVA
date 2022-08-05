package com.ssafy.corona.book;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Comparable<Book>, Serializable {

	private String name;
	private int price;
	private transient static int pw = 1; //민감 데이터
	
	public Book() {
	}

	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
		pw = pw++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name=" + name + ", price=" + price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Book o) {
		return this.price - o.price;
	}
}
