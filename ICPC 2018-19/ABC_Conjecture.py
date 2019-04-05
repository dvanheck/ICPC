'''
ABC CONJECTURE ICPC 2018 PROBLEM 10
Concepts: prime factorization, sets

Author: David Van Heck
Date: 4/5/19

'''

import sys
import math

# returns a set of distinct prime factors of a given number
def rad(num):
    primes = set()
    
	# if num is divisible by 2, add 2 as a prime factor and keep dividing num by 2 until 2 is no longer a factor
    isDivBy2 = num % 2 == 0
    if isDivBy2:
        primes.add(2)
    while isDivBy2:
        num = num/2
        isDivBy2 = num % 2 == 0
  
	# does the same process as above for every other x from 3 to sqrt(num)
    x = 3
    while x <= math.sqrt(num):
        isDivByX = num % x == 0
        if isDivByX:
            primes.add(x)
        while isDivByX:
            num = num/x
            isDivByX = num % x == 0
        x += 2
    
	# if num has not reached 1, add the prime factor in num
    if num > 2:
        primes.add(num)
        
    print primes
    return primes
    
# get input
for line in sys.stdin:
    
    inNums = line.split()
    a = int(inNums[0])
    b = int(inNums[1])
    print a, b
    
    # get sets of prime factors of a and b
    aPrimes = rad(a)
    bPrimes = rad(b)
    
    # if a and b have a common prime factor, output "bad"
    if len(aPrimes.intersection(bPrimes)) >= 1:
        print "bad"
    # else output if product of prime factors is <, >, or == to c
    else:
        c = a + b
        cPrimes = rad(c)
        productPrimes = aPrimes.union(bPrimes.union(cPrimes))
        
        product = 1
        for prime in productPrimes:
            product *= prime
    
        if product < c:
            print "less"
        elif product == c:
            print "equal"
        else:
            print "greater"
        
        
    