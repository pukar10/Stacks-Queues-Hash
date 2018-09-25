//These are all the imports you are allowed, don't add any more!
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Computer {
	
	public static Node<String> fileToNodeQueue(String filename) throws IOException {
		//given a file name, open that file in a scanner and create a queue of nodes
		//the head of the queue of nodes should be the start of the queue
		//the values in the nodes should be the strings read in each time you call
		//next() on the scanner
		return null;
	}
	
	public Node<String> process(Node<String> input, int numSymbols) {
		//Given an input queue of symbols process the number of symbols
		//specified (numSymbols) and update the progStack and symbols
		//variables appropriately to reflect the state of the "computer"
		//(see below the "do not edit" line for these variables).
		
		//Return the remaining queue items.
		
		//For example, if input is the head of a linked list 3 -> 2 -> +
		//and numSymbols=2, you would push 3 and push 2, then return the linked
		//list with just the + node remaining.
		
		return null;
	}
	
	public static void testMain() {
		//edit this as much as you want, if you use main without any arguments,
		//this is the method that will be run instead of the program
		System.out.println("You need to put test code in testMain() to run Computer with no parameters.");
	}
	
	//--------------------DON'T EDIT BELOW THIS LINE--------------------
	//----------------------EXCEPT TO ADD JAVADOCS----------------------
	
	//don't edit these...
	public static final String[] INT_OPS = {"+","-","*","/"};
	public static final String[] ASSIGN_OPS = {"=","+=","-=","*=","/="};
	
	//or these...
	public ProgramStack<Object> progStack = new ProgramStack<>();
	public SymbolTable<Integer> symbols = new SymbolTable<>(5);
	
	public static void main(String[] args) {
		//this is not a testing main method, so don't edit this
		//edit testMain() instead!
		
		if(args.length == 0) {
			testMain();
			return;
		}
		
		if(args.length != 2 || !(args[1].equals("false") || args[1].equals("true"))) {
			System.out.println("Usage: java Computer [filename] [true|false]");
			System.exit(0);
		}
		
		try {
			(new Computer()).runProgram(args[0], args[1].equals("true"));
		}
		catch(IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	//provided, don't change this
	public void runProgram(String filename, boolean debug) throws IOException {
		Node<String> input = fileToNodeQueue(filename);
		System.out.println("\nProgram: " + Node.listToString(input));
		
		if(!debug) {
			while(input != null) {
				input = process(input, 10);
			}
		}
		else {
			Scanner s = new Scanner(System.in);
			for(int i = 1; input != null; i++) {
				System.out.println("\n######### Step " + i + " ###############\n");
				System.out.println("----------Step Output----------");
				input = process(input, 1);
				System.out.println("----------Symbol Table---------");
				System.out.println(symbols);
				System.out.println("----------Program Stack--------");
				System.out.println(progStack);
				if(input != null) {
					System.out.println("----------Program Remaining----");
					System.out.println(Node.listToString(input));
				}
				System.out.println("\nPress Enter to Continue");
				s.nextLine();
			}
		}
	}
}