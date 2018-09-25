import java.util.Iterator;

class ProgramStack<T> implements Iterable<T> {
	// You'll want some instance variables here
	
	public ProgramStack() {
		//setup what you need
	}
	
	public void push(T item) {
		//push an item onto the stack
		//you may assume the item is not null
		//O(1)
	}
	
	public T pop() {
		//pop an item off the stack
		//if there are no items on the stack, return null
		//O(1)
		
		//replace this dummy return statement
		return null;
	}
	
	public T peek() {
		//return the top of the stack (but don't remove it)
		//if there are no items on the stack, return null
		//O(1)
		
		//replace this dummy return statement
		return null;
	}

	public String toString() {
		//Create a string of the stack where each item
		//is separated by a space. The top of the stack
		//should be shown to the right and the bottom of
		//the stack on the left.
		
		//Hint: Reuse the provided code from another class
		//instead of writing this yourself!
		
		//O(n)
		
		//replace this dummy return statement
		return null;
	}
	
	public void clear() {
		//remove everything from the stack
		//O(1)
	}
	
	public int size() {
		//return the number of items on the stack
		//O(1)
		
		//replace this dummy return statement
		return -1;
	}
	
	public boolean isEmpty() {
		//return whether or not the stack is empty
		//O(1)
		
		//replace this dummy return statement
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public Object[] toArray() {
		//Return an array representation of the stack.
		//The top of the stack should be element 0
		//in the array.
		
		//O(n)
		
		//replace this dummy return statement
		return null;
	}
	
	public Iterator<T> iterator() {
		//Return an iterator that traverses from
		//the top of the stack to the bottom of
		//the stack.
		
		//The iterator's hasNext() and next() methods
		//must both be O(1)
		
		//next() should throw a NullPointerException
		//if you try to use next when there are no
		//more items
		
		//replace this dummy return statement
		return null;
	}
	
	public static void main(String[] args) {
		ProgramStack<String> s1 = new ProgramStack<>();
		s1.push("a");
		s1.push("b");
		
		ProgramStack<Integer> s2 = new ProgramStack<>();
		s2.push(1);
		s2.push(2);
		s2.push(3);
		
		if(s1.toString().equals("a b") && s1.toArray()[0].equals("b") && s1.toArray()[1].equals("a") && s1.toArray().length == 2) {
			System.out.println("Yay 1");
		}
		
		if(s1.peek().equals("b") && s2.peek().equals(3) && s1.size() == 2 && s2.size() == 3) {
			System.out.println("Yay 2");
		}
		
		if(s1.pop().equals("b") && s2.pop().equals(3) && s1.size() == 1 && s2.size() == 2) {
			System.out.println("Yay 3");
		}
		
		if(s1.toString().equals("a") && s1.peek().equals("a") && s2.peek().equals(2) && s1.pop().equals("a") && s2.pop().equals(2) && s1.size() == 0 && s2.size() == 1) {
			System.out.println("Yay 4");
		}
		
		if(s1.toString().equals("") && s1.peek() == null && s2.peek().equals(1) && s1.pop() == null && s2.pop().equals(1) && s1.size() == 0 && s2.size() == 0) {
			System.out.println("Yay 5");
		}
		
		s2.push(10);
		s2.push(20);
		s2.push(30);
		if(s1.isEmpty() && s1.toArray().length == 0 && !s2.isEmpty()) {
			s2.clear();
			if(s2.isEmpty()) {
				System.out.println("Yay 6");
			}
		}
		
		ProgramStack<Integer> s3 = new ProgramStack<>();
		s3.push(3);
		s3.push(2);
		s3.push(1);
		
		int i = 1;
		for(Integer item : s3) {
			if(i == item) System.out.println("Yay " + (6+i));
			else
				System.out.println(item);
			i++;
		}
	}
}