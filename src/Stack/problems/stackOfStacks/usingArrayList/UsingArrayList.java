package Stack.problems.stackOfStacks.usingArrayList;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class UsingArrayList {

    public static class StackOfStack {

        List<LinkedStack> list = new ArrayList<>();
        int capacity = 3;

        public void push(int value) {
            if (list.size() == 0) {
                LinkedStack stack = new LinkedStack(capacity);
                stack.push(value);
                list.add(getSize(), stack);
            } else {
                int indexOfTopStack = getSize() - 1;
                LinkedStack topStack = list.get(indexOfTopStack);

                if(topStack.isFull()){
                    LinkedStack newStack = new LinkedStack(capacity);
                    newStack.push(value);
                    list.add(getSize(), newStack);
                }else{
                    topStack.push(value);
                }


            }
        }

        public int pop() {
            int indexOfTopStack = getSize() - 1;
            LinkedStack topStack = list.get(indexOfTopStack);

            while (topStack.isEmpty()) {
                indexOfTopStack = indexOfTopStack - 1;

                if (indexOfTopStack == 0) {
                    throw new EmptyStackException();
                }

                topStack = list.get(indexOfTopStack);
            }

            int response = (int) topStack.pop();

            if(topStack.size() == 0){
                list.set(indexOfTopStack, null);
                list.remove(indexOfTopStack);
            }

            return response;
        }

        public int peek() {
            int indexOfTopStack = getSize() - 1;
            LinkedStack topStack = list.get(indexOfTopStack);

            while (topStack.isEmpty()) {
                indexOfTopStack = indexOfTopStack - 1;

                if (indexOfTopStack == 0) {
                    throw new EmptyStackException();
                }

                topStack = list.get(indexOfTopStack);
            }
            return (int) topStack.peek();
        }

        public int popSOS(int index) {

            if (index >= getSize() || index < 0)
                try {
                    throw new Exception("Invalid index provided");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            LinkedStack topStack = list.get(index);

            if (topStack.isEmpty())
                throw new EmptyStackException();
            return (int) topStack.pop();
        }

        public int getSize() {
            return list.size();
        }

    }

    public static void main(String[] args) {

		StackOfStack stackOfStack = new StackOfStack();

        stackOfStack.push(3);
        stackOfStack.push(4);
        stackOfStack.push(5);
        stackOfStack.push(8);
        stackOfStack.push(7);
        stackOfStack.push(6);
        stackOfStack.push(7);
        stackOfStack.push(9);
        stackOfStack.push(10);

        //System.out.println("Pop: " + stackOfStack.pop());
        System.out.println("Stack of stack size: " + stackOfStack.getSize());

        System.out.println("Peek should be 10: "+stackOfStack.peek());

        stackOfStack.pop();
        System.out.println("Peek should be 9: "+stackOfStack.peek());

        stackOfStack.pop();
        System.out.println("Peek should be 7: "+stackOfStack.peek());

        stackOfStack.pop();
        System.out.println("Peek should be 6: "+stackOfStack.peek());

        System.out.println("Stack of stack size should be 2: "+stackOfStack.list.size());

        stackOfStack.popSOS(0);
        System.out.println("Stack of stack size should be 2: "+stackOfStack.list.size());


    }

}
