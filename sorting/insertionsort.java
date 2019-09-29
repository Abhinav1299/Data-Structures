package sorting;

import java.util.Random;
import java.util.Scanner;

public class insertionsort {
	public static void insertsort(int a[],int n)
	{
		int j,temp;
		for(int i=1;i<n;i++)
		{
			j=i-1;
			temp=a[i];
			while(j>=0 && temp<a[j])
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
			/*for(int k=0;k<n;k++)
			{
				System.out.print(a[k]+" ");
			}
			System.out.println();*/
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
			//System.out.println("random number "+(i+1)+" = "+a[i]);
		}
		System.out.println();
		final long startTime = System.nanoTime();
		insertsort(a,n);
		final long duration = System.nanoTime() - startTime;
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println("total time taken by insertion sort algorithm (micro sec) =  "+duration/1000);
	}

}
