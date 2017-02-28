/**
 * https://leetcode.com/problems/add-two-numbers/
 */

/**
 * Definition for singly-linked list.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.next == null && l1.val == 0 && l2.next == null && l2.val == 0){
            return l1;
        }
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {

        int l1Val = l1 == null ? 0 : l1.val;
        int l2Val = l2 == null ? 0 : l2.val;

        int sum = l1Val + l2Val + carry;
        if(sum == 0 && l1 == null && l2 == null){
            return null;
        }
        int newVal = sum % 10;
        carry = sum / 10;

        ListNode res = new ListNode(newVal);
        res.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return res;
    }

    public static void main(String[] args){
        AddTwoNumbers sol = new AddTwoNumbers();

        int[] l1Data = {0,8,8,8,8,2,9,3,1,1};
        int[] l2Data = {0,9,1,5,5,5,1,1,6};


        ListNode l1 = null;
        for(int i=l1Data.length-1; i>=0; i--){
            ListNode temp = new ListNode(l1Data[i]);
            temp.next = l1;
            l1 = temp;
        }

        ListNode l2 = null;
        for(int j=l2Data.length-1; j>=0; j--){
            ListNode temp = new ListNode(l2Data[j]);
            temp.next = l2;
            l2 = temp;
        }

        ListNode res = sol.addTwoNumbers(l1, l2);
        System.out.print(res.val);
        while(res.next != null){
            System.out.print(" -> " + res.next.val);
            res = res.next;
        }
        System.out.println();
    }
}