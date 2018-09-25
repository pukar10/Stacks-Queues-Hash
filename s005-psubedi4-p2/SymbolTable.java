class SymbolTable<T> {
	private TableEntry<String,T>[] storage;
	
	@SuppressWarnings("unchecked")
	public SymbolTable(int size) {
		//Create a hash table where the initial storage
		//is size and string keys can be mapped to T values.
		//You may assume size is >= 2
	}
	
	public int getCapacity() {
		//return how big the storage is
		//O(1)
	}
	
	public int size() {
		//return the number of elements in the table
		//O(1)
	}
	
	public void put(String k, T v) {
		//Place value v at the location of key k.
		//Use linear probing if that location is in use.
		//You may assume both k and v will not be null.
		
		//Hint: Make a TableEntry to store in storage
		//and use the absolute value of k.hashCode() for
		//the probe start.
		
		//If the key already exists in the table
		//replace the current value with v.
		
		//If the key isn't in the table and the table
		//is >= 80% full, expand the table to twice
		//the size and rehash
		
		//Worst case: O(n), Average case: O(1)
	}
	
	public T remove(String k) {
		//Remove the given key (and associated value)
		//from the table. Return the value removed.		
		//If the value is not in the table, return null.
		
		//Hint 1: Remember to leave a tombstone!
		//Hint 2: Does it matter what a tombstone is?
		//   Yes and no... You need to be able to tell
		//   the difference between an empty spot and
		//   a tombstone and you also need to be able
		//   to tell the difference between a "real"
		//   element and a tombstone.
		
		//Worst case: O(n), Average case: O(1)
	}
	
	public T get(String k) {
		//Given a key, return the value from the table.
		
		//If the value is not in the table, return null.
		
		//Worst case: O(n), Average case: O(1)
	}
	
	public boolean isTombstone(int index) {
		//this is a helper method needed for printing
		
		//return whether or not there is a tombstone at the
		//given index
		
		//O(1)
	}
	
	@SuppressWarnings("unchecked")
	public boolean rehash(int size) {
		//Increase or decrease the size of the storage,
		//rehashing all values.
		
		//If the new size won't fit all the elements,
		//return false and do not rehash. Return true
		//if you were able to rehash.
	}
	
	public static void main(String[] args) {
		//main method for testing, edit as much as you want
		SymbolTable<String> st1 = new SymbolTable<>(10);
		SymbolTable<Integer> st2 = new SymbolTable<>(5);
		
		if(st1.getCapacity() == 10 && st2.getCapacity() == 5 && st1.size() == 0 && st2.size() == 0) {
			System.out.println("Yay 1");
		}
		
		st1.put("a","apple");
		st1.put("b","banana");
		st1.put("banana","b");
		st1.put("b","butter");
		
		if(st1.toString().equals("a:apple\nb:butter\nbanana:b") && st1.toStringDebug().equals("[0]: null\n[1]: null\n[2]: null\n[3]: null\n[4]: null\n[5]: null\n[6]: null\n[7]: a:apple\n[8]: b:butter\n[9]: banana:b")) {
			System.out.println("Yay 2");
		}
		
		if(st1.getCapacity() == 10 && st1.size() == 3 && st1.get("a").equals("apple") && st1.get("b").equals("butter") && st1.get("banana").equals("b")) {
			System.out.println("Yay 3");
		}
		
		st2.put("a",1);
		st2.put("b",2);
		st2.put("e",3);
		st2.put("y",4);

		if(st2.toString().equals("e:3\ny:4\na:1\nb:2") && st2.toStringDebug().equals("[0]: null\n[1]: e:3\n[2]: y:4\n[3]: null\n[4]: null\n[5]: null\n[6]: null\n[7]: a:1\n[8]: b:2\n[9]: null")) {
			System.out.println("Yay 4");
		}
		
		if(st2.getCapacity() == 10 && st2.size() == 4 && st2.get("a").equals(1) && st2.get("b").equals(2) && st2.get("e").equals(3) && st2.get("y").equals(4)) {
			System.out.println("Yay 5");
		}
		
		if(st2.remove("e").equals(3) && st2.getCapacity() == 10 && st2.size() == 3 && st2.get("e") == null && st2.get("y").equals(4)) {
			System.out.println("Yay 6");
		}
		
		if(st2.toString().equals("y:4\na:1\nb:2") && st2.toStringDebug().equals("[0]: null\n[1]: tombstone\n[2]: y:4\n[3]: null\n[4]: null\n[5]: null\n[6]: null\n[7]: a:1\n[8]: b:2\n[9]: null")) {
			System.out.println("Yay 7");
		}

		if(st2.rehash(2) == false && st2.size() == 3 && st2.getCapacity() == 10) {
			System.out.println("Yay 8");
		}
		
		if(st2.rehash(4) == true && st2.size() == 3 && st2.getCapacity() == 4) {
			System.out.println("Yay 9");
		}
		
		if(st2.toString().equals("y:4\na:1\nb:2") && st2.toStringDebug().equals("[0]: null\n[1]: y:4\n[2]: a:1\n[3]: b:2")) {
			System.out.println("Yay 10");
		}
		
		SymbolTable<String> st3 = new SymbolTable<>(2);
		st3.put("a","a");
		st3.remove("a");
		
		if(st3.toString().equals("") && st3.toStringDebug().equals("[0]: null\n[1]: tombstone")) {
			st3.put("a","a");
			if(st3.toString().equals("a:a") && st3.toStringDebug().equals("[0]: null\n[1]: a:a") && st3.toStringDebug().equals("[0]: null\n[1]: a:a")) {
				System.out.println("Yay 11");
			}
		}
	}
	
	//--------------Provided methods below this line--------------
	//Add JavaDocs, but do not change the methods.
	
	public String toString() {
		//THIS METHOD IS PROVIDED, DO NOT CHANGE IT
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < storage.length; i++) {
			if(storage[i] != null && !isTombstone(i)) {
				s.append(storage[i] + "\n");
			}
		}
		return s.toString().trim();
	}
	
	public String toStringDebug() {
		//THIS METHOD IS PROVIDED, DO NOT CHANGE IT
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < storage.length; i++) {
			if(!isTombstone(i)) {
				s.append("[" + i + "]: " + storage[i] + "\n");
			}
			else {
				s.append("[" + i + "]: tombstone\n");
			}
			
		}
		return s.toString().trim();
	}
}