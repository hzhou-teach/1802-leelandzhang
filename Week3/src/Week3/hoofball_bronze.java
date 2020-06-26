//Leeland Zhang
//Took me 30 minutes
//got 4/10
//Difficulty 8 I guess, the 'source' idea was something I didn't come up with
//I feel like I'm not improving at all, just getting more frustrated
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class hoofball_bronze {
	static void sort(int[] l) 
	{
		Arrays.sort(l);
		for(int i = 0; i < l.length-1-i; i++) 
		{
			l[i] ^= l[l.length-1-i];
			l[l.length-1-i] ^= l[i];
			l[i] ^= l[l.length-1-i];
		}
	}
	static int min(int i, int[] j)
	{
		if(j[i+1]-j[i]>j[i]-j[i-1])
			return i+1;
		else
			return i-1;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("hoofball.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("hoofball.out"));
		int n=sc.nextInt();
		int[] pos=new int[n];
		for(int i=0; i<n; i++)
			pos[i]=sc.nextInt();
		sort(pos);
		
		int count=0;
		for(int i=0; i<n-1; i++)
		{
			if(i==0)
			{
				if(min(i+1,pos)==i)
					count++;
			}
			else if(i==n-2)
			{
				if(min(i,pos)==i)
					count++;
			}
			else if(min(i,pos)==i+1&&min(i+1,pos)==i)
				count++;
		}
		//System.out.println(count+1);
		pr.println(count+1);
		sc.close();
		pr.close();
	}
}
