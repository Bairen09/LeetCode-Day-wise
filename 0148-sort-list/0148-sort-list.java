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
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }
        System.out.println(head.val);
        ListNode mid=middle(head);
        ListNode right=mid.next;
        mid.next=null;

        ListNode left=sortList(head);
        right=sortList(right);
        return merge(left, right);
    }
    public ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&& fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode result1=new ListNode(-1);
        ListNode result=result1;
        while(left!=null && right!=null){
            if(right.val>left.val){
                result.next=left;
                left=left.next;
            }
            else{
                result.next=right;
                right=right.next;
            }
            result=result.next;
        }
        if(left!=null){
            result.next=left;
        }
        if(right!=null){
            result.next=right;
        }
        return result1.next;
    }
}