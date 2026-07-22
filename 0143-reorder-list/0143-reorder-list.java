/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode front = head;

        //reverse it 

        ListNode next;
        ListNode prev = null;
        while(second!=null){
            next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        second = prev;

        while(second!=null){
            ListNode t1 = second.next;
            ListNode t2 = front.next;
            front.next = second;
            second.next = t2;

            second = t1;
            front = t2;
        }
        
    }
}