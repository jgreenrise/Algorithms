# Sorting a Stack

## Question

![Rendered Image](https://i.stack.imgur.com/jOxKl.png)

### Given a stack `s`, implement a function to sort the elements of the stack in ascending order using only one additional stack as a buffer.

## Analysis

To solve this problem, we can use a buffer stack (`bufferStack`) to store elements in sorted order. We iterate through each element in the original stack (`s`) and compare it with the top element of the buffer stack. If the element is greater, we directly push it onto the buffer stack. If it is smaller, we pop elements from the buffer stack and push them onto the original stack until we find the correct position for the current element.

## Challenge

The challenge in this problem lies in efficiently sorting the stack using only one additional stack and managing the comparisons to maintain the sorted order.

## Solution

```java
public static Stack<Integer> sort(Stack<Integer> s) {
    Stack<Integer> bufferStack = new Stack<>();

    while (!s.isEmpty()) {
        if (bufferStack.isEmpty()) {
            bufferStack.push(s.pop());
        } else {
            if (bufferStack.peek() <= s.peek()) {
                bufferStack.push(s.pop());
            } else {
                int sPop = s.pop();
                while (!bufferStack.isEmpty() && bufferStack.peek() > sPop) {
                    s.push(bufferStack.pop());
                }
                bufferStack.push(sPop);
            }
        }
    }

    return bufferStack;
}
```

This solution effectively uses the `bufferStack` to sort the elements in ascending order. The time complexity is O(n^2) in the worst case, where n is the number of elements in the stack. The space complexity is O(n) due to the use of the buffer stack.