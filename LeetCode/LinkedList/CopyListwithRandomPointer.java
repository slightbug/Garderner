/*
138. Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

*/

/*
Idea: 
M1: 
1. Using a hashmap to keep new node (value) corresponding to original node (key) 
2. Traverse again, and set the random and next: dict.get(*).next = dict.get(*.next);

M2:
1. Since we need to know the node location when we set random for cloned list, 
   then we can insert the copied node after the original node
2. Traverse again, and set the random: check null before every *.next
3. Seperate the new list from the original list: using a dummy header

*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /*public RandomListNode copyRandomList(RandomListNode head) {
        // Assume: 
        // 1. no cycle. 2. No additional nodes linked through random. 
        // 3. RnadomListNode class has funtions of hasCode() and overrided equals():
        // if not, maintain an integer count to identify that node and use this integer as key for HashMap
        
        Map<RandomListNode, RandomListNode> dict = new HashMap<>();
        
        RandomListNode cur = head;
        
        while(cur != null) {
            dict.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null) { // there has to be another round to link random: can't link before create these nodes
            dict.get(cur).next = dict.get(cur.next);    // key
            dict.get(cur).random = dict.get(cur.random);
            cur = cur.next;
        }
        
        return head == null ? null : dict.get(head);
    }*/
    
    // high vote solution:
    // https://discuss.leetcode.com/topic/7594/a-solution-with-constant-space-complexity-o-1-and-linear-time-complexity-o-n
    
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = head, res, temp;
        
        while(cur != null) {
            temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next; // key
            }
            
            cur = cur.next.next;
        }
        
        cur = head;
        temp = dummy;
        while(cur != null) {
            temp.next = cur.next;
            temp = temp.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}
