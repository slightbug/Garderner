/*
2. Add Two Numbers

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

*/

/*
Similar to String case: start from least signification digit, if null then use 0
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode itr1 = l1, itr2 = l2, dummy = new ListNode(0), cur = dummy;
        int carry = 0, d1, d2, sum;
        
        while(itr1 != null || itr2 != null || carry == 1) {
            d1 = 0;
            d2 = 0;
            if(itr1 != null) {
                d1 = itr1.val;
                itr1 = itr1.next;
            }
            if(itr2 != null) {
                d2 = itr2.val;
                itr2 = itr2.next;
            }
            
            sum = d1 + d2 + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            
            carry = sum / 10;
        }
        
        return dummy.next;
    }
}
