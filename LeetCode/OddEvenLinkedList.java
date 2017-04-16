class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        // 1 2 3 4 5 6 7 8 9
        // 1 3 5 7 9 2 4 6 8

        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode insertPos = head;
        ListNode preOddPos = head.next;

        while(preOddPos != null && preOddPos.next != null){
            ListNode oddPos = preOddPos.next;
            ListNode postOddPos = oddPos.next;
            ListNode postInsertPos = insertPos.next;

            preOddPos.next = postOddPos;
            insertPos.next = oddPos;
            oddPos.next = postInsertPos;

            insertPos = insertPos.next;
            preOddPos = (postOddPos == null ) ? null : postOddPos;
        }

        return head;
    }

    public void showList(ListNode root){
        ListNode n = root;
        while(n != null){
            System.out.print(n.val+ " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OddEvenLinkedList sol = new OddEvenLinkedList();

        ListNode root = sol.new ListNode(1);
        root.next = sol.new ListNode(2);
        root.next.next = sol.new ListNode(3);
        root.next.next.next = sol.new ListNode(4);
        root.next.next.next.next = sol.new ListNode(5);
        root.next.next.next.next.next = sol.new ListNode(6);

        sol.showList(root);
        root = sol.oddEvenList(root);
        sol.showList(root);
    }
}