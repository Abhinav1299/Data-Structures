class Stack_LL<D> implements Stack<D>
	{
		ListObject head,tail;
		int size=0;
		D j;
		Stack_LL()
		{
			tail=head=null;
			size=0;
		}
		
		public void push(D v)
		{
			ListObject<D> ob=new ListObject<D>(v);
	 
			 if(tail==null)
    	       { head=tail=ob;
    	       }
			 else
	   		{	tail.next=ob;
	     		tail=ob;
       		}
	 		size++;
		}
		
		public D pop()
		{
			ListObject a;
			D w;
			a=head;
			while(a.next.next!=null)
			{
				a=a.next;
			}
			w=(D)a.next.val;
			a.next=null;
			tail=a;
			return w;
			
		}
		
		public D peek()
		{
			ListObject a;
			D w;
			a=head;
			while(a.next!=null)
			{
				a=a.next;
			}
			w=(D)a.val;
			//a.next=null;
			//tail=a;
			return w;
		}
		
		public Integer size()
		{ return size;
		}
	}
