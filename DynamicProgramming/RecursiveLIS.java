package DynamicProgramming;

import org.omg.Messaging.SyncScopeHelper;

import java.util.*;

public class RecursiveLIS {
	
	public static void main(String[] args)
	{
		int[] val = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(" The length of LIS is "+ findLIS(val));
	}
	private static int findLIS(int[] val)
	{
		
		int[] p = new int[val.length];
		for(int i=0; i<p.length; i++)
			p[i] = -1;
		int[] maxSeq = new int[val.length];
		int max_end = -1;
		for(int i=0; i<maxSeq.length; i++)
		{
			maxSeq[i] = 1;
		}
		int max_length = 1;
		
		for(int i= 0; i<val.length; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(val[i] > val[j])
				{
					if(maxSeq[j] + 1 > maxSeq[i])
					{
						maxSeq[i] = maxSeq[j] + 1;
						p[i] = j;						
					}
				}
			}
			if(maxSeq[i] > max_length){
				max_length = maxSeq[i];
				max_end = i;
			}
				
		}
		
		System.out.println(" The maximum length is "+ max_length);
		
		System.out.println(" Ending at " + val[max_end]);
		
		printSeq(p,max_end, val);
		
		return max_length;
		
	}
	
	private static void printSeq(int[] p, int last, int[] val)
	{
		if(p[last] == -1){
			System.out.println(val[last]);
			return;
		}
			
		printSeq(p, p[last], val);
		System.out.println(val[last]);
	}

}
