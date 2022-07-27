package lab;

public class NameNotFoundException extends Exception {
	/**	존재하지 않는 도서 고유번호 */
	private String name;
	
	/** 고유번호를 받아 생성하는 생성자 */
	public NameNotFoundException(String name) {
		super(name + " 이름을 포함하는 사용자가 존재하지 않습니다.");
		this.name = name;
	}
	/**
	 * 존재하지 않는 도서 고유번호를 반환한다.
	 * @return 존재하지 않는 도서 고유번호
	 */
	public String getName() {
		return name;
	}
}
