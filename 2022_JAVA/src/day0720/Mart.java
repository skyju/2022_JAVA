package day0720;

public class Mart {

	String name; // 마트 이름

	// 판매물품 가격
	int ball;
	int pen;

	public Mart() {
		// this("", 0, 0); //혹시 null이 출력될 수 있으므로
	}

	public Mart(String name) {
		this(name, 0, 0);
		// this.name = name;
	}

	public Mart(String name, int ball, int pen) {
		this.name = name;
		this.ball = ball;
		this.pen = pen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getPen() {
		return pen;
	}

	public void setPen(int pen) {
		this.pen = pen;
	}

	/** 품목 10% 할인 */
	void sale() {
		sale(0.1);
	}

	/** 품목을 doulbe만큼 할인 */
	void sale(double per) {
		double discountPer = 1 - per;
		ball *= discountPer;
		pen *= discountPer;
	}

	@Override
	public String toString() {
		return String.format("%s의 공가격 : %d원, 펜가격 : %d원", name, ball, pen);
		// return "Mart [name=" + name + ", ball=" + ball + ", pen=" + pen + "]";
	}

}
