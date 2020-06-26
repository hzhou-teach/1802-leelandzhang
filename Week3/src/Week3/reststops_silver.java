//Leeland Zhang
//Spent half an hour (writing the code at least)
//1/10
//The difficulty I thought was like a 4, but I only got 1/10
//I really don't know why I only got 1/10, I looked at the solutions
//and my code is the same idea. I'm quite confused where I went wrong. 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class reststops_silver 
{
	static int findMax(int[][]rest, int pos1, int pos2)
	{
		int pos=0;
		int max=0; 
		for(int i=pos1; i<=pos2; i++)
		{
			if(rest[i][1]>max)
			{
				max=rest[i][1];
				pos=i;
			}
		}
		return pos;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("reststops.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("reststops.out"));
		int L=sc.nextInt();
		int N=sc.nextInt();
		int sec=sc.nextInt();//Seconds per meter for farmer
		int sec1=sc.nextInt();//Seconds per meter for bessie
		int[][] rest=new int[N][2];//0 is position, 1 is tastieness
		for(int i=0; i<N; i++)
		{
			rest[i][0]=sc.nextInt();
			rest[i][1]=sc.nextInt();
		}
//-----------------------------------------------------------------------
		int pos1=0;
		int pos2=N-1;
		int taste=0;//tastieness value
		int dis=0;//distance from last shared rest stop
		int temp=0;
		do 
		{
			temp=findMax(rest,pos1,pos2);
			taste+=(rest[findMax(rest,pos1,pos2)][0]-dis)*(sec-sec1)*rest[findMax(rest,pos1,pos2)][1];
			dis=rest[findMax(rest,pos1,pos2)][0];
			pos1=findMax(rest,pos1,pos2)+1;
		}while(temp!=(N-1));
		pr.println(taste);
		pr.close();
		sc.close();
	}
}
