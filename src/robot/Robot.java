package robot;

import java.util.Scanner;

/**
 * Description
 * Create a command-line program that prompts for interactive user commands to move a rover around a 2D plane.
 * The robot should point in a direction, turn to face different directions, and move in the direction it is facing.
 * <p>
 * Demo
 * Expected program output shown in black.
 * Sample user input illustrated in green.
 * Hello! Robot coming online.
 * Command the robot with:
 * L - turn left
 * R - turn right
 * M - move forward
 * ? - this message
 * Q - quit
 * > M
 * Robot at (0, 1) facing North
 * > L
 * Robot at (0, 1) facing West
 * > M
 * Robot at (-1, 1) facing West
 * > M
 * Robot at (-2, 1) facing West
 * > L
 * Robot at (-2, 1) facing South
 * > M
 * Robot at (-2, 0) facing South
 * > R
 * Robot at (-2, 0) facing West
 * > R
 * Robot at (-2, 0) facing North
 * > R
 * Robot at (-2, 0) facing East
 * > M
 * Robot at (-1, 0) facing East
 * > ?
 * Command the robot with:
 * L - turn left
 * R - turn right
 * M - move forward
 * ? - this message
 * Q - quit
 * > Q
 * Robot shutting down.
 * <p>
 * <p>
 * // Use case : 2
 * // Assuming: Robot is at 0,0: Initial Location
 * <p>
 * <p>
 * Hello! Robot coming online.
 * Command the robot with:
 * L - turn left
 * R - turn right
 * M - move forward
 * ? - this message
 * Q - quit
 * > M
 * Robot at (-1, 0) facing North
 * > L
 * Robot at (-1, -1) facing West, at location: -1,0
 * > M
 * Robot at (-1, -1) facing West, at location: -1,-1
 * > M
 * Robot at (-2, 1) facing West
 * > L
 * Robot at (-2, 1) facing South
 * > M
 * Robot at (-2, 0) facing South
 * > R
 * Robot at (-2, 0) facing West
 * > R
 * Robot at (-2, 0) facing North
 * > R
 * Robot at (-2, 0) facing East
 * > M
 * Robot at (-1, 0) facing East
 * > ?
 * Command the robot with:
 * L - turn left
 * R - turn right
 * M - move forward
 * ? - this message
 * Q - quit
 * > Q
 * Robot shutting down.
 */
public class Robot {

    public int row;
    public int col;
    public String direction;
    public final String NORTH = "NORTH";
    public final String EAST = "EAST";
    public final String WEST = "WEST";
    public final String SOUTH = "SOUTH";

    public Robot(int row, int col) {
        this.row = row;
        this.col = col;
        this.direction = NORTH;
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the command line
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot(0, 0);

        System.out.println("Hello! Robot coming online.\n" +
                "Command the robot with:\n" +
                "  L - turn left\n" +
                "  R - turn right\n" +
                "  M - move forward\n" +
                "  ? - this message\n" +
                "  Q - quit\n");

        // Read input in a loop until the user types 'exit'
        while (true) {
            String input = scanner.nextLine();

            // Check if the user wants to exit
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            // Process the input (you can add your logic here)
            System.out.println("You entered: " + input);

            if (input.charAt(0) == 'Q') {
                System.out.println("Robot shutting down.: ");
                break;
            }

            System.out.println(robot.getCurrentlocation(input.charAt(0), robot));
        }

        // Close the scanner
        scanner.close();

    }

    public String buiLDRobotCurrentLocationString() {
        return "Robot at (" + row + ", " + col + ") facing " + direction;
    }

    /**
     * M, curr{}
     *
     * @param instruction
     * @param robot
     * @return
     */
    private String getCurrentlocation(char instruction, Robot robot) {
        switch (instruction) {
            case 'M': {
                // * M - move forward
                if (robot.direction.equals(robot.NORTH)) {
                    robot.row = robot.row - 1;
                } else if (robot.direction.equals(robot.EAST)) {
                    robot.col = robot.col - 1;
                } else if (robot.direction.equals(robot.WEST)) {
                    robot.col = robot.col + 1;
                } else if (robot.direction.equals(robot.SOUTH)) {
                    robot.row = robot.row + 1;
                } else {
                    return "Invalid direction included. Current instruction: " + instruction;
                }
                return buiLDRobotCurrentLocationString();
            }
            case 'L': {
                // L - turn left
                if (robot.direction.equals(robot.NORTH)) {
                    robot.direction = WEST;
                } else if (robot.direction.equals(robot.EAST)) {
                    robot.direction = NORTH;
                } else if (robot.direction.equals(robot.WEST)) {
                    robot.direction = SOUTH;
                } else if (robot.direction.equals(robot.SOUTH)) {
                    robot.direction = EAST;
                } else {
                    return "Invalid direction included. Current instruction: " + instruction;
                }
                return buiLDRobotCurrentLocationString();
            }
            case '?': {
                // * ? - this message
                return " * Command the robot with:\n" +
                        " * L - turn left\n" +
                        " * R - turn right\n" +
                        " * M - move forward\n" +
                        " * ? - this message\n" +
                        " * Q - quit";
            }
            case 'R': {
                //  * R - turn right
                if (robot.direction.equals(robot.NORTH)) {
                    robot.direction = EAST;
                } else if (robot.direction.equals(robot.EAST)) {
                    robot.direction = SOUTH;
                } else if (robot.direction.equals(robot.WEST)) {
                    robot.direction = NORTH;
                } else if (robot.direction.equals(robot.SOUTH)) {
                    robot.direction = WEST;
                } else {
                    return "Invalid direction included. Current instruction: " + instruction;
                }
                return buiLDRobotCurrentLocationString();
            }
            case 'Q': {
                //  * Q - quit
                return "Robot shutting down.: ";
            }
            default: {
                return "Invalid instruction included. Current instruction: " + instruction;
            }
        }

    }


}
