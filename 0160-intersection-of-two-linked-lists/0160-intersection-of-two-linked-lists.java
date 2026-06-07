/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alength=length(headA);
        int Blength=length(headB);
        ListNode A= headA;
        ListNode B=headB;
        if(Alength>Blength){
            int diff=Alength-Blength;
            for(int i=0;i<diff;i++){
                A=A.next;
            }
        }
        else{
            int diff2=Blength-Alength;
            for(int i=0;i<diff2;i++){
                B=B.next;
            }
        }
        while(A!=null && B!=null){
            if(A==B){
                return A;
            }
            A=A.next;
            B=B.next;
        }
        return null;
    }
    public int length(ListNode A){
        int len=0;
        while(A!=null){
            len++;
            A=A.next;
        }
        return len;
    }
}