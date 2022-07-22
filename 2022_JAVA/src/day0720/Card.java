package day0720;

public class Card {
	String kind;
	int num;
	static int width;
	static int height;

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(String kind, int num) {
		super();
		this.kind = kind;
		this.num = num;
	}

	public Card(String kind, int num, int width, int height) {
		super();
		this.kind = kind;
		this.num = num;
		Card.width = width;
		Card.height = height;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		Card.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		Card.height = height;
	}

	@Override
	public String toString() {
		return "Card [kind=" + kind + ", num=" + num + ", width=" + width + ", height=" + height + "]";
	}

}
