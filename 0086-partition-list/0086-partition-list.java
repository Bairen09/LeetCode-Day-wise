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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy=head;
        ListNode small=new ListNode(0);
        ListNode temp1=small;
        ListNode large= new ListNode(0);
        ListNode temp2=large;
        while(dummy!=null){
            if(dummy.val<x){
                temp1.next=dummy;
                temp1=dummy;
            }
            else{
                temp2.next=dummy;
                temp2=dummy;
            }
            dummy=dummy.next;
        }
        temp1.next=large.next;
        temp2.next=null;

        return small.next;
    }
}