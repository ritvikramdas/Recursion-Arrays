// Ritvik Ramdas
// CSE 205

import java.util.Scanner;

public class Assignment6 {
	
	public static void main(String[] args) 
	{
		int[] arrayran = new int[100];
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the numbers of the array. Enter 0 when the array ends.");
		
		for ( int i = 0; i <= 100; i++ )
		{
			int num = input.nextInt();
			if ( num == 0 )
			{
				break;
			}
			
			else
			{
				arrayran[i] = num;
			}
		}
		
		System.out.println("The minimum number is " + findMin(arrayran, 0, arrayran.length-1));
		System.out.println("The total number of odd integers is " + countOdd(arrayran, 0, arrayran.length-1));
		System.out.println("The total number of -1 is " + countNegativeOne(arrayran, 0));
		System.out.println("The sum of number at even indexes is " + computeSumAtEvenIndexes(arrayran, 0, arrayran.length-1));
	}
	
	public static int findMin(int[] numbers, int startIndex, int endIndex)
	{
		if (startIndex == endIndex)
		{
			return numbers[startIndex];
		}
		
		else
		{
			int min = findMin(numbers, startIndex, endIndex - 1);
			
			if (numbers[endIndex] < min)
			{
				return numbers[endIndex];
			}
			
			else
			{
				return min;
			}
		}
	}
	
	public static int countOdd(int[] numbers, int startIndex, int endIndex)
	{
		if (startIndex == endIndex)
		{
			if (numbers[startIndex] % 2 != 0)
			{
				return 1;
			}
			
			else
			{
				return 0;
			}
		}
		
		else
		{
			return countOdd(numbers, startIndex, endIndex - 1) + countOdd(numbers, endIndex, endIndex);
		}
	}
	
	public static int countNegativeOne(int[] numbers, int count)
	{
		if (count == numbers.length)
		{
			return 0;		
		}
		
		int n_ones = countNegativeOne(numbers, count + 1);
		
		if ( numbers[count] == -1 )
		{
			n_ones = n_ones + 1;
		}
		
		return n_ones;
	}
	
	public static int computeSumAtEvenIndexes(int[] numbers, int startIndex, int endIndex)
	{
		if ( startIndex == endIndex )
		{
			if ( startIndex % 2 == 0 )
			{
				return numbers[startIndex];
			}
			
			else
			{
				return 0;
			}
		}
		
		else
		{
			if (endIndex % 2 == 0)
			{
				return computeSumAtEvenIndexes(numbers, startIndex, endIndex - 1) + numbers[endIndex];
			}
			
			else
			{
				return computeSumAtEvenIndexes(numbers, startIndex, endIndex - 1);
			}
		}
	}
	
}