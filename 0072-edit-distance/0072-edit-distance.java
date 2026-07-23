class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(word1,word2,0,0,dp);
    }
    public int solve(String a, String b,int i,int j,int[][]dp){
        if(a.length()==i){
            return b.length()-j;
        }
        if(b.length()==j){
            return a.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        int first_two_minimum=0;
        if(a.charAt(i)==b.charAt(j)){
            return solve(a,b,i+1,j+1,dp);
        }
        else{
            int insert=1+solve(a,b,i,j+1,dp);
            int delete=1+solve(a,b,i+1,j,dp);
            int replace=1+solve(a,b,i+1,j+1,dp);
            first_two_minimum=Math.min(insert,delete);
            ans=Math.min(first_two_minimum,replace);
        }
        return dp[i][j]=ans;
    }
}