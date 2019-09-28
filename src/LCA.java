

class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int value) {
			this.value = value;
			left = null;
			right = null;
		}
			
			
}

public class LCA {


	public  static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if( root == null)           return null;
        if( root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        
        if(left == null)        return right;
        else if (right == null) return left;
        else                    return root;

        
    }
}

