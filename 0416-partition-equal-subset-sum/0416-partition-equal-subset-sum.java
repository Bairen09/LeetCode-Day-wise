class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        int n=nums.length;
        for(int num:nums){
            total+=num;
        }
        int target=total/2;
        if(total%2!=0){
            return false;
        }
        int dp[][]= new int[n][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,dp,n-1,target);
    }
    public boolean solve(int[]nums,int[][]dp,int n,int target){
        if(target==0){
            return true;
        }
        if(n<0||target<0){
            return false;
        }
        if(dp[n][target]!=-1){
            return dp[n][target]==1;
        }
        boolean exc=solve(nums,dp,n-1,target);
        boolean inc=solve(nums,dp,n-1,target-nums[n]);
        boolean result=inc||exc;
        dp[n][target]=result?1:0;
        return result;
    }
}