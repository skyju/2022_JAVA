package day0727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Solution_SWEA_1928Base64Decoder_D2_130ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			Decoder encoder = Base64.getDecoder();
			byte[] arr = encoder.decode(line);
			System.out.printf("#%d ", tc);
			for (int i = 0; i < arr.length; i++) {
				System.out.print((char) arr[i]);
			}
			System.out.println();
		}
	}
}
