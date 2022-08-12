package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class absHeap implements Comparable<absHeap>{
	int x;
	int absX;
	
	public absHeap(int x) {
		this.x = x;
		this.absX = x < 0 ? -x : x;
	}

	@Override
	public int compareTo(absHeap o) {
		if (this.absX == o.absX) {
			// return this.x - o.x; // 그냥 뺄샘하면  overflow남
			 return Integer.compare(this.x, o.x); // Integer 객체의 compare를 사용하거나
			// return this.x > o.x ? 1 : -1; // 삼항 연산자를 사용하면 됨
		}
		return this.absX - o.absX;
	}
}

public class Main_BOJ_11286_절대값힙_Silver1_272ms {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<absHeap> minHeap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			if (t != 0) {
				minHeap.offer(new absHeap(t));
			} else {
				if (minHeap.isEmpty()) sb.append(0);
				else {
					absHeap a = minHeap.poll();
					sb.append(a.x);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	} // end of main
	
} // end of class