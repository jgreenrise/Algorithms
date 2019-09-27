package Stack.problems;

import Stack.queue.LinkedQueue;

public class AnimalShelter {

    Node bottom;
    Node top;

    public void add(int value, boolean isDog, boolean isCat) {

        Node node = new Node(value, isDog, isCat);
        if (bottom == null) {
            bottom = node;
            top = node;
        } else {
            top.next = node;
            top = node;
        }
    }

    public int pop(){
        int value = (int) bottom.data;
        bottom = bottom.next;
        return value;
    }

    public int peek(){
        int value = (int) bottom.data;
        return value;
    }

    public int pop(boolean isDog, boolean isCat) throws Exception {

        if(isDog){

            if(bottom.isDog){
                int value = (int) bottom.data;
                bottom = bottom.next;
                return value;
            }

            while(!bottom.next.isDog){
                bottom = bottom.next;

                if(bottom == null)
                    throw new Exception("Dog not found");

            }

            if(bottom.next.isDog){
                int value = (int) bottom.next.data;
                bottom = bottom.next.next;
                return value;
            }else{
                throw new Exception("Dog not found");
            }

        }else if(isCat){

            if(bottom.isCat){
                int value = (int) bottom.data;
                bottom = bottom.next;
                return value;
            }

            while(!bottom.next.isCat){
                bottom = bottom.next;
                if(bottom == null)
                    throw new Exception("Cat not found");
            }

            if(bottom.next.isCat){
                int value = (int) bottom.next.data;
                bottom = bottom.next.next;
                return value;
            }else{
                throw new Exception("Cat not found");
            }
        }

        return -1;
    }

    private class Node {
        private Object data;
        private Node next;
        private boolean isDog = false;
        private boolean isCat = false;

        public Node(Object data, boolean isDog, boolean isCat) {
            this.data = data;
            this.isDog = isDog;
            this.isCat = isCat;
        }
    }

    public static void main(String args[]) throws Exception {

        AnimalShelter queue = new AnimalShelter();

        queue.add(10, true, false);
        queue.add(20, false, true);
        queue.add(30, true, false);
        queue.add(40, false, true);
        queue.add(50, true, false);

        System.out.println(queue.peek());
        System.out.println(queue.pop(false, true));
        System.out.println(queue.pop(false, true));

        System.out.println(queue.peek());

    }


}
