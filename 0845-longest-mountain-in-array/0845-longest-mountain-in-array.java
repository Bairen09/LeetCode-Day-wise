class Solution {
    public int longestMountain(int[] arr) {
        int left=0,right=0,max=0,count=0;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i-1]&& arr[i]>arr[i+1]){
                left=i; right=i;
                while(left>0 && arr[left]>arr[left-1]){
                    left--;
                }
                while(right<arr.length-1 && arr[right]>arr[right+1]){
                    right++;
                }
                count=right-left+1;
                max=Math.max(max,count);
            }
        }
        return max<3?0:max;
    }
}