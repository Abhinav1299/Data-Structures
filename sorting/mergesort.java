package sorting;

import java.util.Random;
import java.util.Scanner;

public class mergesort 
{
	public static void mergesort1(int a[],int low,int high)
	{
		int mid=(low+high)/2;
		if(low<high)
		{
			mergesort1(a,low,mid);
			mergesort1(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	public static void merge(int a[],int l,int m,int h)
	{
		// 2 arrays are formed 1. of length low to mid
		// other of length mid+1 to high
		
		int n1=m-l+1;
		int n2=h-m;
		//System.out.println(n1+" "+n2);
		int len1=0,len2=0,len=l;
		int[] l1=new int[n1];
		int[] l2=new int[n2];
		for(int i=0;i<n1;i++)
		{
			l1[i]=a[l+i];
		//	System.out.println(l1[i]);
		}
		//System.out.println();
		/*for(int i=0;i<n1;i++)
		{
			System.out.print(l1[i]+" ");
		}*/
		
		for(int i=0;i<n2;i++)
		{
			l2[i]=a[m+1+i];
			//System.out.println(l2[i]);
		}
		//System.out.println();
		/*for(int i=0;i<n2;i++)
		{
			System.out.print(l2[i]+" ");
		}*/
		//System.out.println();
		while(len1<n1 && len2<n2)
		{
			if(l1[len1]<l2[len2])
			{
				a[len]=l1[len1];
				len1++;
			}
			else
			{
				a[len]=l2[len2];
				len2++;
			}
			len++;
		}
		while(len1<n1)
		{
			a[len++]=l1[len1++];
		}
		while(len2<n2)
		{
			a[len++]=l2[len2++];
		}
		/*for(int i=0;i<len;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();*/
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
		}
		final long startTime = System.nanoTime();
		mergesort1(a,0,n-1);
		final long duration = System.nanoTime() - startTime;
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println();
		System.out.println("total time taken by merge sort algorithm (micro sec) =  "+duration/1000);
	}
		
		
		
}


