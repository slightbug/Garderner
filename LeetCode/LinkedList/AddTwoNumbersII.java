/*
445. Add Two Numbers II

You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

*/

/*
Similar to I, but use two stacks to store the numbers.
1. Carry  can be directly recorded by sum/10 in next iteration.
2. Need one node to keep the new head.

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
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        int d1, d2, sum, carry = 0;
        ListNode dummy = new ListNode(0), itr;

        itr = l1;
        while(itr != null) {
            stack1.push(itr.val);
            itr = itr.next;
        }

        itr = l2;
        while(itr != null) {
            stack2.push(itr.val);
            itr = itr.next;
        }

        while(!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            d1 = !stack1.isEmpty() ? stack1.pop() : 0;
            d2 = !stack2.isEmpty() ? stack2.pop() : 0;
            sum = d1 + d2 + carry;
            itr = new ListNode(sum % 10);
            itr.next = dummy.next;
            dummy.next = itr;
            carry = sum / 10;
        }

        return dummy.next;
    }
}