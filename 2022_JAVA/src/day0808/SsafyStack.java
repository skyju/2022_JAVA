package day0808;

public class SsafyStack<E> implements IStack<E> {
	
	private Node<E> top; //더미 노드 아님!!
	
	@Override
	public void push(E data) { //첫노드 삽입 알고리즘
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		if (isEmpty()) System.out.println("공백 스택이어서 작업이 불가능합니다.");
		Node <E> popNode = top;
		top = popNode.link; // 탑 노드에 다음을 넣고
		popNode.link = null; // 꺼낸 노드(제거하려는 노드)의 링크를 끊어준다.
		return popNode.data;
	}

	@Override
	public E peek() {
		if (isEmpty()) System.out.println("공백 스택이어서 작업이 불가능합니다.");
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0; //전역변수로 따로 빼도 됩니다. (c구현했을 때 했던 것 처럼)
		for (Node<E> tmp = top; tmp != null; top = top.link) ++cnt;
		return cnt;
	}

}
