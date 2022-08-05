package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2164_카드2_Silver4_196ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> deck = new LinkedList<Integer>();
		for (int i = 1 ; i <= N; i++)
			deck.add(i);
		
		while (deck.size() != 1) {
			deck.poll();
			int tmp = deck.poll();
			deck.offer(tmp);
		}
		
		System.out.println(deck.poll());
		br.close();
	}
}