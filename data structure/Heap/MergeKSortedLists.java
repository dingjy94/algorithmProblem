/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> comp = new Comparator<ListNode>() {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    };
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), comp);
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.offer(lists.get(i));
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode head = pq.poll();
            if (head.next != null) {
                pq.offer(head.next);
            }
            cur.next = head;
            cur = head;
        }
        
        return tmp.next;
    }
}
