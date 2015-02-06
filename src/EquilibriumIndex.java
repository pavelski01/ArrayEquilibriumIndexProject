import java.util.Random;

public class EquilibriumIndex
{
	static int[] array;
	static final int ARR_SI = 11;
	static final Random random = new Random();
	
	static
	{ random.setSeed(System.currentTimeMillis()); }
	
	static int getRandom(int _low, int _high)
	{ return random.nextInt(_high - _low + 1) + _low; }
	
	static int solution(int[] _array)
	{
		int sumRight = 0, sumLeft = 0;
		for (int i = 1; i < _array.length - 1; i++)
		{
			sumLeft = sumRight = 0;
			for (int j = i - 1; j >= 0; j--) 
				sumLeft += _array[j];
			for (int j = i + 1; j <= _array.length - 1; j++)
				sumRight += _array[j];
			if (sumLeft == sumRight) return i;
		}
		return -1;
	}
	
	private static void printArray(int[] _array)
	{ 
		for (int i = 0; i < _array.length; i++) 
			System.out.print(" " + _array[i]);
	}
	
	private static void printResponse(int _number)
	{
		System.out.println(
			" => Equilibrium index: " + ((_number == -1) ? "Absence" : _number)
		);
	}
	
	public static void main(final String[] args)
	{
		int result;
		array = new int[] { -2, 3, 5, 3, -2};
		System.out.print("Test array(with equilibrium):");
		printArray(array);
		result = solution(array);
		printResponse(result);
		array = new int[] { -2, -1, 1, 2, 3};
		System.out.print("Test array(without equilibrium):");
		printArray(array);
		result = solution(array);
		printResponse(result);
		array = new int[ARR_SI];
		System.out.print("Random array: ");
		for (int i = 0; i < array.length; i++)
			array[i] = 
				(getRandom(0, 1) == 0) ? getRandom(-9, -1) : getRandom(1, 9);
		printArray(array);
		result = solution(array);
		printResponse(result);
	}
}