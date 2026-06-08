class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer>map1=new HashMap<>();
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int left=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            if(right-left+1==p.length()){
                if(map.equals(map1)){
                    result.add(left);
                }
                if(map.get(s.charAt(left))<=1){
                    map.remove(s.charAt(left));
                }
                else{
                    map.put(s.charAt(left), map.get(s.charAt(left))-1);
                }
                left++;
            }
        }
        return result;
    }
}