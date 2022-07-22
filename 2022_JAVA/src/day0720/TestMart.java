package day0720;

public class TestMart {
	public static void main(String[] args) {
		
		Mart mart = new Mart("어쩌구마트", 15000, 2000);
		System.out.println(mart.toString());;
		mart.sale();
		System.out.println(mart.toString());;
		
		mart = new Mart("저쩌고마트", 20000, 3000);
		System.out.println(mart.toString());;
		mart.sale(0.2);
		System.out.println(mart.toString());;
		
		Mart mart2 = new Mart("천리마마트", 10000, 1000);
		System.out.println(mart2.toString());;
		mart2.sale();
		System.out.println(mart2.toString());;
		mart2.sale();
		System.out.println(mart2.toString());;
	}
}
