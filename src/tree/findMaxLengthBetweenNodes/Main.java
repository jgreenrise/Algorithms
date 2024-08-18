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

		CustomNode n1 = new CustomNode(1);
		CustomNode n17 = new CustomNode(17);
		CustomNode n4 = new CustomNode(4);
		CustomNode n20 = new CustomNode(20);
		CustomNode n40 = new CustomNode(40);

		LinkedList<CustomNode> childNodes = new LinkedList<CustomNode>();
		childNodes.add(n4);
		childNodes.add(n17);
		n1.setChildNodes(childNodes);

		childNodes = new LinkedList<CustomNode>();
		childNodes.add(n20);
		n4.setChildNodes(childNodes);

		childNodes = new LinkedList<CustomNode>();
		childNodes.add(n40);
		n20.setChildNodes(childNodes);

		System.out.println(findMaxLengthBetweenNodes(n1, n40, 0));

	}

	private static int findMaxLengthBetweenNodes(CustomNode nodeA, CustomNode nodeB, int i_numberOfNodesVisited) {

		int max = 0;
		int base = 0;

		if (nodeA != null && nodeB != null) {
			
			if(nodeA.getChildNodes() != null){
				ListIterator<CustomNode> nodes = nodeA.getChildNodes().listIterator();

				while (nodes.hasNext()) {
					CustomNode node = nodes.next();
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
