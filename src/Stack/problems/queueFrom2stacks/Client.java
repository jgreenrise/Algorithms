package Stack.problems.queueFrom2stacks;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueFromStack queue = new QueueFromStack(4);

		queue.push("10");
		queue.push("40");
		queue.push("60");
		queue.push("90");
		
		System.out.println("Peek: "+queue.peek());
		queue.poll();
		System.out.println("Peek: "+queue.peek());
		queue.poll();
		System.out.println("Peek: "+queue.peek());
		queue.poll();
		System.out.println("Peek: "+queue.peek());
		

	}

}
