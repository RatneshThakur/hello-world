package sorting;

public class MyMergeSort {
	public int[] mergeSort(int[] array)
	{
		if(array.length > 1)
		{
			int elementsinA1 = array.length/2;
			int elementsinA2 = array.length - elementsinA1;
			
			int[] a1 = new int[elementsinA1];
			int[] a2 = new int[elementsinA2];
			
			for(int i=0; i<elementsinA1; i++)
			{
				a1[i] = array[i];
			}
			for(int i=elementsinA1,j=0; i<elementsinA1+elementsinA2; i++,j++)
			{
				a2[j] = array[i];
			}
			
			a1 = mergeSort(a1);
			a2 = mergeSort(a2);
			
			//now the merging part
			merge(a1,a2,array);
			
		}
		return array;
	}
	public void merge(int[] a1, int[] a2, int[] array)
	{
		int i,j,k;
		i=0;
		j=0;
		k=0;
		while( j != a1.length && k != a2.length)
		{
			if(a1[j] < a2[k])
			{
				array[i] = a1[j];
				i++;
				j++;
			}
			else
			{
				array[i] = a2[k];
				k++;
				i++;
			}
		}
		while( j != a1.length)
		{
			array[i] = a1[j];
			i++;
			j++;
		}
		while(k != a2.length)
		{
			array[i] = a2[k];
			i++;
			k++;
		}
	}
	public static void main(String[] args)
	{
		MyMergeSort a = new MyMergeSort();
		int[] array = {5,3,2,1,35,0,1};
		a.mergeSort(array);
		for(int x : array)
			System.out.print(" "+ x);
	}
}
