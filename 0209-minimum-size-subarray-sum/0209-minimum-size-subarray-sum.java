class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left=0,count=Integer.MAX_VALUE,sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];           
            while(sum>=target){
                count=Math.min(count,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return count<Integer.MAX_VALUE?count:0;
    }
}