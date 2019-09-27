package Stack.queue;

public class LinkedQueueUsingTwoNodes {

    Node bottom;
    Node top;

    public void add(int value){
        if(bottom == null){
            Node node = new Node(value);
            bottom=node;
            top = node;
        }
        else{

            Node node = new Node(value);
            top.next = node;
            top = node;
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
        private LinkedQueueUsingTwoNodes.Node next;

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
