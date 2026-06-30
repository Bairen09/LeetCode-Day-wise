class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l=0;
        int m=0;
        int res=0;
        int odd=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]%2!=0){
                odd++;
            }
            while(odd>k){
                if(nums[l]%2!=0){
                    odd--;
                }
                l++;
            }
            if(odd==k){
                m=l;
                while(m < nums.length &&nums[m]%2==0){
                    m++;
                }
                res+=(m-l)+1;
            }
        }
        return res;
    }
}