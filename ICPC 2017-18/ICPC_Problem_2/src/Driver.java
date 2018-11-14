import java.util.Scanner;
import java.math.BigInteger;

public class Driver {
	
	public static void main(String[] args) {
		// instance variables
		Rational a; // leg of triangle
		Rational b; // leg of triangle
		
		Scanner in = new Scanner(System.in); // for reading input
		String aIn; // string input of a
		String bIn; // string input of b
		
		while(in.hasNext())
		{
			aIn = new String(in.next());
			bIn = new String(in.next());
			
			// initialize a and b
			a = new Rational(aIn);
			b = new Rational(bIn);
			
			// find area
			int area = findCongNum(a, b);
			if(area == -1)
			{
				System.out.println("no");
			}
			else
			{
				System.out.println(area);
			}
		}
		
		in.close();
		
	}
	
	// returns the area if it is a congruent number(c is a rational and the area is an integer), and returns -1 if not
	private static int findCongNum(Rational a, Rational b)
	{
		// find the numerator of the left hand side of the pythagorean theorem
		BigInteger pythLhsNumerator = (a.getNum().multiply(a.getNum().multiply(b.getDen().multiply(b.getDen())))).add(a.getDen().multiply(a.getDen().multiply(b.getNum().multiply(b.getNum()))));
		
		// check if the numerator of the left hand side of the pythagorean theorem is a perfect square
		if(isPerfSquare(pythLhsNumerator))
		{
			// find the area, and check if it is an integer
			BigInteger areaAndRem[] = (a.getNum().multiply(b.getNum()).divideAndRemainder(a.getDen().multiply(b.getDen().multiply(new BigInteger("2")))));
			if(areaAndRem[1].intValue() == 0) 
			{
				return areaAndRem[0].intValue();
			}
			else
			{
				return -1;
			}
		}
		else
		{
			return -1;
		}
	}
	
	// takes in a BigInteger n, and returns if it is a perfect square or not
	private static boolean isPerfSquare(BigInteger n)
	{
		double sqrt = Math.sqrt(n.doubleValue());
		
		if(Math.ceil(sqrt) == Math.floor(sqrt))
		{
			return true;
		}
		
		return false;
	}
	
	
	// takes in an int n, and returns if it is a perfect square or not
	private static boolean isPerfSquareBrute(BigInteger n)
	{
		int comparison;
		
		// if n = 1, then return true
		if(n.equals(new BigInteger("1")))
		{
			return true;
		}
		else
		{
		 comparison = -1;
		}
		
		System.out.println("first comparison");
		// loop while i^2 < n and keep squaring i until it equals n, if so return true, if not return false
		for(BigInteger i = new BigInteger("2"); comparison <= 0; i = i.add(new BigInteger("1"))) 
		{
			// checks if i^2 = n
			comparison = i.multiply(i).compareTo(n);
			if(comparison == 0)
			{
				return true;
			}
		}
		return false;
	}
	
}
