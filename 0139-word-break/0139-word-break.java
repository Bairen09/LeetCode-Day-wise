class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>(wordDict);
        Boolean[]dp=new Boolean[s.length()];
        return solve(s,set,dp,0);
    }
    public boolean solve(String s,HashSet<String>set,Boolean[]dp,int start){
        if(start==s.length()){
            return true;
        }
        if(dp[start]!=null){
            return dp[start];
        }
        for(int end=start;end<s.length();end++){
            String piece=s.substring(start,end+1);
            if(set.contains(piece)&& solve(s,set,dp,end+1)){
                return dp[start]=true;
            }
        }
        return dp[start]=false;
    }
}