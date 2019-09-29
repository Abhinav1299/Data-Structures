package RBTree;



public class RB_node {
	char c;
	Integer val;
	RB_node right,left;
	public RB_node(Integer v)
	{
		this.val=v;
		c='R';
		this.right=null;
		this.left=null;
	}

}
