package DynamicProgramming;

public class Toys {
	
	public static void main(String[] args)
	{
		int[] p = {1,5,3,7};
		int D = 8;
		int[][] m = new int[p.length + 1][D+1];
		
		for(int i=0; i<p.length +1; i++)
		{
			for(int j=0; j< D+1; j++)
			{
				m[i][j] = -1;
			}
		}
		for(int i=0;i<p.length+1; i++)
		{
			m[i][0] = 0;
		}
		for(int j=0; j<D+1; j++)
		{
			m[0][j] = 0;
		}
		System.out.println(" The maximum amount that can be spended is : " + find_max(p,D,m,p.length-1,D));
	}
	private static int find_max(int[] p, int D,int[][] m, int n, int d)
	{
		if(m[n][d] >=0)
			return m[n][d];
		if(n == 0 || d == 0)
		{
			m[n][d] = 0;
			return m[n][d];
		}
		else if(p[n] > d)
		{
			return find_max(p,D,m,n-1,d);
		}
		else
		{
			int valwith = p[n] + find_max(p,D,m,n-1, d-p[n]);
			int valwithout = find_max(p,D,m,n-1,d);
			m[n][d] = Math.max(valwith, valwithout);
		}
		return m[n][d];
	}
}
