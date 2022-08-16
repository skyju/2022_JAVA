package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시작시간과 종료시간이 있는 n개의 활동들의 집합에서
// 서로 겹치지 않는 최대갯수의 활동들의 집합을 구하는 문제

public class MeetingRoomTest {
	
	static public class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		// input, 회의 정보 입력받기
		int N = Integer.parseInt(br.readLine()); // 총 회의 개수
		
		Meeting[] meetings = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		
		// logic
		List<Meeting> result = getSchedule(meetings);
		
		System.out.println("총 회의 갯수 : " + result.size());
		for (Meeting meeting : result) {
			System.out.println(meeting.start + " : " + meeting.end);
		}
	}
	
	private static List<Meeting> getSchedule(Meeting[] meetings) {
		List<Meeting> result = new ArrayList<Meeting>();
		// 모든 회의를 종료시간 기준으로 오름차순, 종료시간이 같다면 시작시간 기준 오름차순 정렬
		Arrays.sort(meetings);
		result.add(meetings[0]); // 첫 회의 스케쥴에 추가
		
		for (int i = 1, size = meetings.length; i < size; i++) {
			if (result.get(result.size() - 1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		return result;
	}
}

