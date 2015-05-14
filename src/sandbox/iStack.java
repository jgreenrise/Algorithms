package sandbox;

public interface iStack {

	public void push(Object item_to_be_pushed);

	public Object pop();

	public Object peek();

	public boolean isEmpty();

	public boolean isFull();

	public int size();
}
