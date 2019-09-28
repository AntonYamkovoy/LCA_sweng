import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class LCATesting {

	@Test
	void lcaNormalTest_1() {
		TreeNode root = new TreeNode(10);                            
		root.left = new TreeNode(12); 
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(16);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(19);
		root.left.left.right.left = new TreeNode(4);
		root.right.right.left = new TreeNode(2);
	
		//                  10
		//                  /\
		//               12    4
		//               /\    /\
		//             5  16  1  7
		//            /\         /
		//           0 19       2
		//             /
		//            4
		TreeNode result = LCA.lowestCommonAncestor(root,root.left.left, root.right.left);
		assertEquals("Testing LCA, node 0 and node 2, Expected result = root",
				result,root);
	}
	
	@Test
	void lcaNormalTest_2() {
		TreeNode root = new TreeNode(1);                            
		root.left = new TreeNode(2); 
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.left.left.left = new TreeNode(0);
		root.right.right.right = new TreeNode(10);
		root.right.right.left = new TreeNode(11);
	
	
		//                   1
		//                  /\
		//                2    4
		//               /\    /\
		//             7  3   6  9
		//            /           /\
		//           0           11 10
		//            
		//            
		TreeNode result = LCA.lowestCommonAncestor(root, root.left.left.left, root.right.right.left);
		assertEquals("Testing LCA, node 6 and node 11, Expected result = Node 4",
				result, root);
	}
	
	@Test
	void lcaNormalTest_3() {
		TreeNode root = new TreeNode(9);                            
		root.left = new TreeNode(7); 
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		root.right.right.right.right = new TreeNode(3);
		root.right.right.right.right.left = new TreeNode(2);
	
	
		//                   9
		//                  / \
		//                 7   4
		//                      \
		//                       5
		//                        \
		//                         1
		//                          \
		//                           3
		//                          /
		//                         2 
		TreeNode result = LCA.lowestCommonAncestor(root, root.right.right, root.right);
		assertEquals("Testing LCA, node 3 and node 5,Result "+result.value+" Expected result = Node 9",
				result, root.right);
	}
	
	@Test
	void lcaRootTest() {
		TreeNode root = new TreeNode(1);
		assertEquals("Testing LCA, only root",
				LCA.lowestCommonAncestor(root, root,root),root);
		
	}
	
	
	@Test 
	void lcaNullTest() {
		TreeNode root = null;
		assertEquals("Testing LCA, root = null",
				LCA.lowestCommonAncestor(root, root,root), null);
		
		
	}
	
	@Test
	void lcaStraightLineTree() {
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		TreeNode result = LCA.lowestCommonAncestor(root, root.right ,root.right.right);
		assertEquals("Testing LCA,Straight Line Test, node 1 and node 4,Result = "+ result.value+" , Expected result = root",
				result, root.right);
		
		
		//                   0
		//                    \
		//                     5
		//                      \
		//                       4
		//                        \
		//                         1
		//                          
		//                           
		//                          
		// 
		
	}
	
	@Test
	void lcaBalancedTreeTest() {
		TreeNode root = new TreeNode(1);                            
		root.left = new TreeNode(2); 
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
	
	
		//                  1
		//                  /\
		//                 2  3
		//                /\  /\
		//               4  5 6 7

		TreeNode result = LCA.lowestCommonAncestor(root,root.left.left, root.right.left);
		assertEquals("Testing LCA, node 4 and node 6, Expected result = root",
				result,root);
	}	
		
	
	@Test
	void lcaUnbalancedTreeTest() {
		TreeNode root = new TreeNode(1);                            
		root.left = new TreeNode(2); 
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

	
	
		//                  1
		//                  /\
		//                 2  3
		//                /\  
		//               4  5  

		TreeNode result = LCA.lowestCommonAncestor(root,root.left.left, root.right);
		assertEquals("Testing LCA, node 4 and node 2, Expected result = root",
				result,root);
		
	}
	
	
	

}
