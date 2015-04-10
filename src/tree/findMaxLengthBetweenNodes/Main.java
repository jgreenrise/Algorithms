package tree.findMaxLengthBetweenNodes;

import java.util.LinkedList;
import java.util.ListIterator;


/*-
 * 
 * 				1
 * 			4		7
 * 		20
 * 40
 * 	
 * 
 */
public class Main {

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n17 = new Node(17);
		Node n4 = new Node(4);
		Node n20 = new Node(20);
		Node n40 = new Node(40);

		LinkedList<Node> childNodes = new LinkedList<Node>();
		childNodes.add(n4);
		childNodes.add(n17);
		n1.setChildNodes(childNodes);

		childNodes = new LinkedList<Node>();
		childNodes.add(n20);
		n4.setChildNodes(childNodes);

		childNodes = new LinkedList<Node>();
		childNodes.add(n40);
		n20.setChildNodes(childNodes);

		System.out.println(findMaxLengthBetweenNodes(n1, n40, 0));

	}

	private static int findMaxLengthBetweenNodes(Node nodeA, Node nodeB, int i_numberOfNodesVisited) {

		int max = 0;
		int base = 0;

		if (nodeA != null && nodeB != null) {
			
			if(nodeA.getChildNodes() != null){
				ListIterator<Node> nodes = nodeA.getChildNodes().listIterator();

				while (nodes.hasNext()) {
					Node node = nodes.next();
					if (node == nodeB) {
						base = i_numberOfNodesVisited;
						System.out.println(base);
						break;
					} else {
						findMaxLengthBetweenNodes(node, nodeB, ++i_numberOfNodesVisited);
					}
				}
			}
		}else{
			return 0;
		}

		// TODO Auto-generated method stub
		return base;
	}

}
