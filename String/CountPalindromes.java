package String;

class CountAllPalindromes
{
	String s;
	int maxLength;
	CountAllPalindromes(String val)
	{
		s = val;		
	}
	
	public int getPalindromesCount()
	{
		int i,j,k,l;
		char[] array = s.toCharArray();
		maxLength = 0;
		//count odd length;
		i=0;
		j=0;
		int length = array.length;
		int count = 0;
		while(i < length)
		{
			k=i;
			l = j;
			int palinLength = 0;
			while(k>=0 && l< length)
			{
				if(array[k] == array[l])
				{
					palinLength++;
					count++;
					k--;
					l++;
				}
				else
					break;	
			}
			k++;
			l--;
			palinLength = (l-k + 1);
			if(palinLength > maxLength)
			{
				maxLength = palinLength;
				palinLength = 0;
			}
			i++;
			j++;
			k=i;
			l=j;
		}
		
		//count even length;
		i=0; j=1;
		int evenCount = 0;
		while(j < length)
		{
			k=i;
			l = j;
			int palinLength = 0;
			while(k>=0 && l< length)
			{
				if(array[k] == array[l])
				{
					evenCount++;
					k--;
					l++;
				}
				else
					break;	
			}
			k++;
			l--;
			palinLength = (l-k + 1);
			if(palinLength > maxLength)
			{
				maxLength = palinLength;
				palinLength = 0;
			}
			i++;
			j++;
			k=i;
			l=j;
		}
		
		return evenCount + count;
		
	}
	
	public int findMaxLengthOfPalindrome()
	{
		return maxLength;
	}

}

public class CountPalindromes {
	public static void main(String[] args)
	{
		String s = "abaab";
		CountAllPalindromes c = new CountAllPalindromes(s);
		System.out.println("The no of palidnromes are " + c.getPalindromesCount());
		System.out.println("The length of maximum length of palindrome is " + c.maxLength);
	}
	
}
