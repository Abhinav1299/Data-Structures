package AVL;



public class AVL {
	AVL_node root;
	public AVL()
	{
		root=null;
	}
	
	public AVL_node SingleLeftRotate(AVL_node p)
	{
		AVL_node rc=p.right;
		p.right=rc.left;
		rc.left=p;
		return rc;
	}
	
	public AVL_node SingleRightRotate(AVL_node p)
	{
		AVL_node lc=p.left;
		p.left=lc.right;
		lc.right=p;
		return lc;
	}
	
	public AVL_node DoubleLeftRightRotate(AVL_node p)
	{
		p.left=SingleLeftRotate(p.left);
		return SingleRightRotate(p);
	}
	
	public AVL_node DoubleRightLeftRotate(AVL_node p)
	{
		p.right=SingleRightRotate(p.right);
		return SingleLeftRotate(p);
	}
	
	public int max(int a,int b)
	{
		if(a>=b)
		{
			return a; 
		}
		else
		{
			return b;
		}
	}
	
	public int height(AVL_node ob)
	{
		if(ob==null)
		{
			return -1;
		}
		else
		{
			return(max(height(ob.left),height(ob.right))+1);
		}
	}
	
	public AVL_node add(AVL_node p,Integer v)
	{
		if(p==null)
		{
			p=new AVL_node(v);
		}
		else if(v<p.val)
		{
			p.left=add(p.left,v);
			if(height(p.left)-height(p.right)==2)
			{
				if(v<p.left.val)
				{
					p=SingleRightRotate(p);
				}
				else
				{
					p=DoubleLeftRightRotate(p);
				}
			}
		}
		else if(v>=p.val)
		{
			p.right=add(p.right,v);
			if(height(p.left)-height(p.right)==-2)
			{
				if(v>=p.right.val)
				{
					p=SingleLeftRotate(p);
				}
				else
				{
					p=DoubleRightLeftRotate(p);
				}
			}
		}
		return p;
	}
	
	public AVL_node  lmcorst(AVL_node ob)
	{
		AVL_node v=ob.right;
		while(v.left!=null)
		{
			v=v.left;
		}
		return v;
	}
	
	public AVL_node parent(AVL_node ob)
	{
		AVL_node hop=root,hop2=null;
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
		
		if(ob==root)
		{
			hop2=null;
		}
		//System.out.println(hop2.val);
		return hop2;
	}
	
	public AVL_node delete(AVL_node p,Integer v)
	{
		if(p==null)
		{
			return p;
		}
		if(v<p.val)
		{
			p.left=delete(p.left,v);
		}
		else if(v>p.val)
		{
			p.right=delete(p.right,v);
		}
		
		else 
		{
			if(p.left==null && p.right==null)
			{
				p=null;
			}
			else if(p.left!=null && p.right!=null)
			{
				AVL_node q=lmcorst(p);
				//AVL_node poq=parent(q);
				p.val=q.val;
				p.right=delete(p.right,q.val);
				
			}
			else
			{
				if(p.right!=null)
				{
					AVL_node q=p.right;
					p.right=null;
					p=q;
				}
				else
				{
					AVL_node q=p.left;
					p.left=null;
					p=q;
				}
			}
			
		}
		 if (p == null)  
            return p;  
  
        
        int balance = height(p.left)-height(p.right);  
  
        // Left Left Case  
        if (balance > 1 && (height(p.left.left)-height(p.left.right))>= 0)  
            return SingleRightRotate(root);  
  
        // Left Right Case  
        if (balance > 1 && (height(p.left.left)-height(p.left.right)) < 0)  
        {  
            p.left = SingleLeftRotate(p.left);  
            return SingleRightRotate(p);  
        }  
  
        // Right Right Case  
        if (balance < -1 && (height(p.right.left)-height(p.right.right))<= 0)  
            return SingleLeftRotate(p);  
  
        // Right Left Case  
        if (balance < -1 && (height(p.right.left)-height(p.right.right)) > 0)  
        {  
            p.right = SingleRightRotate(p.right);  
            return SingleLeftRotate(p);  
        }  
		return p;
	}
	
	public void traversal(Integer a)
	{
		System.out.print(a+"  ");
		System.out.println();
	}
	
	public void post(AVL_node root1)    // postorder		pass=root (root1=root)
	{
		//System.out.println(root1.left.val);
		if(root1==null)
		{
			return;
		}
		post(root1.left);
		post(root1.right);
		traversal(root1.val);
	}
	
	public AVL_node search(Integer v)
	{
		AVL_node hop = this.root;
		while(hop!=null)
		{
			if(v<hop.val)
			{
				hop=hop.left;
			}
			else if(v>hop.val)
			{
				hop=hop.right;
			}
			else
			{
				break;
			}
		}
		return hop;
	}


}

