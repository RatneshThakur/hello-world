package BackTracking;

public class PermuatationString {
	public static void main(String[] args)
	{
		String s = "abc";
		printPermuations(s.toCharArray(),0, s.length()-1);
	}
	private static void printPermuations(char[] s, int l, int r)
	{
		if(l == r)
		{
			String result = new String(s);
			System.out.println(result);
		}
		else if(l>r)
			return;
		else
		{
			for(int i=l; i<=r; i++)
			{
				swap(s,i,l);
				printPermuations(s,l+1,r);
				//backtracking
				swap(s,i,l);
			}
		}
	}
	private static void swap(char[] s, int l, int r)
	{
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
		
	}
}
