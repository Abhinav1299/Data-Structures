package RBTree;



public class RBT {
	RB_node root;
	public RBT()
	{
		root=null;
	}
	
	public RB_node SingleLeftRotate(RB_node p)
	{
		RB_node rc=p.right;
		p.right=rc.left;
		rc.left=p;
		if(parent(rc)==null)
		{
			root=rc;
		}
		return rc;
	}
	
	public RB_node SingleRightRotate(RB_node p)
	{
		RB_node lc=p.left;
		p.left=lc.right;
		lc.right=p;
		if(parent(lc)==null)
		{
			root=lc;
		}
		return lc;
	}
	
	public RB_node DoubleLeftRightRotate(RB_node p)
	{
		p.left=SingleLeftRotate(p.left);
		return SingleRightRotate(p);
	}
	
	public RB_node DoubleRightLeftRotate(RB_node p)
	{
		p.right=SingleRightRotate(p.right);
		return SingleLeftRotate(p);
	}
	
	/*public RB_node add(Integer v)
	{
		RB_node ob=new RB_node(v);
		if(root==null)
		{
			root=ob;//recolor root to black
		}
		
		else
		{
			RB_node hop=root;
			while(true)
			{
				if(ob.val<hop.val)
				{
					if(hop.left==null) {break;}
					hop=hop.left;
				}
				else
				{
					if(hop.right==null) {break;}
					hop=hop.right;
				}
			}
			if(ob.val<hop.val)
			{
				hop.left=ob;
			}
			else
			{
				hop.right=ob;
			}
			
		}
		RB_fixup(ob);
		return root;
		
	}*/
	
	public RB_node add(RB_node p,RB_node ob)
	{
		if(p==null)
		{
			p=ob;
		}
		else if(p.val<=ob.val)
		{
			p.right=add(p.right,ob);
		}
		else if(p.val>ob.val)
		{
			p.left=add(p.left,ob);
		}
		
		return p;
	}
	
	public RB_node parent(RB_node ob)
	{
		
		RB_node hop=root,hop2=null;
		if(ob==null)
		{
			hop2=null;
		}
		else {
		//System.out.println(root.val);
		while(hop.left!=null || hop.right!=null)
		{
			hop2=hop;
			if(ob.val<hop.val)	
			{
				hop=hop.left;
			}
			else if(ob.val>hop.val)
			{
				hop=hop.right;
			}
			if(hop.val==ob.val)
				
			{
				break;
			}
		}
		}
		if(ob==root)
		{
			hop2=null;
		}
		
		//System.out.println(hop2.val);
		return hop2;
	}
	
	public char colour(RB_node ob)
	{
		if(ob==null)
		{
			return 'B';
		}
		else
		{
			return ob.c;
		}
	}
	
	public void RB_fixup(RB_node ob)
	{
		//RB_node pob,ppob=null;
		//pob=parent(ob);
		//if(pob!=null)
		//{
		//	ppob=parent(pob);
		//}
		while(colour(parent(ob))=='R' && parent(parent(ob))!=null)
		{
			if(parent(parent(ob)).left==parent(ob))
			{
				RB_node w = parent(parent(ob)).right;  // uncle of ob
				if(colour(w)=='R' && w!=null)   // case-1
				{
					w.c='B';
					parent(ob).c='B';
					parent(parent(ob)).c='R';
					ob=parent(ob);
				}
				else  // colour(w)='B'
				{
					if(ob==parent(ob).right)  
					{
						RB_node z=parent(parent(ob));
						ob=parent(ob);
						z.left=SingleLeftRotate(ob);
						System.out.println("hello");
					}
					parent(parent(ob)).c='R';
					parent(ob).c='B';
					RB_node q=parent(parent(parent(ob)));
					if(q!=null)
					{
						q.right=SingleRightRotate(parent(parent(ob)));
					}
					else
					{
						ob=SingleRightRotate(parent(parent(ob)));
					}
					//System.out.println(ob.val+" "+ ob.left.val+" "+ob.right.val+" "+parent(ob).val);
					//System.out.println(root.val+" " + root.right.val+"  "+root.left.val);
					//ob=parent(ob);
				}
				
			}
			else    //ppob.right==pob
			{
				RB_node w = parent(parent(ob)).left;  // uncle of ob
				if(colour(w)=='R')   // case-1
				{
					w.c='B';
					parent(ob).c='B';
					parent(parent(ob)).c='R';
					ob=parent(ob);
				}
				else  // colour(w)='B' and w could be null
				{
					if(ob==parent(ob).left)  
					{
						RB_node z=parent(parent(ob));
						ob=parent(ob);
						z.right=SingleRightRotate(ob);
						System.out.println("hello");
					}
					//System.out.println(parent(ob).val+" " + parent(parent(ob)).val);
					parent(parent(ob)).c='R';
					parent(ob).c='B';
					RB_node q=parent(parent(parent(ob)));
					if(q!=null)
					{
						q.left=SingleLeftRotate(parent(parent(ob)));
					}
					else
					{
						ob=SingleLeftRotate(parent(parent(ob)));
					}
					//System.out.println(ob.val);
					//System.out.println(root.val);
					//ob=parent(ob);
				}
				
			}
		}
		root.c='B';
	}
	
	public void insert(Integer v)
	{
		RB_node ob=new RB_node(v);
		root=add(root,ob);
		RB_fixup(ob);
	}
	
	public void traversal(RB_node a)
	{
		System.out.println( a.val + " " + a.c );
	}
	
	public void post(RB_node root1)    // postorder		pass=root (root1=root)
	{
		//System.out.println(root1.left.val);
		if(root1==null)
		{
			return;
		}
		post(root1.left);
		post(root1.right);
		traversal(root1);
	}
	
	

}
