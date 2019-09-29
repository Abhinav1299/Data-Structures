package sorting;

import java.util.Random;
import java.util.Scanner;

public class bubblesort {
	
	public static void bubblesort1(int a[],int n)
	{
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (a[j] > a[j+1])
                {
                    // swap temp and arr[i]
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            
        }
	}
	
	public static void main(String args[])
	{
		int n;
		Scanner sc=new Scanner(System.in);
		Random rand = new Random(); 
		System.out.println("enter the number of array elements =  ");
		n=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
		{
			a[i]=rand.nextInt(1000); 
			System.out.println("random number "+(i+1)+" = "+a[i]);
		}
		final long startTime = System.nanoTime();
		bubblesort1(a,n);
		final long duration = System.nanoTime() - startTime;
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println();
		System.out.println("total time taken by bubble sort algorithm (micro sec) =  "+duration/1000);
	}

}
