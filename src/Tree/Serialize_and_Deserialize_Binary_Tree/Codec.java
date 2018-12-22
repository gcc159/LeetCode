package Tree.Serialize_and_Deserialize_Binary_Tree;


import Util.TreeNode;

public class Codec {
    String res;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }
    private void helper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#|");
            return;
        }
        sb.append(root.val);
        sb.append("|");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String []vals=data.split(" ");
        if(vals[0].equals("#")) return null;
        TreeNode root=new TreeNode(Integer.valueOf(vals[0]));
        int next=deHelper(vals,1,root,true);
        deHelper(vals,next,root,false);
        return root;

    }
    private int deHelper(String[] vals,int currentIndex,TreeNode parent,boolean isLeft){
        if(vals[currentIndex].equals("#")){
            if(isLeft)
                parent.left=null;
            else
                parent.right=null;
            return currentIndex+1;
        }else{
            TreeNode current=new TreeNode(Integer.valueOf(vals[currentIndex]));
            int nextIndex=deHelper(vals,currentIndex+1,current,true);
            nextIndex=deHelper(vals,nextIndex,current,false);
            if(isLeft)
                parent.left=current;
            else
                parent.right=current;
            return nextIndex;
        }
    }
}
