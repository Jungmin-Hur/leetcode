package sample; /**
 * 445. Add Two Numbers II
 * https://leetcode.com/problems/add-two-numbers-ii/
 */

import common.Sample;

import java.util.Stack;

@Sample
public class AddTwoNumbersII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public void next(ListNode a2) {
            this.next = a2;
        }
    }

    /**
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     */
    public static void main(String args[] ) {
        ListNode a1 = new ListNode(7);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next(a2);
        a2.next(a3);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next(b2);
        b2.next(b3);

        ListNode ret = addTwoNumbers(a1, b1);
        while(ret != null) {
            System.out.print(ret.val + ",");
            ret = ret.next;
        }
        System.out.println("");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        Stack<Integer> stack = new Stack<>();

        int carry = 0;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            int n1 = s1.pop();
            int n2 = s2.pop();
            stack.push((n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
        }

        while(!s1.isEmpty()) {
            int n = s1.pop();
            stack.push((n + carry)%10);
            carry = (n+carry)/10;
        }
        while(!s2.isEmpty()) {
            int n = s2.pop();
            stack.push((n + carry)%10);
            carry = (n+carry)/10;
        }
        if(carry > 0) {
            stack.push(carry);
        }

        ListNode retVal = new ListNode(-1);
        ListNode ans = retVal;

        while(!stack.isEmpty()) {
            ListNode item = new ListNode(stack.pop());
            ans.next = item;
            ans = ans.next;
        }

        return retVal.next;
    }
}
