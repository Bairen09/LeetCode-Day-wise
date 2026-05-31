class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0,count=0,product=1;
        for(int j=0;j<nums.length;j++){
            product*=nums[j];
            while(product>=k && i<=j){
                product=product/nums[i];
                i++;
            }
            count+=j-i+1;
        }
        return count;
    }
}