/* 
   INEFFICIENT SWAMP COUNTY TOLL ROADS WITHOUT USING MAP/DICTIONARY
   Concepts: decimal precision, vectors
   Author: David Van Heck
*/ 
#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

using namespace std;

int main()
{
  string input; // stores input
  vector<char> letters; // stores license plate letters
  vector<float> probs; // stores probabilities
  
  // store letters and probablilites
  getline(cin, input);
  for(int i = 0; !input.empty(); i++)
  {
      letters.push_back(input.substr(0, 1).at(0));
      probs.push_back(stof(input.substr(2, input.size())));
      
      getline(cin, input);
  }
  
  // calculate probability of each license plate
  getline(cin, input);
  while(!cin.eof())
  {
    float prob = 1.0;

    // iterate through each letter in the license plate
    for(int i = 0; i < input.size(); i++) 
    {
        // check if the current letter has a corresponding probability, if it does multiply by the probability
        bool letterFound = false;
        for(int j = 0; j < letters.size() && letterFound == false; j++)
        {
            if(input[i] == letters[j])
            {
                prob *= probs[j];
                letterFound == true;
            }
        }
    }
    
    // output probability
    cout << setprecision(3) << fixed << prob << endl;
    
    // read next license plate
    getline(cin, input);
  }
}