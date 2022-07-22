package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1208Flatten_D3_136ms {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int dumpLimit = Integer.parseInt(br.readLine());
			int[] arr = new int[100];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < dumpLimit; i++) {
				Arrays.sort(arr);
				arr[0] += 1;
				arr[arr.length - 1] -= 1;
			}
			Arrays.sort(arr);

			System.out.printf("#%d %d\n", tc, Math.abs(arr[arr.length - 1] - arr[0]));
		}
	}
}
