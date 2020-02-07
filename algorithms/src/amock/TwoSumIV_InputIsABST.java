/**
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
package amock;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV_InputIsABST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Input:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     * Target = 9
     * Output: True
     */
    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

        System.out.println(findTarget(t1, 1));
        System.out.println(findTarget(t1, 2));
        System.out.println(findTarget(t1, 3));
        System.out.println(findTarget(t1, 4));
        System.out.println(findTarget(t1, 5));
        System.out.println(findTarget(t1, 6));
        System.out.println(findTarget(t1, 7));
        System.out.println(findTarget(t1, 8));
        System.out.println(findTarget(t1, 9));
        System.out.println(findTarget(t1, 28));
    }

    /**
     * 전위(preorder), 중위(inorder), 후위(postorder) 순회는
     * root 노드를 기준으로 전위는 root 를 먼저, 중위는 root 를 중간에, 후위는 root 를
     * 마지막에 방문한다는 것임
     * 전위순회는 Depth First Search (깊이 우선 탐색, DFS) 라고도 부른다.
     * 전위순회인 DFS 는 전위표기법을 구하는데 사용할 수 있다.
     * 레벨순서 순회는 Breadth First Search (너비 우선 탐색, BFS) 라고도 부른다.
     * public void inOrderTraverse(Node focusNode) {
     *     if (focusNode != null) {
     *         inOrderTraverse(focusNode.leftChild);
     *         System.out.print(focusNode.key + " ");
     *         inOrderTraverse(focusNode.rightChild);
     *     }
     * }
     *
     * public void preOrderTraverse(Node focusNode) {
     *     if (focusNode != null) {
     *         System.out.print(focusNode.key + " ");
     *         preOrderTraverse(focusNode.leftChild);
     *         preOrderTraverse(focusNode.rightChild);
     *     }
     * }
     *
     * public void postOrderTraverse(Node focusNode) {
     *     if (focusNode != null) {
     *         postOrderTraverse(focusNode.leftChild);
     *         postOrderTraverse(focusNode.rightChild);
     *         System.out.print(focusNode.key + " ");
     *     }
     * }
     */

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list); //list sorted!!!

        int left = 0;
        int right = list.size() - 1;
        //using 2 pointer
        while(left <= right) {
            int target = k - list.get(left);
            if(list.get(right)== list.get(left)) { //duplicated number could not exist
                break;
            } else if(list.get(right) == target) {
                return true;
            } else {
                if(list.get(right) > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return false;
    }

    //inorder traversal of BST gives the nodes in ascending order
    public static void inorder(TreeNode root, List<Integer> list) {

        if(root==null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }

    public static boolean search(TreeNode root, int target) {
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val == target) return true;
            if(target > curr.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return false;
    }
}
