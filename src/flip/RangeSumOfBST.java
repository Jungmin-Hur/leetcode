/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 */
package flip;

import common.Flip;

import java.util.Stack;

/**
 * https://leetcode.com/problems/range-sum-of-bst/discuss/509240/Simple-java-solution-comparing-stack-and-recursion-version
 * I implemented 2 kinds of code using the BFS.
 * First one is recursive version and second one is stack version.
 * Using a recursion is much faster than using a stack.(recursion version : 100%, stack version : 15%)
 * The time complexity of Stack insertion(push) and deletion(pop) is O(constant) theoretically,
 * but it seem to be some overhead on stack.
 */
@Flip
public class RangeSumOfBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        // return rangeSumBSTWithRecursive(root, L, R, 0);
        return rangeSumBSTWithQueue(root, L, R);
    }

    public int rangeSumBSTWithRecursive(TreeNode root, int L, int R, int res) { //100%
        if(root != null) {
            if(root.val >= L && root.val <= R) res += root.val;
            if(root.val > L) res = rangeSumBSTWithRecursive(root.left, L, R, res);
            if(root.val < R) res = rangeSumBSTWithRecursive(root.right, L, R, res);
        }
        return res;
    }

    public int rangeSumBSTWithQueue(TreeNode root, int L, int R) { //15%
        int res = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node != null) {
                if(node.val >= L && node.val <= R) res = res + node.val;
                if(L < node.val) stack.push(node.left);
                if(node.val < R) stack.push(node.right);
            }
        }
        return res;
    }
}
