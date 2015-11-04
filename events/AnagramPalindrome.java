package microsoftEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class AnagramPalindrome {
	
	public static void main (String[] args) throws Exception
	{
		String inString = "agqagdt";
		long[] outputs = new long[2];
		
		
		//read file and call function one by one.
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/RatneshThakur/workspace/Practice/src/microsoftEvent/SampleInput2.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		    	outputs[0] = outputs[1] = 0;
		    	findMinPalinAnagrams(line,outputs);
				System.out.println(outputs[0]+","+outputs[1]);
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
		
		//findMinPalinAnagrams(inString,outputs);
		//System.out.println(outputs[0]+","+outputs[1]);
	}
	
	private static void findMinPalinAnagrams(String input, long[] outputs)
	{
		HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
		if(input.length() == 0)
		{
			outputs[0] = 0;
			outputs[1] = 0;
			
		}
		
		for(int i=0; i<input.length(); i++)
		{
			if(charCount.containsKey(input.charAt(i)) == false)
			{
				charCount.put(input.charAt(i), 1);
			}
			else
			{
				int val = charCount.get(input.charAt(i));
				val++;
				charCount.put(input.charAt(i), val);
			}
		}
		long numerator = 0;
		long denominator = 1;
		int minOddCount = Integer.MAX_VALUE;
		char minOddCountChar = '&';
		for(Map.Entry<Character, Integer> entry:charCount.entrySet())
		{
			int val = entry.getValue();
			if(val %2 == 0)
			{
				numerator += val/2;
				denominator *= findFactorial(val/2);
			}
			else
			{
				if(val < minOddCount)
				{
					minOddCount = val;
					minOddCountChar = entry.getKey();
				}
			}
		}
		
		int deletionCount = 0;
		for(Map.Entry<Character, Integer> entry:charCount.entrySet())
		{
			int val = entry.getValue();
			if(entry.getKey() == minOddCountChar)
			{
				val--;
				numerator += val/2;
				denominator *= findFactorial(val/2);				
			}
			else if(entry.getValue() %2 == 1)
			{
				deletionCount++;
				val--;
				numerator += val/2;
				denominator *= findFactorial(val/2);		
			}
		}
		
		
		outputs[0] = deletionCount;
		outputs[1] = findFactorial(numerator)/denominator;		
	}
	
	private static long findFactorial(long num)
	{
		if(num == 0)
			return 1;
		long factorial = 1;
		for(int j=1; j<=num; j++)
		{
			factorial *= j;
		}
		
		return factorial;
	}
	

}
