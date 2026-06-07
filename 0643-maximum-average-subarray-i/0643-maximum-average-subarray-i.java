class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0,right=0,sum=0;
        double avg=0,maxAvg=Integer.MIN_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            if(right-left==k-1){
                avg=(double)sum/k;
                sum-=nums[left];
                left++;
                maxAvg=Math.max(avg,maxAvg);
            }           
            right++;
        }
        return maxAvg;
    }
}