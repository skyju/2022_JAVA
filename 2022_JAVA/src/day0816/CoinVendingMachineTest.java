package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinVendingMachineTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int targetMoney = Integer.parseInt(br.readLine()); // 목표 금액
		
		int[] units = {500, 100, 50, 10, 5, 1};
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] counts = {Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())};
		
		// 보유하고 있는 모든 동전들로 만들 수 있는 금액
		int totalMoney = 0; 
		for (int i = 0, size = units.length; i < size; i++) {
			totalMoney += units[i] * counts[i];
		}
		
		// 갖고 있는 돈에서 음료수 값을 지불하고 남은 나머지 금액
		int remainMoney = totalMoney - targetMoney;
		
		// 음료수 값을 지불하는 데 동전을 최대로 사용하려면, 지불하고 남은 금액의 동전수를 최소로 하면 됨
		// 지불하고 남은 금액의 동전수를 큰단위부터 !!
		
		// 가장 큰 동전단위부터 많이 사용하도록 처리
		int sum = 0, maxCnt, availCnt;
		for (int i = 0, size = units.length; i < size; i++) {
			// 해당 금액을 i동전단위를 가장 많이 쓸 때 개수
			maxCnt = remainMoney / units[i];
			// 가능한 만큼 다 있으면 그냥 쓰면되고, 아니면 보유한만큼만 사용
			availCnt = maxCnt <= counts[i] ? maxCnt : counts[i];
			
			//쓰고 남은 만큼 뺀다.
			counts[i] -= availCnt;
			remainMoney -= availCnt * units[i];
			
			// 사용되고 남은 동전이 지불하기 위해 사용될 동전 수
			sum += counts[i]; 
		}
		
		// 음료수 값을 지불하기 위해 사용된 동전수
		System.out.println(sum);
		System.out.println(Arrays.toString(counts));
	}
}
