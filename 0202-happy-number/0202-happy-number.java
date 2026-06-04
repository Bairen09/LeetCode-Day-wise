class Solution {
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        while(true){
            slow=next(slow);
            fast=next(next(fast));
            if(fast==1){
                return true;
            }
            if(slow==fast){
                return false;
            }
        }
    }
    public int next(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum+=digit*digit;
            n=n/10;
        }
        return sum;
    }
}