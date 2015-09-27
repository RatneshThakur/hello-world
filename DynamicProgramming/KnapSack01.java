package DynamicProgramming;

public class KnapSack01 {

	public static void main(String[] args)
	{
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    
	    int[][] mnw = new  int [val.length + 1][W + 1];
	    for(int i=0;i<val.length+1; i++)
	    {
	    	for(int j=0; j<W+1; j++)
	    		mnw[i][j] = -1;
	    }
	    System.out.println(" The max profit we can get is " + find_max_knapsack(val,wt,W,val.length-1,mnw));
	}
	
	private static int find_max_knapsack(int[] val, int[] wt, int W, int n, int[][] mnw)
	{
		if(mnw[n][W] >=0)
			return mnw[n][W];
		if(n==0 || W ==0)
		{
			mnw[n][W] = 0;
			return mnw[n][W];
		}
		else
		{
			int valWith = val[n] + find_max_knapsack(val,wt,W-wt[n], n-1, mnw);
			int valWithout = find_max_knapsack(val,wt,W-wt[n], n-1, mnw);
			mnw[n][W] = Math.max(valWith,valWithout);
		}
		return mnw[n][W];
	}
}
