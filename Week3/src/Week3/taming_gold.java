//used like 6 hours so far
package Week3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class taming_gold 
{
	public static void main(String args[]) throws IOException
	{
		//Scanner sc = new Scanner(new File("taming.in"));
		//PrintWriter pr=new PrintWriter(new FileWriter("taming.out"));
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		int[] counter=new int[n];
		int count=0; //Number of changes needed
		int count1=0; //Number of sections, where a section starts with a 0
		int count2=0; //Section length counter
		int count3=0;//Count for over counting in 'length'
		ArrayList<Integer> length=new ArrayList<Integer>(); //section lengths
		ArrayList<Integer> over=new ArrayList<Integer>();//potential overcounts
		int tem=0;
		boolean x=false;
		for(int i=0; i<n; i++)
		{
			counter[i]=sc.nextInt();
			if(i==0)
			{
				if(counter[i]==1)
				{
					count++;
					counter[0]=0;
				}
				count1++;
			}
			else if(counter[i]==0)
			{
				count1++;
				if(tem+1==i)
				over.add(i-1);
			}
			else if(counter[i]<=counter[i-1])
			{
				count++;
				tem=i;
				count3++;
			}
			if(counter[i]==0&&i!=0||i==n-1)
			{
				if(i==n-1)
				{
					count2++;
				}
				if(x)
				{
					length.add(count2-count3);
				}
				count3=0;
				x=true;
				count2=0;
			}
			count2++;
		}
		Collections.sort(length);
		//for(int i=0; i<length.size(); i++)
		//{
		//	System.out.println(length.get(i));
		//}
		int temp=count;
		for(int i=1; i<=n; i++) 
		{
			if(count1-i>0)
			{
				for(int j=0; j<count1-i; j++)
				{
					temp+=length.get(j);
				}
			}
			else
			{
				for(int j=0; j<i-count1; j++)
				{
					if(over.size()>j)
					temp--;
				}
				temp+=(i-count1);
			}
			//pr.println(temp);
			System.out.println(temp);
			temp=count;
		}
		sc.close();
		//pr.close();
	}
}
