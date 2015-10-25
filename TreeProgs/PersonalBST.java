package TreeProgs;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
}
class BSTPersonal{
	TreeNode root;
	
	public TreeNode getRoot(){
		return root;
	}
	public void treeInsert(int val)
	{
		TreeNode y,x;
		x = root;
		y = null;
		
		while(x != null)
		{
			y = x;
			if(val > x.val)
				x = x.right;
			else
				x = x.left;
		}
		TreeNode z = new TreeNode();
		z.val = val;
		z.left = z.right = null;
		if(y == null)
			root = z;
		else if( z.val < y.val)
			y.left = z;
		else
			y.right = z;
	}
	
	public void printTree()
	{
		printTreeInorder(root);
	}
	public void printTreeInorder(TreeNode r)
	{
		
		if(r != null)
		{
			printTreeInorder(r.left);
			System.out.print("Value  " + r.val + ",");
			printTreeInorder(r.right);
		}
	}
	public TreeNode search(int val)
	{
		TreeNode x = root;
		while(x != null )
		{
			if(x.val == val)
				break;
			if(val > x.val)
				x = x.right;
			else
				x = x.left;
		}
		return x;
	}
	public void printAllRootToLeafPath()
	{
		int[] array = new int[20];
		//instead of this an array list can also be used.
		printRootToLeafPathsHelper(root,array,0);
	}
	public int findHeight()
	{
		return findHeightHelper(root,0);
	}
	private int findHeightHelper(TreeNode r, int h)
	{
		if(r == null)
			return h;
		else
		{
			int left = findHeightHelper(r.left,h);
			int right = findHeightHelper(r.right,h);
			return Math.max(left,right) +  1;
 		}
	}
	private void printRootToLeafPathsHelper(TreeNode r, int[] array, int pathlen)
	{
		if(r == null)
			return ;
		else
		{
			array[pathlen++] = r.val;
			
			if(r.left != null)
				printRootToLeafPathsHelper(r.left,array,pathlen);
			if(r.right != null)
				printRootToLeafPathsHelper(r.right,array,pathlen);
			if(r.left == null && r.right == null)
			{
				int j=0;
				System.out.println("Printing one root to leaf path");
				for(j=0; j<pathlen; j++)
				{
					System.out.print(array[j] + ",");
				}
				System.out.println(" ");
			}
			
		}
	}
	
	public void findNthNode(int n)
	{
		findNthNodeHelper(root,n,0);
	}
	public int findNthNodeHelper(TreeNode r, int n, int k)
	{
		if(r == null)
		{
			return k;
		}
		else
		{
			if(r.left != null)
				k = findNthNodeHelper(r.left,n,k);
			k++;
			if(k == n)
			{
				System.out.println(" The nth node is " + r.val);
				return k;
			}
			else
				k = findNthNodeHelper(r.right,n,k);
			return k;
		}
	}
}

public class PersonalBST {
	public static void main(String[] args)
	{
		BSTPersonal tree = new BSTPersonal();
		tree.treeInsert(5);
		tree.treeInsert(6);
		tree.treeInsert(4);
		tree.treeInsert(10);
		tree.treeInsert(11);
		tree.treeInsert(12);
		tree.treeInsert(1);
		tree.treeInsert(2);
		tree.treeInsert(7);
		tree.printAllRootToLeafPath();
		tree.findNthNode(10);
		System.out.println("Height of the tree is " + tree.findHeight());
		TreeNode searchedkey = tree.search(11);
		if(searchedkey == null)
			System.out.println("Key not found in tree");
		else
			System.out.println("Searched key is " + searchedkey.val);
		tree.printTree();
	}
}
