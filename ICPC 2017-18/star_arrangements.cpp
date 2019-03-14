#include <iostream>
#include <vector>

using namespace std;

int main() {
    int input;
    vector<int> s;
    int amountOfValues = 0;

    while(cin >> input) {
        s.push_back(input);
        amountOfValues++;
    }

    for(int index = 0; index < amountOfValues; index++) {
        cout << s[index] << ":" << endl;

        for(int i = 2; i <= s[index]/2 + 1; i++) {
            if(s[index] % (2 * i - 1) == 0 || (i - 1 + s[index]) % (2 * i - 1) == 0)
                cout << " " << i << "," << i - 1 << endl;
            if(s[index] % i == 0)
                cout << " " << i << "," << i << endl;
        }
    }

    return 0;
}
