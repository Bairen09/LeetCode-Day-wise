class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        HashMap<Character,Integer>map1=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer>map=new HashMap<>();
        int left=0;
        for(int right=0;right<s2.length();right++){
            char c=s2.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            if(right-left+1==s1.length()){
                char ch=s2.charAt(left);
                if(map.equals(map1)){
                    return true;
                }
                if(map.get(ch)<=1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.get(ch)-1);
                }
                left++;
            }
        }
        return false;
    }
}