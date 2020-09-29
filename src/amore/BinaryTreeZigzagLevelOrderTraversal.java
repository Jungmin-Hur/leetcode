/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
package amore;

import common.A;
import common.Flip;

import java.util.*;

//level order question
@A
@Flip
public class BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        List<List<Integer>> res = zigzagLevelOrder(t1);
        for(List<Integer> list : res) {
            list.stream().forEach(item -> System.out.print(item + " "));
            System.out.println("");
        }

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(level % 2 == 1) { //reverse data
                Collections.reverse(list);
            }
            res.add(list);

            level++;
        }
        return res;
    }
}
