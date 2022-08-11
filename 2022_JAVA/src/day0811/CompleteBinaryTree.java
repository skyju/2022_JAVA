package day0811;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 완전 이진 트리
public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex; // 마지막 노드의 인덱스
	private final int SIZE; // 객체 상수는 생성자에서 초기화 해야 함

	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new char[size + 1]; // 1 index부터 사용할 것임 (그래야 *2 개념이 됨)
	}

	public boolean add(char e) { // 완전 이진 트리에 맞게 추가
		if (lastIndex == SIZE)
			return false;
		nodes[++lastIndex] = e;
		return true;
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>(); // index를 generic으로
		queue.offer(1); // 루트노드 인덱스 부터

		while (!queue.isEmpty()) { // 방문 대상이 있을 때까지 반복
			int current = queue.poll(); // 방문 차례인 대상 인덱스 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리

			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if (current * 2 <= lastIndex) // 왼쪽 자식
				queue.offer(current * 2);
			if (current * 2 + 1 <= lastIndex) // 오른쪽 자식
				queue.offer(current * 2 + 1);
		}
		System.out.println();
	}

	// 동일 레벨(높이)의 대상끼리 묶어보는 법
	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>(); // index를 generic으로
		queue.offer(1); // 루트노드 인덱스 부터

		while (!queue.isEmpty()) { // 방문 대상이 있을 때까지 반복
			int size = queue.size(); // 큐의 크기 확인 (동일 너비 대상 개수)
			
			while (--size >= 0) { // 반복 진입 전 구한 큐 크기 만큼 반복
				int current = queue.poll();
				System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
				
				// 현재 방문노드의 자식노드들을 대기열에 넣기
				if (current * 2 <= lastIndex) queue.offer(current * 2);
				if (current * 2 + 1 <= lastIndex) queue.offer(current * 2 + 1);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void dfs() {
		Stack<Integer> stack = new Stack<Integer>(); // index를 generic으로
		stack.push(1); // 루트노드 인덱스 부터

		while (!stack.isEmpty()) { // 방문 대상이 있을 때까지 반복
			int current = stack.pop(); // 방문 차례인 대상 인덱스 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리

			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if (current * 2 <= lastIndex) stack.push(current * 2);
			if (current * 2 + 1 <= lastIndex) stack.push(current * 2 + 1);
		}
		System.out.println();
	}
	
	public void dfsByPreOrder(int current) {
		
		System.out.print(nodes[current] + " "); // 방문
		if (current * 2 <= lastIndex) dfsByPreOrder(current * 2);
		if (current * 2 + 1 <= lastIndex) dfsByPreOrder(current * 2 + 1);
	}
	
	public void dfsByInOrder(int current) {
		if (current > lastIndex) return;
		
		if (current * 2 <= lastIndex) dfsByInOrder(current * 2);
		System.out.print(nodes[current] + " "); // 방문
		if (current * 2 + 1 <= lastIndex) dfsByInOrder(current * 2 + 1);
	}
	
	public void dfsByPostOrder(int current) {
		if (current > lastIndex) return;
		
		if (current * 2 <= lastIndex) dfsByPostOrder(current * 2);
		if (current * 2 + 1 <= lastIndex) dfsByPostOrder(current * 2 + 1);
		System.out.print(nodes[current] + " "); // 방문
	}
}
