class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
        for(int pile:piles){
            right=Math.max(right,pile);
        }
        int result=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canEat(piles,h,mid)){
                result= mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }
        return result;
    }
    public boolean canEat(int[]piles, int h, int hrs){
        int count=0;
        for(int i=0;i<piles.length;i++){
            count+=(long)Math.ceil((double)piles[i]/hrs);
            if(count>h){
                return false;
            }
        }
        return count<=h;
    }
    
}