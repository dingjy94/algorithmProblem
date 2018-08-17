/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        
        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        
        int remain = 0;
        ListNode head = null;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || remain != 0) {
            int sum = 0;
            
            if (!l1Stack.isEmpty()) {
                sum += l1Stack.pop();
            }
            
            if (!l2Stack.isEmpty()) {
                sum += l2Stack.pop();
            }
            
            sum += remain;
            remain = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            
            tmp.next = head;
            head = tmp;
        }
    
        
        return head;
    }
}
