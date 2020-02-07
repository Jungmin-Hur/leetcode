/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 */
package amore;

import common.A;

import java.util.Stack;

@A
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode ret = reverseList(n1);
        while(ret != null) {
            System.out.print(ret.val + " , ");
            ret = ret.next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode ret = new ListNode(-1);

        ListNode curr = head;
        while(curr != null) {
            ListNode temp = ret.next;
            curr.next = temp;
            ret.next = curr;
        }
        return ret.next;
    }

    //using stack version (8%)
    public static ListNode reverseListUsingStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        while(!stack.isEmpty()) {
            ListNode node = stack.pop();
            temp.next = node;
            node.next = null;
            temp = node;
        }
        return ret.next;
    }

}
