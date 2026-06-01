class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set= new HashSet<>();
        int left=0,right=0,count=0;
        while(right<s.length()){
            while(set.contains(s.charAt(right)) && left<right){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            
            count=Math.max(count, right-left+1);
            right++;
        }
        return count;
    }
}