import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// instance variables
		BigInteger aNum; // leg of triangle
		BigInteger aDen; // leg of triangle
		BigInteger bNum; // leg of triangle
        BigInteger bDen; // leg of triangle

		Scanner in = new Scanner(System.in); // for reading input
		String aIn; // string input of a
		String bIn; // string input of b

		while(in.hasNext())
		{
			aIn = new String(in.next());
			bIn = new String(in.next());

			// initialize a and b
			int slashIndex = aIn.indexOf('/');

            if(slashIndex == -1)
            {
                aNum = new BigInteger(aIn);
                aDen = new BigInteger("1");
            }
            else
            {
                aNum = new BigInteger(aIn.substring(0, slashIndex));
                aDen = new BigInteger(aIn.substring(slashIndex + 1, aIn.length()));
            }

            slashIndex = bIn.indexOf('/');
            if(slashIndex == -1)
            {
                bNum = new BigInteger(bIn);
                bDen = new BigInteger("1");
            }
            else
            {
                bNum = new BigInteger(bIn.substring(0, slashIndex));
                bDen = new BigInteger(bIn.substring(slashIndex + 1, bIn.length()));
            }


			// find area
			int area = findCongNum(aNum, aDen, bNum, bDen);
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
	private static int findCongNum(BigInteger aNum, BigInteger aDen, BigInteger bNum, BigInteger bDen)
	{
		// find the numerator of the left hand side of the pythagorean theorem
		BigInteger pythLhsNumerator = (aNum.multiply(aNum.multiply(bDen.multiply(bDen)))).add(aDen.multiply(aDen.multiply(bNum.multiply(bNum))));

		// check if the numerator of the left hand side of the pythagorean theorem is a perfect square
		if(isPerfSquare(pythLhsNumerator))
		{
			// find the area, and check if it is an integer
			BigInteger areaAndRem[] = (aNum.multiply(bNum).divideAndRemainder(aDen.multiply(bDen.multiply(new BigInteger("2")))));
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

		return (sqrt == Math.floor(sqrt));
	}
}

