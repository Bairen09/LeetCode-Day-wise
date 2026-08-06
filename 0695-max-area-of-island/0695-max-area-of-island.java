class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int count=0;
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count=dfs(grid,i,j);
                    max=Math.max(max,count);
                }
            }
        }
        return max;
    }
    public int dfs(int grid[][],int i,int j){
        if(!isValid(grid,i,j)){
            return 0;
        }
        grid[i][j]=0;
        return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
    }
    public boolean isValid(int grid[][],int i,int j){
        return i>=0&&i<grid.length&& j>=0&& j<grid[0].length && grid[i][j]==1;
    }
}