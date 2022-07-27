package classJAVA;

public class Test_Exception {

	// static이 non-static을 호출하면 안됨
	public static void main(String[] args) {
		Test_Exception te = new Test_Exception();
		System.out.println("main 시작");
		te.a();
		System.out.println("main 종료");
	} // end of main

	public void a() {
		System.out.println("a 시작");
		b(0);
		System.out.println("a 종료");
	}

	private void b(int m) {
		System.out.println("b 시작");
		try {
			System.out.println("num : " + m);
			int x = 3 / m; //Arithmetic Exception;
			System.out.println("종료1" + x);
			
		}/* catch (ArithmeticException e) {
			System.out.println("예외 발생");
			System.out.println(e.getMessage());
		}*/ catch (ClassCastException e) {
			System.out.println();
		} finally { //exception에 예외가 안걸리고 비정상 종료가 되어도 수행됨.. 무조건 수행됨
			System.out.println("finally block!~");
		}
		System.out.println("b 종료");
	}
}
