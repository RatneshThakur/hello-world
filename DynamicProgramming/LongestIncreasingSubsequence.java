package DynamicProgramming;

public class LongestIncreasingSubsequence {
	public static void main(String[] args)
	{
		int[] seq = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println("Longest increasing sequence is " + findLIS(seq));
	}
	public static int findLIS(int[] seq)
	{
		int[] p = new int[seq.length];
		int[] pre = new int[seq.length];
		int max_length = 1;
 		for(int i=0 ; i<p.length; i++)
			p[i] = 1;
		for(int i=0;i<seq.length; i++)
		{
			for(int j=0; j<i ; j++)
			{
				if(seq[i] > seq[j] )
				{
					int q = p[j] + 1;
					if(q > p[i])
					{
						p[i] = q;
						pre[i] = j;
					}
					if(q> max_length)
					{
						max_length = q;
					}
				}
			}
		}
		return max_length;
	}
}
