package day0722;

/**
 * 잡지 정보를 나타내는 클래스
 */
public class Magazine extends Book {
	private int year;
	private int month;
	
	public Magazine() {
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return getIsbn() + "  |  " + String.format("%10s",getTitle()) + "\t  |  " +  getAuthor() + "  |  " + getPublisher()
				+ "  |  " + getPrice() + "  |  " + getDesc() + "  |  " + year + "  |  " + month;
	}
}
