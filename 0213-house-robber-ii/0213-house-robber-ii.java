class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int caseA = robLinear(nums, 0, n - 2);   // exclude last house
        int caseB = robLinear(nums, 1, n - 1);   // exclude first house
        return Math.max(caseA, caseB);
    }
    
    // Tabulated House Robber I, but over an arbitrary range [start, end]
    private int robLinear(int[] nums, int start, int end) {
        if (start > end) return 0;           // empty range
        if (start == end) return nums[start]; // single house in range
        
        int[] dp = new int[end + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[end];
    }
}

// class Solution {
//     public int rob(int[] nums) {
//         int n=nums.length;
//         if(n==1){
//             return nums[0];
//         }
//         int dp[]= new int[n];
//         int dp2[]=new int[n];
//         Arrays.fill(dp,-1);
//         Arrays.fill(dp2,-1);
//         int first=solve(nums,n-2,0,dp);
//         int sec=solve(nums,n-1,1,dp2);
//         return Math.max(first,sec);
//     }
//     public int solve(int[]nums,int n,int a,int[]dp){
//         if(n<a){
//             return 0;
//         }
//         if(n==a){
//             return nums[a];
//         }
//         if(dp[n]!=-1){
//             return dp[n];
//         }
//         int inc=solve(nums,n-2,a,dp)+nums[n];
//         int exc=solve(nums,n-1,a,dp);
//         return dp[n]=Math.max(inc,exc);
//     }
// }