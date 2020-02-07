package a;

import common.A;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
@A
public class MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        ListNode n11 = new ListNode(2);
//        ListNode n12 = new ListNode(2);
//        ListNode n13 = new ListNode(4);
//        n11.next = n12;
//        n12.next = n13;

        ListNode n21 = new ListNode(1);
//        ListNode n22 = new ListNode(3);
//        ListNode n23 = new ListNode(4);
//        n21.next = n22;
//        n22.next = n23;

        ListNode result = mergeTwoLists(n11, n21);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode retVal = new ListNode(-1);
        ListNode curr = retVal;
        while(true) {
            if(l1==null && l2==null) break;
            if(l1==null) {
                curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2 = l2.next;
                continue;
            } else if(l2==null) {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1 = l1.next;
                continue;
            }

            if(l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1 = l1.next;
            } else if(l1.val > l2.val) {
                curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2 = l2.next;
            } else {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1 = l1.next;
                curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2 = l2.next;
            }
        }

        return retVal.next;
    }

}
