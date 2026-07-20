class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int dp[]= new int[n];
        int dp2[]=new int[n];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        int first=solve(nums,n-2,0,dp);
        int sec=solve(nums,n-1,1,dp2);
        return Math.max(first,sec);
    }
    public int solve(int[]nums,int n,int a,int[]dp){
        if(n<a){
            return 0;
        }
        if(n==a){
            return nums[a];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int inc=solve(nums,n-2,a,dp)+nums[n];
        int exc=solve(nums,n-1,a,dp);
        return dp[n]=Math.max(inc,exc);
    }
}