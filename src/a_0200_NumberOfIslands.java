import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a_0200_NumberOfIslands {

    public static void main(String args[]) {
        CustomNode n1 = new CustomNode(1);
        CustomNode n2 = new CustomNode(2);
        CustomNode n3 = new CustomNode(3);
        CustomNode n4 = new CustomNode(4);
        CustomNode n5 = new CustomNode(5);
        CustomNode n6 = new CustomNode(6);
        CustomNode n7 = new CustomNode(7);
        CustomNode n8 = new CustomNode(8);
        CustomNode n9 = new CustomNode(9);
        CustomNode n10 = new CustomNode(10);
        CustomNode n11 = new CustomNode(11);
        CustomNode n12 = new CustomNode(12);

        n1.addAssosciatedNodes(n2);
        n1.addAssosciatedNodes(n3);
        n1.addAssosciatedNodes(n4);

        n2.addAssosciatedNodes(n5);
        n2.addAssosciatedNodes(n6);

        n5.addAssosciatedNodes(n9);
        n5.addAssosciatedNodes(n10);

        n4.addAssosciatedNodes(n7);
        n4.addAssosciatedNodes(n8);

        n7.addAssosciatedNodes(n11);
        n7.addAssosciatedNodes(n12);

        a_0200_NumberOfIslands graph = new a_0200_NumberOfIslands();
        graph.breadthFirstSearch(n1, n7);
        CustomNode n50 = new CustomNode(50);
        graph.breadthFirstSearch(n1, n50);
    }

    public void breadthFirstSearch(CustomNode rootNode, CustomNode nodeToBeFound) {

        Queue<CustomNode> q = new LinkedList<CustomNode>();
        q.add(rootNode);
        rootNode.isVisited = true;

        while (!q.isEmpty()) {
            CustomNode node = q.poll();
            for (CustomNode adjNode : node.adjacentNodes) {
                if (adjNode == nodeToBeFound) {
                    System.out.println("Node is found");
                    break;
                }
                if (!adjNode.isVisited) {
                    System.out.println("Child node: " + adjNode.value);
                    adjNode.isVisited = true;
                    q.add(adjNode);
                }
            }
        }
    }

    public static class CustomNode {

        public int value;
        public boolean isVisited = false;
        public List<CustomNode> adjacentNodes = new LinkedList<CustomNode>();

        public CustomNode(int value) {
            this.value = value;
        }

        public void addAssosciatedNodes(CustomNode node) {
            adjacentNodes.add(node);
            node.adjacentNodes.add(this);
        }

    }

}
