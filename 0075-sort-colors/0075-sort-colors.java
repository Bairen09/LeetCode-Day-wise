class Solution {
    public void sortColors(int[] nums) {
        int left=0, right=nums.length-1,i=0;
        while(i<=right){
            if(nums[i]==2){
                swap(i,right,nums);
                right--;
            }
            else if(nums[i]==0){
                swap(i,left,nums);
                left++;
                i++;
            }
            else{
                i++;
            }
        }
    }
    public void swap(int a, int b,int nums[]){
        int c=nums[a];
        nums[a]=nums[b];
        nums[b]=c;
    }
}