package Stack.implementStack;

public class StackMainApp {

	public static void main(String[] args) {
		
		LinkedStack words = new LinkedStack();
		words.push("Santacruz");
		words.push("Surat");
		words.push("Belmont");
		words.push("Corvallis");
		
		System.out.println("Peek: "+words.peek()+", Stack size: "+words.size());
		System.out.println("Pop: "+words.pop()+", Stack size: "+words.size());
		
		/**
		 * Searching stack index
		 * The index you get is the index from the top of the Stack, meaning the top element on the Stack has index 1.
		
		System.out.println("Index of word to be searched: "+words.search("Surat"));
		 */
		

	}
}
