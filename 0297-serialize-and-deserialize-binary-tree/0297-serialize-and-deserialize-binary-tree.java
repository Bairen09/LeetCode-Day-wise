/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        serHelper(root,sb);
        return sb.toString();
    }
    public void serHelper(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serHelper(node.left,sb);
        serHelper(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String>tokens=new LinkedList<>(Arrays.asList(data.split(",")));
        return desHelper(tokens);
    }
    public TreeNode desHelper(Queue<String>tokens){
        String val=tokens.poll();
        if(val.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=desHelper(tokens);
        node.right=desHelper(tokens);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));