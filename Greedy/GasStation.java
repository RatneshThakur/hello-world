package Greedy;

public class GasStation {
	public static void main(String[] args)
	{
		int[] distance = {1,3,5,6,8,9,10};
		int capacity = 2;
		System.out.println( "Minimu refill are : " + find_min_refill(distance,capacity));
	}
	private static int find_min_refill(int[] distance, int capacity)
	{
		int remainder = 0;
		int count = 0;
		for(int i= 1; i< distance.length; i++)
		{
			if((distance[i] - distance[i-1]) > remainder)
			{
				remainder = capacity - (distance[i] - distance[i-1]);
				count = count+1;				
			}
			else
			{
				remainder = remainder - (distance[i]- distance[i-1]);
			}
		}
		return count;
	}
}
