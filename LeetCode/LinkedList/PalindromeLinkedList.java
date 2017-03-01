/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*public boolean isPalindrome(ListNode head) {
        // basic idea: reverse the first half, make a comparison, then recover
        if(head == null || head.next == null) {
            return true;
        }

        ListNode scanner = head, scanner2 = head.next, newHead = null, newHead2 = null, next = null;
        boolean oddFlag = true, res = true;
        while(scanner2 != null) {
            next = scanner.next;
            scanner.next = newHead;
            newHead = scanner;
            scanner = next;

            scanner2 = scanner2.next;
            if(scanner2 != null) {
                scanner2 = scanner2.next;
            }
            else {
                oddFlag = false;
            }
        }

        newHead2 = next;
        next = null;
        head = newHead2;
        scanner = newHead;
        scanner2 = newHead2;
        if(oddFlag) {
            scanner2 = scanner2.next;
        }

        while(scanner2 != null) {
            if(scanner.val != scanner2.val) {
                res = false;
            }
            next = scanner.next;
            scanner.next = head;
            head = scanner;
            scanner = next;
            scanner2 = scanner2.next;
        }
        return res;
    }*/

    // it's better to reverse the second half: no need to consider the connectivity
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode scanner = head, scanner2 = head.next;
        while(scanner2 != null && scanner2.next != null) {
            scanner = scanner.next;
            scanner2 = scanner2.next.next;
        }

        scanner = scanner.next; // locate the start point of the second half of the list
        scanner2 = reverseList(scanner);
        scanner = scanner2;

        while(scanner2 != null) {
            if(scanner2.val != head.val) {
                return false;
            }
            head = head.next;
            scanner2 = scanner2.next;
        }

        reverseList(scanner); // it's better to recover the list
        return true;
    }

    private ListNode reverseList(ListNode p) {
        ListNode head = null, next = null;
        while(p != null) {
            next = p.next;
            p.next = head;
            head = p;
            p = next;
        }
        return head;
    }

    // similar solution: https://leetcode.com/discuss/45656/easy-understand-java-solution-o-1-space-cost
    // a good recursive method - using recursion as a stack: https://leetcode.com/discuss/65043/my-easy-understand-c-solution
    // again recursion is slower, and this will take O(n) space

    /*private ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return isPalindromeHelper(head);
    }

    private boolean isPalindromeHelper(ListNode p) {
        if(p == null) {
            return true;
        }
        boolean res = isPalindromeHelper(p.next) && (p.val == front.val);
        front = front.next;
        return res;
    }*/

}