class Solution {
    public int findDuplicate(int[] nums) {
        int fast=0,slow=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(fast!=slow);
        int start=0;
        while(start!=slow){
            slow=nums[slow];
            start=nums[start];
        }
        return start;
    }
}