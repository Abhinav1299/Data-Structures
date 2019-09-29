class Stack_AL<D> implements Stack<D>
	{
		D arr[];
		//Integer size;
		Integer buffer;
		Integer top;
		
		Stack_AL()
		{
			//size=0;
			buffer=5;
			arr=(D[])new Integer[buffer];
			top=-1; 
		}
		
		
		public void push(D ob)
		{
			top++;
			arr[top]=ob;
			
      		
      		if(top==buffer)
				{
					Integer arr2[]=new Integer [buffer*2];
					buffer*=2;
					for(int i=0;i<top;i++)
					{
						arr2[i]=(Integer) arr[i];
					}
						arr=(D[]) arr2;
				}
		}
		
		public D peek()
		{
			return arr[top-1];
		}
		
		public D pop()
		{
			
			try
			{
				if(top<0)
				{
				BoundException ob=new BoundException();
				throw ob;
				}
			}
			
			catch(BoundException x)
			{
			x.printError();
			return null;
			}	
			D s;
			s=arr[top];
			top--;
			return s;
			
		}
		
		public Integer size()
		{
			return top;
		}
		
		
		
		
		
		
			
	}	
		
