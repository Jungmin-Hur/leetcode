/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */
package mylist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //2 pointers
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /* not optimized solution */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while(head != null) {
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
