class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(text1,text2,0,0,dp);
    }
    public int solve(String a,String b,int i,int j,int dp[][]){
        if(a.length()==i){
            return 0;
        }
        if(b.length()==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(a.charAt(i)==b.charAt(j)){
            ans=1+solve(a,b,i+1,j+1,dp);
        }
        else{
            ans=Math.max(solve(a,b,i+1,j,dp),solve(a,b,i,j+1,dp));
        }
        return dp[i][j]=ans;
    }
}
