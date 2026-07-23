class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result=new ArrayList<>();
        List<String>current=new ArrayList<>();
        backtrack(s,0,result,current);
        return result;
    }
    public void backtrack(String s, int start,List<List<String>>result,List<String>current){
        if(s.length()==start){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(isPalindrome(s,start,end)){
                current.add(s.substring(start,end+1));
                backtrack(s,end+1,result,current);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}