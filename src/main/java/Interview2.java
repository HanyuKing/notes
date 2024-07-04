import com.fasterxml.jackson.databind.exc.InvalidNullException;

public class Interview2 {
    public static void main(String[] args) {
        /**
         * 1->2-2->3
         * 3->6->7
         *
         * 1->2->3->4->5->6->7
         */

        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(2, null);
        Node n4 = new Node(3, null);
        Node n5 = new Node(3, null);
        Node n6 = new Node(6, null);
        Node n7 = new Node(7, null);
        Node head1 = n1;
        Node head2 = n5;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;

        Node result = merge(head1, head2);

        while (result != null) {
            System.out.print(result.val + " ");
            //result =  result.next;
        }
        System.out.println();
    }

    public static Node merge(Node head1, Node head2) {
        Node newHead = new Node(-1, null);
        Node newHeadTemp = newHead;
        Node headPre1 = null;
        Node headPre2 = null;

        while (head1 != null || head2 != null) {
            if (head1 != null && head2 == null) {
                if (headPre1 != null && head1.val == headPre1.val) {
                    headPre1 = head1;
                    head1 = head1.next;
                    continue;
                }
                Node n = new Node(head1.val, null);
                newHead.next = n;
                newHead = n;
                headPre1 = head1;
                head1 = head1.next;
            } else if (head1 == null && head2 != null) {
                if (headPre2 != null && head2.val == headPre2.val) {
                    headPre2 = head2;
                    head2 = head2.next;
                    continue;
                }
                Node n = new Node(head2.val, null);
                newHead.next = n;
                newHead = n;
                headPre2 = head2;
                head2 = head2.next;
            } else {
                int val1 = head1.val;
                int val2 = head2.val;
                if (val1 > val2) {
                    if (headPre2 != null && head2.val == headPre2.val) {
                        headPre2 = head2;
                        head2 = head2.next;
                        continue;
                    }
                    Node n = new Node(head2.val, null);
                    newHead.next = n;
                    newHead = n;
                    headPre2 = head2;
                    head2 = head2.next;
                } else if (val1 < val2) {
                    if (headPre1 != null && head1.val == headPre1.val) {
                        headPre1 = head1;
                        head1 = head1.next;
                        continue;
                    }
                    Node n = new Node(head1.val, null);
                    newHead.next = n;
                    newHead = n;
                    headPre1 = head1;
                    head1 = head1.next;
                } else {
                    head2 = head2.next;
                }
            }

        }

        return newHeadTemp.next;
    }
}


class Node {
    int val;
    Node next;
    public Node(){}

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}