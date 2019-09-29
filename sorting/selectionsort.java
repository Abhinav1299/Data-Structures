package sorting;

import java.util.Random;
import java.util.Scanner;

public class selectionsort {
	public static void selsort(int a[],int n)
	{
		int min,temp;
		for(int i=0;i<n-1;i++)
		{
			min=i;
			for(int j=i+1;j<n;j++)
			{
				if(a[j]<a[min])
				{
					min=j;
				}
			}
			temp=a[min];
			a[min]=a[i];
			a[i]=temp;
			
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
		System.out.println();
		final long startTime = System.nanoTime();
		selsort(a,n);
		final long duration = System.nanoTime() - startTime;
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println("total time taken by selection sort algorithm (micro sec) =  "+duration/1000);
	}

}
