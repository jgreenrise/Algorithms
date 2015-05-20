package Stack.problems.queueFromSingleStack;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueFromSingleStack queue = new QueueFromSingleStack();

		queue.add("10");
		queue.add("40");
		queue.add("60");
		queue.add("90");

		System.out.println("Peek: " + queue.peek());
		queue.poll();
		
		System.out.println("Peek: " + queue.peek());
		queue.poll();
		
		System.out.println("Peek: " + queue.peek());
		queue.poll();
		
		System.out.println("Peek: " + queue.peek());

	}

}
