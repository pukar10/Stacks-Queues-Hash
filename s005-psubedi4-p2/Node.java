//Do not edit this class, just add JavaDocs
//You may edit the main method for testing things if you want
//but do not change the actual class structure.

class Node<T> {
	private T value;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getPrev() {
		return this.prev;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public static String listToString(Node<?> head) {
		StringBuilder ret = new StringBuilder();
		Node<?> current = head;
		while(current != null) {
			ret.append(current.value);
			ret.append(" ");
			current = current.getNext();
		}
		return ret.toString().trim();
	}
	
	public static String listToStringBackward(Node<?> head) {
		Node<?> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		
		StringBuilder ret = new StringBuilder();
		while(current != null) {
			ret.append(current.value);
			ret.append(" ");
			current = current.getPrev();
		}
		return ret.toString().trim();
	}
	
	public static void main(String[] args) {
		//main method for testing, edit as much as you want
		
		//make nodes
		Node<String> n1 = new Node<>("A");
		Node<String> n2 = new Node<>("B");
		Node<String> n3 = new Node<>("C");
		
		//connect forward references
		n1.setNext(n2);
		n2.setNext(n3);
		
		//connect backward references
		n3.setPrev(n2);
		n2.setPrev(n1);
		
		//print forward and backward
		System.out.println(Node.listToString(n1));
		System.out.println(Node.listToStringBackward(n1));
	}
}