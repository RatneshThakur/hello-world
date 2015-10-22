package String;

public class MatchRegex {
	public static void main(String[] args)
	{
		String a = "abbbbbbbbbbbbbbbbbbbbbcd";
		String regex = "ab*c";
		
		char[] regexA = regex.toCharArray();
		char[] inputA = regex.toCharArray();
		
		System.out.println("Two string matches ? " + findMatch(regexA,inputA));
	}
	
	public static boolean findMatch(char[] regex, char[] input)
	{
		char currentChar;
		int j = 0;
		for(int i=0; i<input.length;)
		{
			if(Character.isAlphabetic(regex[j]))
			{
				if(regex[j] == input[i])
				{
					i++;
					j++;
				}
				else if(regex[j] != input[i])
				{
					if(regex[j+1] == '*')
					{
						i++;
					}
					else
					{
						return false;
					}
				}
			}
			else if(regex[j] == '*')
				i++;
		}
		
		return true;
	}
}
