package flip;

import common.Flip;

import java.util.HashMap;
import java.util.Map;

@Flip
class CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String args[]) {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        Node copied = copyRandomList(n0);
        System.out.println("333");
    }

    public static Node copyRandomList(Node head) {
        //key : old node
        //value : new node
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr!=null) {
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while(curr!=null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}