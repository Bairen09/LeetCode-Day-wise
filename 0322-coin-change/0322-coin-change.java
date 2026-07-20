class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-2);
        int result=solve(coins,amount,dp);
        return result;
    }
    public int solve(int[]coins, int amount,int[]dp){
        if(amount==0){
            return 0;
        }
        if(amount<=0){
            return -1;
        }
        if(dp[amount]!=-2){
            return dp[amount];
        }
        int best=Integer.MAX_VALUE;
        for(int c:coins){
            int ans=solve(coins,amount-c,dp);
            if(ans>=0){
                best=Math.min(best, ans+1);
            }
        }
        dp[amount]=(best==Integer.MAX_VALUE)?-1:best;
        return dp[amount];
    }
}