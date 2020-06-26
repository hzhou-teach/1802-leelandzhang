//Leeland Zhang
//Took me like 90 minutes
//I got 5
//This problem is like a 9 i guess.
//I really just gave up.
//package Week3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class taming_bronze 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("taming.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("taming.out"));
		//Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i]=sc.nextInt();
		}
//-----------------------------------------------------------------------
		boolean neg=false;
		int count=0;
		int temp=0;
		int min=1; 
		int max=1;
		for(int i=1; i<n; i++)
		{
				if(arr[i]==-1)
					count++;
				else
				{
					if(arr[i-1]==-1)
					{
						if(arr[i]-temp>count+1)
						{
							neg=true;
						}
						if(arr[i]-temp-count!=1)
						{
							//System.out.println(temp+" "+count);
							max+=(count-arr[i]+1);
							min++;
						}
						count=0;
					}
				}
				if(i!=n-1)
				{
					if(arr[i+1]==-1&&arr[i]!=-1)
						temp=arr[i];
				}
				if(arr[i]==0)
				{
					max++;
					min++;
				}
		}
//-------------------------------------------------------------------------
		if(neg)
		{
			//System.out.println(-1);
			pr.println(-1);
		}
		else
		{
			//System.out.println(min+" "+max);
			pr.println(min+" "+max);
		}
		sc.close();
		pr.close();
	}
}
