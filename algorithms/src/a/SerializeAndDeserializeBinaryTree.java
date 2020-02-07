/**
 * 297. Serialize and Deserialize Binary Tree
 */
package a;

import common.A;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@A
public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        TreeNode n11 = new TreeNode(5);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(3);
        TreeNode n14 = new TreeNode(2);
        TreeNode n15 = new TreeNode(4);
        TreeNode n16 = new TreeNode(3);
        TreeNode n17 = new TreeNode(1);
        n11.left = n12;
        n11.right = n13;
        n13.left = n14;
        n13.right = n15;
        n14.left = n16;
        n14.right = n17;

        SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
        codec.deserialize(codec.serialize(n11));
    }

    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr != null) {
                res.append(curr.val + " ");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                res.append("null ");
            }
        }

        return res.toString();
    }


    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] info = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(info[0]));
        queue.offer(root);

        for(int i = 1; i < info.length; i = i + 2) {
            TreeNode parent = queue.poll();

            int leftIndex = i;
            int rightIndex = i + 1;

            if(!info[leftIndex].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(info[leftIndex]));
                parent.left = left;
                queue.add(left);
            }
            if(!info[rightIndex].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(info[rightIndex]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    // this is wrong approach!!
    // some cases are not covered like 5 2 3 n n (n n) 2 4 3 1 n n
    public TreeNode deserialize2(String data) {
        if(data.equals("")) return null;

        String[] info = data.split(",");

        //left son : (now + 1) * 2 - 1;
        //right son : (now + 1) * 2
        //if, left son and right son's index is over the info array'length, quit!!
        TreeNode root = new TreeNode(Integer.valueOf(info[0]));
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        TreeNode[] nodes = new TreeNode[info.length];
        for(int i = 0; i < info.length; i++) {
            if(!info[i].equals("null")) {
                nodes[i] = new TreeNode(Integer.valueOf(info[i]));
            }
        }
        for(int i = 0; i < info.length; i++) {
            if(!info[i].equals("null")) {
                if((i + 1) * 2 - 1 < nodes.length) {
                    nodes[i].left = nodes[(i + 1) * 2 -1];
                }
                if((i + 1) * 2 < nodes.length) {
                    nodes[i].right = nodes[(i + 1) * 2];
                }
            }
        }

        return nodes[0];
    }
}
