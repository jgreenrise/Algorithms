In this example, you have an `AreaCalculator` class that calculates the area of a rectangle. The current implementation only works for rectangles:

```java
class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}

class AreaCalculator {
    public double calculateArea(Rectangle rectangle) {
        return rectangle.getLength() * rectangle.getWidth();
    }
}
```

Here, the `calculateArea` method is designed specifically for the `Rectangle` class. If you want to add support for another shape, like a **circle**, you would need to modify the `AreaCalculator` class to include logic for the new shape. For example:

### Modifying `AreaCalculator` for a Circle:
```java
class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class AreaCalculator {
    // Now it has to handle both rectangles and circles
    public double calculateArea(Rectangle rectangle) {
        return rectangle.getLength() * rectangle.getWidth();
    }

    public double calculateArea(Circle circle) {
        return Math.PI * circle.getRadius() * circle.getRadius();
    }
}
```

By modifying `AreaCalculator` to add support for a circle, we are violating the **Open/Closed Principle** because we **modified** the existing class to handle new shapes.

### Problems with This Approach:
1. **Code Duplication**: If we add more shapes (e.g., triangles, hexagons), the `AreaCalculator` class will keep growing in size with duplicated logic for area calculations.
2. **Difficult to Maintain**: Every time a new shape is introduced, we need to modify the `AreaCalculator` class, which increases the risk of bugs.
3. **Violation of Open/Closed Principle**: The `AreaCalculator` class is not **closed** for modification, since we have to change it whenever we add a new shape.

### Solution Using the Open/Closed Principle:
To adhere to the Open/Closed Principle, we can design the system so that new shapes can be added without modifying the `AreaCalculator` class. We can achieve this by using **polymorphism** through interfaces or abstract classes.

Here's how we can refactor the code:

### Refactored Design Using the Open/Closed Principle:

1. **Create a `Shape` Interface**:
    - This interface will define a contract for any shape to implement the `calculateArea` method.

2. **Implement `Shape` for Each Shape Class**:
    - Each shape (e.g., `Rectangle`, `Circle`) will implement the `Shape` interface and provide its own logic for calculating the area.

3. **Refactor `AreaCalculator`**:
    - The `AreaCalculator` class will now only interact with the `Shape` interface, without needing to know the specific type of shape.

```java
// Step 1: Define the Shape interface
interface Shape {
    double calculateArea();
}

// Step 2: Implement Shape interface for Rectangle
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Step 3: Implement Shape interface for Circle
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Step 4: Refactor AreaCalculator to work with the Shape interface
class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
```

### Advantages of This Approach:
- **Closed for Modification**: The `AreaCalculator` class is now closed for modification. You no longer need to modify it to add support for new shapes.
- **Open for Extension**: If you want to add a new shape (e.g., triangle), you simply create a new class that implements the `Shape` interface and define its area calculation logic.

For example, adding a triangle:

```java
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
```

Now you can calculate the area of any shape without changing the `AreaCalculator` class:

```java
class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20);
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(10, 5);

        AreaCalculator calculator = new AreaCalculator();

        System.out.println("Rectangle Area: " + calculator.calculateArea(rectangle));
        System.out.println("Circle Area: " + calculator.calculateArea(circle));
        System.out.println("Triangle Area: " + calculator.calculateArea(triangle));
    }
}
```

This design adheres to the **Open/Closed Principle** and makes the system more scalable and easier to maintain.