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
    public ListNode mergeKLists(ListNode[] lists) {
        //1.initialize a pq
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        //2. put all head of all lists in the pq
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        //3.dummy nodes to track
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        //4. while conditions
        while(!pq.isEmpty()){
            ListNode smallest=pq.poll();
            tail.next=smallest;
            tail=tail.next;

            //check next of it and add them in pq
            if(smallest.next!=null){
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
}