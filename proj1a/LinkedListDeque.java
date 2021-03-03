public class LinkedListDeque<T>{

	private class Node{
		public Node prev;
		public Node next;
		public T item;
		public Node(Node p, Node n, T i){
			prev = p;
			next = n;
			item = i;
		}
	}
	private int size;
	private Node sentinel;
	private Node end;

	public LinkedListDeque(){
		sentinel = new Node(null, null,null);
		
		size = 0;
	}

	public void addFirst(T i){
		if (size == 0){
			Node newNode = new Node(sentinel,null,i);
			sentinel.next = newNode;
			end = newNode;
			size += 1;

		}
		else{
			Node newNode = new Node(sentinel,sentinel.next,i);
			sentinel.next.prev = newNode;
			sentinel.next = newNode;
			size += 1;
		}

	}

	public void addLast(T i){
		if (size == 0){
			Node newNode = new Node(sentinel,null,i);
			sentinel.next = newNode;
			end = newNode;
			size += 1;

		}
		else{
			Node newNode = new Node(end,null,i);
			end.next = newNode;
			end = newNode;
			size += 1;

		}
	}

	public boolean isEmpty(){
		return size ==0;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		if(size == 0){
			System.out.println("empty");
		}
		Node m = sentinel.next;
		while (m.next != null){	
			System.out.print(m.item.toString()+" ");
			m = m.next;
		}
		System.out.print(m.item.toString()+" ");
		System.out.println();

	}

	public T removeFirst(){
		Node r = sentinel.next;
		T r_v = r.item;
		sentinel.next.next.prev = sentinel;
		sentinel.next = sentinel.next.next;

		r.next = null;
		r.prev = null;
		r.item = null;

		return r_v;
	}

	public T removeLast(){
		Node r = end;
		T r_v = r.item;
		end.prev.next = null;
		end = end.prev;

		r.next = null;
		r.prev = null;
		r.item = null;

		return r_v;

	}

	public T get(int index){
		if (index > size -1|| index <0){
			return null;
		}

		Node m = sentinel;
		for (int i = index; i >-1; i --){
			m = m.next;
		}
		return m.item;

	}

	public T getRecursive(int index ){
		return getRecursivehelper(index).item;
	}

	public Node getRecursivehelper(int index){
		if (index > size -1|| index <0){
			return null;
		}

		if (index == 0){
			return sentinel.next;
		}
		else{
			Node n = getRecursivehelper(index - 1);
			n = n.next;
			return n;
		}


	}
}