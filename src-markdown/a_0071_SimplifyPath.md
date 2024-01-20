import java.util.Stack;

public class a_0071_SimplifyPath {

    public static void main(String[] args) {
        // Example usage
        a_0071_SimplifyPath simplifier = new a_0071_SimplifyPath();
        //String simplifiedPath = simplifier.simplifyPath("/a/b/../c/./d");
        //String simplifiedPath = simplifier.simplifyPath("/a/./b/../../c/");
        //String simplifiedPath = simplifier.simplifyPath("/a/../../b/../c//.//");
        //String simplifiedPath = simplifier.simplifyPath("/home/");
        String simplifiedPath = simplifier.simplifyPath("/a//b////c/d//././/..");
        System.out.println("Simplified Path: " + simplifiedPath);
    }

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        buildStack(path, stack);

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";

    }


    private void buildStack(String path, Stack<String> stack) {

        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }


    }

}
