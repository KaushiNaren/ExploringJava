package datastructures.sorting;

import java.util.Arrays;

/**
 * @author nranganmanian
 * 
 * Best and Worst : O(n2)
 *
 */
public class SeletionSort 
{
	public static void main(String... args)
	{
		int[] numArray = { 5, 4, 3, 2, 1 };
		
		for(int i=0 ; i < numArray.length; i++)
		{
			for(int j=i; j < numArray.length; j++ )
			{
				if(numArray[i] >  numArray[j])
				{
					
					int temp = numArray[j];
					numArray[j] = numArray[i];
					numArray[i] = temp;
				}
			}
			System.out.println(Arrays.toString(numArray));
		}
		
		System.out.println(Arrays.toString(numArray));
	}

}
