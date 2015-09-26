package DynamicProgramming;

public class KadaneAlgo {
	public static void main(String[] args)
	{
		int[] val = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println("The maximum sum is " + findMax(val));
	}
	
	private static int findMax(int[] val)
	{
		int sum,tsum;
		sum = 0;
		tsum = 0;
		
		int tStart = 0, start = 0;
		int end = 0;
		
		for(int i =0; i<val.length ; i++){
			tsum += val[i];
			if(tsum < 0){
				tsum = 0;
				tStart = i+1;
			}
			else if(tsum > sum)
			{
				sum = tsum;
				start = tStart;
				end = i;
			}
		}
		for(int i = start; i<=end ; i++)
		{
			System.out.println(" Values are " + val[i]);
		}
		return sum;
	}
}
