package graph.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {

    public static void main(String [] args){
        EvaluateDivision class1 = new EvaluateDivision();
        double[] values = {2.0, 3.0};
        List<List<String>> equations  = List.of(List.of("a", "b"), List.of("b", "c"));
        List<List<String>> queries  = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        System.out.println(Arrays.toString(class1.calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Graph graph = new Graph();
        graph.buildGraphs(equations, values);
        double[] out = new double[queries.size()];
        Map<String, Node> map = graph.map;

        for(int j=0 ; j <queries.size(); j++){
            List<String> query = queries.get(j);
            out[j] = dfs(map.get(query.get(0)), map.get(query.get(1)), 1.0);
            graph.resetStates();
        }
        return out;
    }

    public double dfs(Node left, Node right, double product){
        if(left == null ||  right == null) return -1;
        if(left == right)	return 1;
        left.state = 1;	// Mark as visited

        for(Node key: left.neighbours.keySet()){
            if(key.state == 1){
                continue;
            }else{
                if(key.val == right.val){
                    return product * left.neighbours.get(key);
                }else{
                     double resp = dfs(key, right, product * left.neighbours.get(key));
                     if(resp == -1.0)
                         continue;
                     else{
                         return resp;
                     }
                }
            }

        }

        return -1.0;

    }

    class Node{
        String val;
        int state = 0; // State: 0 unvisited, 1 visited, 2 in progress
        Map<Node, Double> neighbours;

        public Node(String val)	{
            this.val = val;
            neighbours = new HashMap();
        }
    }

    class Graph{
        Map<String, Node> map;
        public Graph(){	map = new HashMap();	}

        public void buildGraphs(List<List<String>> equations, double[] values){
            for(int j=0; j< equations.size(); j++){
                List<String> equation = equations.get(j);
                double output = values[j];
                Node leftNode = null;
                Node rightNode = null;
                String leftVal = equation.get(0);
                String rightVal = equation.get(1);

                if(map.containsKey(leftVal)){leftNode = map.get(leftVal);}
                else	{leftNode = new Node(leftVal);}

                if(map.containsKey(rightVal)){rightNode = map.get(rightVal);}
                else	{rightNode = new Node(rightVal);}

                leftNode.neighbours.put(rightNode, output);
                rightNode.neighbours.put(leftNode, 1/output);

                map.put(leftVal, leftNode);
                map.put(rightVal, rightNode);
            }
        }

        public void resetStates(){
            for(String key: map.keySet()){
                map.get(key).state = 0;
            }
        }
    }
}
