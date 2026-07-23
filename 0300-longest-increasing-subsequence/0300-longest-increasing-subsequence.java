class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,n,0,-1,dp);
    }
    public int solve(int[]nums,int n,int curr,int prev,int dp[][]){
        if(curr==n){
            return 0;
        }
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }
        int take=0;
        if(prev==-1|| nums[curr]>nums[prev]){
            take=1+solve(nums,n,curr+1,curr,dp);
        }
        int notTake=solve(nums,n,curr+1,prev,dp);
        return dp[curr][prev+1]=Math.max(take,notTake);
    }
}