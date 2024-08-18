package tree.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
 */
class a_1628_DesignExpressionTreeWithEvaluateFunction {

    static abstract class Node {
        public abstract int evaluate();

    };

    static class SubNode extends Node{

        // define your fields here
        public String val;
        public SubNode left;
        public SubNode right;
        public SubNode(String val){
            this.val = val;
        }

        public int evaluate(){

            boolean isRightNodeNumber = isNumeric(right.val);
            if(isRightNodeNumber){
                // Right node is a number
                if(val.equals("/"))         return evaluate(left) / Integer.parseInt(right.val);
                else if(val.equals("*"))    return evaluate(left) * Integer.valueOf(right.val);
                else if(val.equals("+"))    return evaluate(left) + Integer.valueOf(right.val);
                else if(val.equals("-"))    return evaluate(left) - Integer.valueOf(right.val);
            }else{
                // Left node is a number
                if(val.equals("/"))         return Integer.parseInt(left.val) / evaluate(right);
                else if(val.equals("*"))    return Integer.parseInt(left.val) * evaluate(right);
                else if(val.equals("+"))    return Integer.parseInt(left.val) + evaluate(right);
                else if(val.equals("-"))    return Integer.parseInt(left.val) - evaluate(right);
            }
            return -1;
        }

        public int evaluate(SubNode node){

            if(isNumeric(node.val)){
                return Integer.parseInt(node.val);
            }

            boolean isRightNodeNumber = isNumeric(node.right.val);
            if(isRightNodeNumber){
                // Right Node is a number
                if(node.val.equals("/"))         return evaluate(node.left) / Integer.parseInt(node.right.val);
                else if(node.val.equals("*"))    return evaluate(node.left) * Integer.parseInt(node.right.val);
                else if(node.val.equals("+"))    return evaluate(node.left) + Integer.parseInt(node.right.val);
                else if(node.val.equals("-"))    return evaluate(node.left) - Integer.parseInt(node.right.val);
            }else{
                // left node is a number
                if(node.val.equals("/"))         return Integer.parseInt(node.left.val) / evaluate(node.right);
                else if(node.val.equals("*"))    return Integer.parseInt(node.left.val) * evaluate(node.right);
                else if(node.val.equals("+"))    return Integer.parseInt(node.left.val) + evaluate(node.right);
                else if(node.val.equals("-"))    return Integer.parseInt(node.left.val) - evaluate(node.right);
            }

            return -1;
        }

        public boolean isNumeric(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
    }


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    static class TreeBuilder {
        Node buildTree(String[] postfix) {

            int output = -1;
            Stack<String> stack = new Stack();

            int j = 0;
            for(j = 0; j < postfix.length; j++){
                String str = postfix[j];
                if(isNumeric(str)){
                    stack.push(str);
                }else{
                    // Operator found
                    break;
                }
            }
            SubNode root = new SubNode(postfix[j]);
            root.left = new SubNode(stack.pop());
            root.right = new SubNode(stack.pop());
            return getBinaryTree(root, stack, postfix, j+1);
        }

        public SubNode getBinaryTree(SubNode node, Stack stack, String [] postfix, int ptr){

            boolean shouldMoveRight = false;
            if(stack.isEmpty()){
                shouldMoveRight = true;
            }

            if(ptr >= postfix.length){
                return node;
            }

            int j;
            for(j = ptr; j < postfix.length; j++){
                String str = postfix[j];
                if(isNumeric(str)){
                    stack.push(str);
                }else{
                    // Operator found
                    break;
                }
            }


            SubNode root = new SubNode(postfix[j]);
            if(shouldMoveRight){
                root.left = node;
                root.right = new SubNode(String.valueOf(stack.pop()));
            }else{
                root.right = node;
                root.left = new SubNode(String.valueOf(stack.pop()));
            }

            return getBinaryTree(root, stack, postfix, j + 1);

        }

        public boolean isNumeric(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
    };


    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder obj = new TreeBuilder();
     * Node expTree = obj.buildTree(postfix);
     * int ans = expTree.evaluate();
     */

    public static void main(String args[]) {

        //String [] postfix = {"3", "4", "+", "2", "*", "7", "/"}; Works
        String [] postfix = {"4","5","2","7","+","-","*"}; //Works

        /**
         * Does not work for this
         */
        //String [] postfix = {"4","2","+","3","5","1","-","*","+"};

        TreeBuilder obj = new TreeBuilder();
        Node expTree = obj.buildTree(postfix);
        int ans = expTree.evaluate();
        System.out.println(ans);

    }
}