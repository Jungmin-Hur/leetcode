package flip;


public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0; //place value

        ListNode n1 = l1; ListNode n2 = l2;
        while(true) {
            if(n1 == null && n2 == null) break;

            int n = 0;
            if(n1 == null) { //if l1 is shorter then l2
                n = n2.val + carry;
                n2 = n2.next;
            } else if(n2 == null) { //if l2 is shorter than l1
                n = n1.val + carry;
                n1 = n1.next;
            } else {
                n = n1.val + n2.val + carry;
                n1 = n1.next;
                n2 = n2.next;
            }

            carry = 0;
            if(n >= 10) {
                n = n - 10;
                carry = 1;
            }

            temp.next = new ListNode(n);
            temp = temp.next;
        }

        if(carry == 1) { //if place value still exist
            temp.next = new ListNode(1);
        }
        return result.next;
    }
}
