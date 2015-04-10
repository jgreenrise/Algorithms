package tree.bst;

/*
 * Exception class for duplicate item errors
 * in search tree insertions.
 */
public class DuplicateItemException extends Exception {

	/**
	 * Construct this exception object.
	 */
	public DuplicateItemException() {
		super();
	}

	/**
	 * Construct this exception object.
	 * 
	 * @param message
	 *            the error message.
	 */
	public DuplicateItemException(String message) {
		super(message);
	}

}
