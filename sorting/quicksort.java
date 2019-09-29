package sorting;

import java.util.Random;
import java.util.Scanner;

public class quicksort {
	public static int partition(int a[],int low,int high)
	{
		int pivot=a[low];
		int i=low+1;
		for(int j=low+1;j<=high;j++)
		{
			if(a[j]<pivot)
			{
				swap(a,j,i);
				i++;
			}
		}
		swap(a,i-1,low);
		return (i-1);
	}
	public static void swap(int a[],int x,int y)
	{
		int temp;
		temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
	public static void quicksort1(int a[],int low,int high)
	{
		if(low<high)
		{
			int piv_pos=partition(a,low,high);
			quicksort1(a,low,piv_pos-1);
			quicksort1(a,piv_pos+1,high);
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
		quicksort1(a,0,n-1);
		final long duration = System.nanoTime() - startTime;
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println("total time taken by quicksort algorithm (micro sec) =  "+duration/1000);
	}
	

}
