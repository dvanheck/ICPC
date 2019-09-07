'''
Jolly Jumpers
'''
import sys

for line in sys.stdin:
    n = int(line[0])
    nums = line[1:].split()
    counts = [0] * n 
    
    # subtract consectutive numbers from eachother and increment counts there
    i = 0
    isJolly = True
    while(isJolly and i < n-1):
        diff = abs(int(nums[i])-int(nums[i+1]))
        
        # if the current two numbers maintain jolliness, count the current number
        isJolly = (diff > 0 and diff < n and counts[diff-1] == 0)
        if (isJolly):
            counts[diff-1] += 1
        i += 1
    
    if(isJolly == True):
        print("Jolly")
    else:
        print("Not Jolly")