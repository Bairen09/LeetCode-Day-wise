class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        int maxLeft=0, maxRight=0,count=0;
        while(left<=right){
            if(maxLeft<maxRight){
                maxLeft=Math.max(maxLeft, height[left]);
                count+=maxLeft-height[left];
                left++;
            }
            else{
                maxRight=Math.max(maxRight, height[right]);
                count+=maxRight-height[right];
                right--;
            }
        }
        return count;
    }
}