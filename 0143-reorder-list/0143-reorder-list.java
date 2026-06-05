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
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=slow.next;
        slow.next=null;
        slow=secondHalf;
        ListNode prev=null;
        while(slow!=null){
            ListNode nextNode=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nextNode;
        }
        ListNode temp=head;
        while(prev!=null){
            ListNode next1=temp.next;
            ListNode next2=prev.next;

            temp.next=prev;
            prev.next=next1;

            temp=next1;
            prev=next2;
        }
    }
}