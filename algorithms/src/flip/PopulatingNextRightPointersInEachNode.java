/**
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
package flip;

import common.Flip;

import java.util.LinkedList;
import java.util.Queue;

@Flip
public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if(root == null) return null;

        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int size = queue.size();

            Node tnode;
            Node pretnode = null;
            for(int i=0; i<size; i++) {
                tnode = queue.poll();
                if(tnode.left != null) {
                    queue.offer(tnode.left);
                }
                if(tnode.left != null) {
                    queue.offer(tnode.right);
                }

                if(pretnode != null && i > 0) {
                    pretnode.next = tnode;
                }
                pretnode = tnode;
            }
        }

        return root;
    }

}
