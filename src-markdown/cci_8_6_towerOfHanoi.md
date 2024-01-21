# Tower of Hanoi

## Question

Implement the Tower of Hanoi algorithm to solve the puzzle for a given number of disks. The Tower of Hanoi consists of three rods and a number of disks of different sizes which can slide onto any rod.

## Analysis

The Tower of Hanoi algorithm is a classic recursive puzzle that involves moving a stack of disks from one rod to another, subject to the constraint that only one disk can be moved at a time, and no disk can be placed on top of a smaller disk. The algorithm follows a recursive approach to break down the problem into smaller subproblems.

## Challenges

The challenges associated with the Tower of Hanoi problem include:

- Understanding the recursive nature of the algorithm.
- Optimizing the algorithm for larger inputs.
- Visualizing the movement of disks in a recursive manner.

## Video Resource

[![Tower of Hanoi Video](https://img.youtube.com/vi/Ajy8XweC3L8/maxresdefault.jpg)](https://www.youtube.com/watch?v=Ajy8XweC3L8)

For a detailed analysis and visual explanation of the Tower of Hanoi algorithm, you can watch this [YouTube video](https://www.youtube.com/watch?v=Ajy8XweC3L8). The video provides insights into the recursive nature of the algorithm and demonstrates how the Tower of Hanoi problem can be solved step by step.

## Solution

The Tower of Hanoi algorithm is implemented using recursion. Here's the Java code:

```java
private int towerOfHanoi(int n, String source, String auxillary, String destination) {
    if (n == 1) {
        return 1;
    }

    // Move n-1 disk from source to Aux, using Destination tower
    int countSteps = towerOfHanoi(n - 1, source, destination, auxillary);

    // Move from Source to destination
    countSteps++;

    // Move n-1 disks from AUX to Destination, using Source
    countSteps += towerOfHanoi(n - 1, auxillary, source, destination);

    return countSteps;
}
