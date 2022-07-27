package classJAVA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test_Exception2 {
	public static void main(String[] args) {
		
		// try - catch와 자원의 반납
		
		// 1. 정석적인 반납
		/*
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("input.txt"));
			fis.read();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		
		
		// 2. jdk 1.7이상에서 리소스의 자동 close처리
		// Auto-close... finally block을 jvm이 대신 만들어줌
		try(FileInputStream fis = new FileInputStream(new File("input.txt"));
			Scanner sc = new Scanner(System.in);
			) {
			fis.read();
		} catch(IOException e) {
		}
	}
}
