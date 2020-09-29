/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
package amore;

import common.A;

import java.util.PriorityQueue;

@A
public class MergeKSortedLists {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public static void main(String args[]) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(5);
        n11.next = n12;
        n12.next = n13;

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;

        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(6);
        n31.next = n32;

        ListNode ret = mergeKLists(new ListNode[]{n11, n21, n31});
        while(ret != null) {
            System.out.print(ret.val + "-> ");
            ret = ret.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((q1, q2) -> {
            return q1.val-q2.val;
        });

        for(ListNode list : lists) {
            if(list!=null)
                queue.offer(list);
        }

        ListNode node = new ListNode(-1);
        ListNode prev = node;
        while(!queue.isEmpty()) {
            ListNode curr = queue.poll();
            prev.next = curr;
            prev = prev.next;

            if(curr.next != null) {
                queue.offer(curr.next);
            }
        }
        return node.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(ListNode list : lists) {
            while(list != null) {
                queue.offer(list.val);
                list = list.next;
            }
        }

        ListNode node = new ListNode(-1);
        ListNode curr = node;
        while(!queue.isEmpty()) {
            int val = queue.poll();
            ListNode n = new ListNode(val);
            curr.next = n;
            curr = curr.next;
        }
        return node.next;
    }
}
