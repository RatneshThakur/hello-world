package DynamicProgramming;

public class EditDistance {
	public static void main(String[] args)
	{
		String A = "SUNDAY";
		String B = "SATURDAY";
		System.out.println("edit required " + findEdit(A,B));
	}
	private static int findEdit(String A, String B)
	{
		A = " " + A;
		B = " " + B;
		int[][] C = new int[A.length()][B.length()];
		for(int i=0;i<A.length(); i++)
		{
			for(int j=0; j<B.length(); j++)
			{
				C[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=0;i< A.length(); i++)
		{
			C[i][0] = i;
		}
		for(int j=0;j< B.length(); j++)
		{
			C[0][j] = j;
		}
		return findEdit_aux(A,B, A.length()-1, B.length()-1, C);
	}
	private static int findEdit_aux(String A, String B, int m, int n, int[][] C)
	{
		if( m == 0 && n ==0)
			return 0;
		else if(C[m][n] < Integer.MAX_VALUE)
			return C[m][n];
		else if(n == 0)
		{
			C[m][n] = m;
			return C[m][n];
		}
		else if(m == 0)
		{
			C[m][n] = n;
			return C[m][n];
		}
		else{
			int diff = 0;
			if(A.charAt(m) == B.charAt(n))
				diff = 0;
			else
				diff = 1;
			int substitution = findEdit_aux(A,B,m-1,n-1,C) + diff;
			int insertion = findEdit_aux(A,B,m,n-1,C) + 1;
			int deletion = findEdit_aux(A,B,m-1,n,C) + 1;
			C[m][n] = min(substitution, insertion, deletion);
		}
		
		return C[m][n];
	}
	private static int min(int a, int b, int c)
	{
		int x = (a<b)? (a<c ? a : c) : (b<c ? b : c);
		return x;
	}
}
