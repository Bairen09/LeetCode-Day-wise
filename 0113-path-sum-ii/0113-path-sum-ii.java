/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        helper(result,list,root,targetSum);
        return result;
    }
    public void helper(List<List<Integer>>result, List<Integer>list,TreeNode root, int targetSum){
        if(root==null){
            return;
        }
        list.add(root.val);
        targetSum-=root.val;
        boolean isLeaf= root.left==null && root.right==null;
        if(isLeaf && targetSum==0){
            result.add(new ArrayList<>(list));
        }
        else{
            helper(result,list,root.left,targetSum);
            helper(result,list,root.right,targetSum);
        }
        list.remove(list.size()-1);
    }
}