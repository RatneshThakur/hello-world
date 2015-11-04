package microsoftEvent;

import java.io.BufferedReader;
import java.io.FileReader;

public class RadixConversion {
	
	public static void main(String[] args) throws Exception
	{
		String input = "2343001";
		int from = 8;
		int to = 17;
		
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/RatneshThakur/workspace/Practice/src/microsoftEvent/SampleInput2.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		    	String[] splited = line.split(",");
		    	if(splited.length <3)
		    	{
		    		System.out.println("Invalid Input");
		    		line = br.readLine();
		    		continue;
		    	}
		    	from = Integer.parseInt(splited[1]);
		    	to = Integer.parseInt(splited[2]);
		    	String output = convertNum(splited[0],from,to);
		    	System.out.println(output);
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
	}
	
	private static String convertNum(String input, int from, int to)
	{
	
		StringBuilder sb = new StringBuilder();
		
		if(from <=0 || to <= 0)
			return "Invalid Input";

		String output = "";
		int flag = 0;
		Integer tempNum = 0;
		try{
			tempNum = Integer.valueOf(input, from);
		}
		catch(Exception ex)
		{
			output = "Invalid Input";
			return output;
		}
		
		try{
			output = Integer.toString(tempNum,to);
		}
		catch(Exception ex)
		{
			output = "Invalid Input";
			return output;
		}
		return output;
		
	}

}
