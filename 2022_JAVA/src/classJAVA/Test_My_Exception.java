package classJAVA;

public class Test_My_Exception {

	final int MAX_SIZE = 3;
	int[] arr = new int[MAX_SIZE];
	int index = 0;

	public static void main(String[] args) {
		Test_My_Exception tme = new Test_My_Exception();
		try {
			tme.add(5);
			tme.add(4);
			tme.add(7);
			tme.add(9);
		} catch (ArrIsFullException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage() + "배열 예외 발생");
			System.out.println(e.data + " : " + e.time);
		}

	} // end of main

	private void add(int data) {
		if (index >= MAX_SIZE) {
			ArrIsFullException afe = new ArrIsFullException("배열 꽉찼어");
			afe.data = data;
			afe.time = System.currentTimeMillis();
			throw afe;
		} else {
			System.out.println(data + "를 배열에 추가함");
			arr[index++] = data;
		}
	}
} // end of class

class ArrIsFullException extends ArrayIndexOutOfBoundsException {
	int data;
	long time;
	public ArrIsFullException(String message) {
		super(message);
	}
}
