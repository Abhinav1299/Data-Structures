import java.util.Scanner;
class driver_LL
	{
		public static void main(String args[])
		{
			Scanner s=new Scanner(System.in);
   			int i=0,j;
   			Stack_LL<Integer> ob1=new Stack_LL<Integer>();
  		do
  			{System.out.println();
	  			System.out.println("1. push an element");
   				System.out.println("2. pop an element");
   				System.out.println("3. peek");
   				System.out.println("4. size of stack");
   				System.out.println("5. exit");
   				System.out.println("Enter your choice =  ");
    i=s.nextInt();
    
  switch(i)
  { case 1: Integer u;
  			System.out.println();
  			System.out.println("enter the element to be inserted =  ");
            u=s.nextInt();
            
            ob1.push(u);
            System.out.println("element inserted successfully. ");
            System.out.println();
            break;

   case 3: System.out.println();
   			Integer r;
   			r=ob1.peek();
	        System.out.println("peek element =  "+r);
   			System.out.println();
   			
           
           break;
         
           
   case 2:  Integer p;
   			p=ob1.pop();
   			
   				System.out.println();
   				System.out.println(p+"  element deleted successfully...");
   				System.out.println();
   			
   			break;
   case 4: System.out.println(); 
	   		System.out.println("size of the stack = "+ob1.size());
	   		System.out.println();
           break;
           
   
   			
  }

   
  }while(i!=5);
		}
	}
