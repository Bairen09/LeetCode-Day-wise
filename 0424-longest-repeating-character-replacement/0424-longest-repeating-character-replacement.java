class Solution {
    public int characterReplacement(String s, int k) {
        int[]map=new int[26];
        int left=0;
        int maxFreq=0;
        int maxLength=0;
        for(int right=0;right<s.length();right++){
            map[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,map[s.charAt(right)-'A']);
            int candidate=(right-left+1)-maxFreq;
            
            if(candidate>k){
                map[s.charAt(left)-'A']--;
                left++;
            }
            maxLength=Math.max(right-left+1,maxLength);
        }
        return maxLength;
    }
}