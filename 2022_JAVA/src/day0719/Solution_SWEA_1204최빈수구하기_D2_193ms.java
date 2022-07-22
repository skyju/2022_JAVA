package day0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_SWEA_1204최빈수구하기_D2_193ms {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < 1000; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (!map.containsKey(tmp))
					map.put(tmp, 1);
				else
					map.replace(tmp, map.get(tmp), map.get(tmp) + 1);
			}
			List<Map.Entry<Integer, Integer>> entryList = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
			entryList.sort(Map.Entry.comparingByValue());
			int ans = entryList.get(entryList.size() - 1).getKey();
			System.out.println("#" + tc + " " + ans);
		}
	}
}
