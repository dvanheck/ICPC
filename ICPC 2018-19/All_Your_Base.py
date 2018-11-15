'''
ALL YOUR BASE ARE BELONG TO US
Concepts: Sets, ASCII functions, Base conversion

Author: David Van Heck 
Start Time: 6:00pm
Finish Time: 7:24pm

Notes: Don't use camelCase in Python
'''

import sys

# converts character to int value (e.g. converts A to 11, Y to 34)
def charToVal(letter):
    n = ord(letter)
    if n in range(65, 65 + 26):
        return n - 55
    else:
        return int(chr(n))
        
# returns a set of all possible base 10 representations of a string of characters with 0-9 and A-Z
def getPosReps(strNum):
    digits = len(strNum)
    #print(digits)
    decimalReps = set()
    
    # check if there is only 1 digit, and if there is, return a set with the value of the num
    if digits == 1:
        decimalReps.add(charToVal(strNum))
        #print("1 digit: ", end='')
        #print(decimalReps)
        return decimalReps
    else:
        # find minimum possible base
        minbase = 2;
        
        for i in range(digits):
            n = charToVal(strNum[i])
            if(n > minbase):
                minbase = n + 1
        #print("Minbase " + str(minbase))
        # store all possible base 10 representations in a set
        for base in range(minbase, 36 + 1):
            decimalNum = 0
            #print(strNum + " In Base " + str(base))
            i = 0
            while i < digits:
                n = charToVal(strNum[i])
                #print("i = " + str(i) + ", " + str(base**(digits - i - 1) * n))
                decimalNum += base**(digits - i - 1) * n
                i+=1
                
            # add decimalNum to the set
            #print("Is Decimal " + str(decimalNum))
            decimalReps.add(decimalNum)
        
        return decimalReps
    

n = int(sys.stdin.readline())

for i in range(n):
    a, b = sys.stdin.readline().split(' ')
    a = a.replace('\n', '')
    b = b.replace('\n', '')
    
    # convert a and b to sets of all possible base 10 representations and check if they intersect
    if (len(getPosReps(a).intersection(getPosReps(b))) >= 1):
        print("yes")
    else:
        print("no")
        