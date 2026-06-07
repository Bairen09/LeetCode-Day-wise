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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode listA=list1;
        ListNode listB=list1;
        for(int i=0;i<a-1;i++){
            listA=listA.next;
        }
        for(int i=0;i<=b;i++){
            listB=listB.next;
        }
        listA.next=list2;
        ListNode tail=list2;
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=listB;

        return list1;
    }
}