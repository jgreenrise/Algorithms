package tree.problems;

import java.util.*;

import static java.util.Arrays.*;

public class FindUnlockPatterns {

    static PreviousIntValue previousIntValue = null;

    public static class PreviousIntValue {
        int val;

        public PreviousIntValue(int val) {
            this.val = val;
        }
    }

    public static class TreeNode {
        int val;
        ArrayList<TreeNode> siblings;

        // <Distant Sibling, Parent>
        HashMap<String, String> distantSiblings;

        TreeNode(int x) {
            val = x;
            siblings = new ArrayList<TreeNode>();
            distantSiblings = new HashMap<>();
        }

        public int getVal(){
            return this.val;
        }

        public void siblings(List iSiblings) {
            this.siblings.addAll(iSiblings);
        }

        public ArrayList getSiblings(){
            return siblings;
        }


        public void distantSiblings(HashMap<String, String> distantSiblings) {
            this.distantSiblings = distantSiblings;
        }
    }

    public static void main(String args[]) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        // Corner Node
        node1.siblings(asList(node2, node4, node5));
        node3.siblings(asList(node2, node5, node6));
        node7.siblings(asList(node4, node5, node8));
        node9.siblings(asList(node6, node5, node8));

        // Outer Middle Node
        node2.siblings(asList(node1, node4, node5, node3, node6));
        node4.siblings(asList(node1, node2, node5, node7, node8));
        node6.siblings(asList(node3, node2, node5, node9, node8));
        node8.siblings(asList(node4, node5, node7, node9, node6));

        // Center Node
        node5.siblings(asList(node1, node2, node3, node4, node6, node7, node8, node9));

        // Corner Node > Distant Node
        HashMap distantSiblings = new HashMap();
        distantSiblings.put(3,2);
        distantSiblings.put(7,4);
        distantSiblings.put(9,5);
        node1.distantSiblings(distantSiblings);

        distantSiblings = new HashMap();
        distantSiblings.put(9,6);
        distantSiblings.put(9,5);
        distantSiblings.put(7,4);
        distantSiblings.put(7,5);
        distantSiblings.put(8,4);
        distantSiblings.put(8,5);
        distantSiblings.put(8,6);
        node2.distantSiblings(distantSiblings);

        distantSiblings = new HashMap();
        distantSiblings.put(1,2);
        distantSiblings.put(4,2);
        distantSiblings.put(4,5);
        distantSiblings.put(8,5);
        distantSiblings.put(8,6);
        distantSiblings.put(9,6);
        distantSiblings.put(9,5);
        node3.distantSiblings(distantSiblings);

        System.out.println(getTotalNumberOfUnLockPatterns(2, node1, node2, node5));




    }

    private static int getTotalNumberOfUnLockPatterns(int n, TreeNode corNode, TreeNode midNode, TreeNode centNode) {
        return(
                // Corner Nodes
                dfs(corNode, new LinkedHashSet(Arrays.asList(String.valueOf(corNode.val))), n, corNode)  * 4 +

                // Middle Nodes
                dfs(midNode, new LinkedHashSet(Collections.singletonList(String.valueOf(midNode.val))), n, midNode) * 4  +

                // Center Node
                dfs(centNode, new LinkedHashSet(Collections.singletonList(String.valueOf(centNode.val))), n, centNode) * 1);

    }

    //                  dfs(2, (1,2), )
    private static int dfs(TreeNode node, LinkedHashSet<String> ignoreList, int lengthOfKey, TreeNode primaryNode) {

        int totComb = 0;

        if (lengthOfKey > 1) {
            int i = 0;
            while (i < node.getSiblings().size()) {

                // Get sibling node // 2
                TreeNode siblingNode = (TreeNode) node.getSiblings().get(i);

                // Add to ignore list
                if (!ignoreList.contains(String.valueOf(siblingNode.val))) {


                    ignoreList.add(String.valueOf(siblingNode.val));

                    // Get count from siblings
                    totComb = totComb + dfs(siblingNode, ignoreList, lengthOfKey - 1, primaryNode);

                    ignoreList.remove(String.valueOf(siblingNode.val));
                }

                i++;


            }
        }else {
            // If length of key = 1
            StringBuilder out = new StringBuilder();
            for (String val: ignoreList) {
                out.append(val + ",");
            }

            System.out.println(primaryNode.getVal() + " >> " +out);

            return 1;
        }

        return totComb;
    }





}
