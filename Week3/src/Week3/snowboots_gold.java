//package Week3;
//Leeland Zhang
//Took me 30 mins
//Got 4/12
//I know this is what you would call a 'bronze' method, but 
//I actually did think upon the actual solution, just coudn't quite solidify
//the thought. I think I finally learned something this time.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class snowboots_gold {
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("snowboots.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter pr=new PrintWriter(new FileWriter("snowboots.out"));
		int n=sc.nextInt();
		int b=sc.nextInt();
		int[] snow=new int[n];
		for(int i=0; i<n; i++)
		{
			snow[i]=sc.nextInt();
		}
		int depth=0;
		int step=0;
		for(int i=0; i<b; i++)
		{
			depth=sc.nextInt();
			step=sc.nextInt();
			int count=0; 
			boolean x=true;
			for(int j=0; j<n;j++)
			{
				if(snow[j]>depth)
					count++;
				if(count>=step)
					x=false;
				if(snow[j]<=depth)
					count=0;
			}
			if(x)
				pr.println(1);
				//System.out.println(1);
			else
				pr.println(0);
				//System.out.println(0);
		}
		sc.close();
		pr.close();
	}
}
