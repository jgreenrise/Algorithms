package tree.bst;

/*
 * Exception class for duplicate item errors
 * in search tree insertions.
 */
public class MyDuplicateItemException extends Exception {

	/**
	 * Construct this exception object.
	 */
	public MyDuplicateItemException() {
		super();
	}

	/**
	 * Construct this exception object.
	 * 
	 * @param message
	 *            the error message.
	 */
	public MyDuplicateItemException(String message) {
		super(message);
	}

}
