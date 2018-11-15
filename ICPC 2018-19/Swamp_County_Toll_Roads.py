'''
SWAMP COUNTY TOLL ROADS
Concepts: dictionary, decimal precision/rounding
Author: David Van Heck

Start Time: 2:50
End Time: 3:15

'''

import sys

prob_dict = dict() # stores the letter as keys and the probabilities as values

# read probablilities and store them in dictionary
line = sys.stdin.readline()
while line.strip() != '':
    letter_and_prob = line.replace('\n', '').split(' ')
    prob_dict[letter_and_prob[0]] = float(letter_and_prob[1])
    line = sys.stdin.readline()

# read license plates and output probabilites
for license_plate in sys.stdin:
    prob = 1 # probability of license plate being correct
    for letter in license_plate:
        if letter in prob_dict:
            prob *= prob_dict[letter]
    print('%.3f'%round(prob, 3))
