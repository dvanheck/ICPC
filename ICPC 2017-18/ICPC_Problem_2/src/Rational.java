import java.math.BigInteger;

public class Rational 
{
	// Instance Variables
	private BigInteger myNum; // numerator
	private BigInteger myDen; // denominator
	
	
	/**
     * Constructor 
     */
	Rational()
	{
		
	}
	
	/**
     * Constructor that takes in a fraction as a string and separates it into numerator and denominator
     */
	Rational(String frac)
	{
		int slashIndex = frac.indexOf('/');
		
		if(slashIndex == -1)
		{
			myNum = new BigInteger(frac);
			myDen = new BigInteger("1");
		}
		else
		{
			myNum = new BigInteger(frac.substring(0, slashIndex));
			myDen = new BigInteger(frac.substring(slashIndex + 1, frac.length()));
		}
	}
	
	/**
     * Getters and setters for the numerator and denominator
     */
	BigInteger getNum()
	{
		return myNum;
	}
	
	BigInteger getDen()
	{
		return myDen;
	}
	
	void setNum(BigInteger num)
	{
		myNum = num;
	}
	
	void setDen(BigInteger den)
	{
		myDen = den;
	}
	
}
