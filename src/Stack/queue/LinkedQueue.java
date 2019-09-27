package Stack.queue;

public class LinkedQueue {

    Node bottom;

    public void add(int value){
        if(bottom == null){
            Node node = new Node(value);
            bottom=node;
        }
		else{

            Node original = bottom;
            Node node = new Node(value);

            while(bottom.next != null)
                bottom = bottom.next;

            bottom.next = node;
            bottom = original;
        }
    }

    public int pop(){
        int response = (int)bottom.data;
        bottom = bottom.next;
        return response;
    }

    public int peek(){
        return (int)bottom.data;
    }

    private class Node {
        private Object data;
        private LinkedQueue.Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public static void main(String args[]){

        LinkedQueue queue = new LinkedQueue();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());

        queue.pop();
        System.out.println(queue.peek());

    }


}
