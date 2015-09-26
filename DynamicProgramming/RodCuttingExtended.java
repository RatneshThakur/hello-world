package DynamicProgramming;

public class RodCuttingExtended {
	
	public static void main(String[] args)
	{
		int[] p = {0,1,5,8,9,10,17};
		int[] r = new int[p.length];
		int[] s = new int[p.length];
		s[0] = 0;
		int n = p.length -1 ;
		r[0] = 0;
		for(int i = 1; i<=n; i++){
			int q = -9;
			for(int j = 1; j<=i ;j++)
			{
				int val = p[j] + r[i-j];
				if(val>q){
					q = val;
					s[i] = j;
				}
			}
			r[i] = q;
			System.out.println(" The value of r "+i+ " is "+ r[i]);
		}
		
		System.out.println(" The max revenue for 4 is : "+ r[6]);
		
		n=p.length -1;
		while(n>0)
		{
			System.out.println(" Piece length " + s[n]);
			n = n - s[n];
		}
	}

}
