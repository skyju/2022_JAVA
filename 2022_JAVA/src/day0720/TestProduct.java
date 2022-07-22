package day0720;

public class TestProduct {

	public static void main(String[] args) {

		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		/*
		p1.sn = 1;
		p1.sn = 2;
		p1.sn = 1; // 사용자 실수
		*/
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());

	}

}

class Product {
	static int num = 10000;

	int sn; // 시리얼 넘버
	
	public Product() {
		sn = num++;
	}

	@Override
	public String toString() {
		return "sn : " + sn;
	}
}
