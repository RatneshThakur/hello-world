package DynamicProgramming;

public class LongestCommonSubsequence {
	
	public static void main(String[] args)
	{
		String A = " ABCBDAB";
		String B = " BDCABA";
		
		
		int[][] C = new int[A.length() + 1][B.length() + 1];
		
		for(int i=0; i<A.length()+1; i++)
		{
			for(int j=0; j<B.length() + 1; j++)
			{
				C[i][j] = Integer.MAX_VALUE;
			}
		}
		int lcs = findLCS(A,B,A.length()-1, B.length()-1, C);
		
		System.out.println("LCS is " + lcs);
		printLCS(C,A.length()-1, B.length()-1, A, B);
	}
	private static void printLCS(int[][] C, int m, int n, String A, String B)
	{
		int i=m, j= n;
		String LCSoutput = "";
		while(i>0 && j>0)
		{
			if(A.charAt(i) == B.charAt(j)){
				LCSoutput += A.charAt(i);
				i--;
				j--;
			}
			else if(C[i-1][j] > C[i][j-1]){
				i--;
			}
			else
				j--;
		}
		System.out.println("The lcs is " + new StringBuilder(LCSoutput).reverse());	
	}
	private static int findLCS(String A, String B, int m, int n, int[][] C)
	{
		if(C[m][n] < Integer.MAX_VALUE)
			return C[m][n];
		else{
			if(m==0 || n == 0)
				C[m][n] = 0;
			else
			{
				if(A.charAt(m) == B.charAt(n))
					C[m][n] = 1 + findLCS(A,B,m-1,n-1,C);
				else
					C[m][n] = max( findLCS(A,B,m-1,n,C), findLCS(A,B,m,n-1,C));
			}
		}
		return C[m][n];
	}
	private static int max(int a, int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	
}
