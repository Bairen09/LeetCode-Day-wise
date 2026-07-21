class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve(amount,n-1,coins,dp);
    }
    public int solve(int amount,int i, int[]coins,int[][]dp){
        if(amount==0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(coins[i]>amount){
            return solve(amount,i-1,coins,dp);
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int take=solve(amount-coins[i],i,coins,dp);
        int not_take=solve(amount,i-1,coins,dp);
        return dp[i][amount]=take+not_take;
        
    }
}