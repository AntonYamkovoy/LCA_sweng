

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

    // takes in 2 nodes in a binary tree rooted at "root", and finds their LCA
	public  static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if( root == null)           return null;
        if( root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        
        if(left == null)        return right;
        else if (right == null) return left;
        else                    return root;

        
    }
	
	// Takes in an arbitrary amount of target nodes for a binary tree, and finds their LCA
	public static TreeNode lowestCommonAncestorMultiple(TreeNode root, TreeNode[] targets) {
		if(targets.length < 2) {
			return null;
		}
		if(targets.length == 2) {
			return lowestCommonAncestor(root,targets[0],targets[1]);
		}
		TreeNode result = null;
		TreeNode temp = lowestCommonAncestor(root,targets[0],targets[1]);
		for(int i=2; i < targets.length; i++) {
			 result = lowestCommonAncestor(root,temp,targets[i]);
			
		}
		return result;
		
		
	}
}

