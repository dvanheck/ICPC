#include <iostream>
#include <vector>

using namespace std;

int main() {
    int input;
    vector<int> s;
    int amountOfValues = 0;

    while(cin >> input || cin.peek() == NULL) {
        s.push_back(input);
        amountOfValues++;

    }

    for(int index = 0; index < amountOfValues; index++) {
        cout << s.at(index) << ":" << endl;

        for(int i = 2; i <= s[index]/2 + 1; i++) {
            if(s[index] % (2 * i - 1) == 0 || (i - 1 + s[index]) % (2 * i - 1) == 0)
                cout << " " << i << "," << i - 1 << endl;
            if(s[index] % i == 0)
                cout << " " << i << "," << i << endl;
        }
    }

    return 0;
}

/** VERSION 1 **/
//#include <iostream>
//#include <vector>
//
//using namespace std;
//
//int main() {
//    int s;
//
//    while(cin >> s) {
//        cout << s << ":" << endl;
//
//        for(int i = 2; i <= s/2 + 1; i++) {
//            if(s % (2 * i - 1) == 0 || (i - 1 + s) % (2 * i - 1) == 0)
//                cout << " " << i << "," << i - 1 << endl;
//            if(s % i == 0)
//                cout << " " << i << "," << i << endl;
//        }
//    }
//
//    return 0;
//}

/** VERSION #2 **/
//#include <iostream>
//#include <vector>
//
//using namespace std;
//
//int main() {
//    int input;
//    vector<int> s;
//    int amountOfValues = 0;
//
//    while(cin >> input) {
//        s.push_back(input);
//        amountOfValues++;
//    }
//
//    for(int index = 0; index < amountOfValues; index++) {
//        cout << s.at(index) << ":" << endl;
//
//        for(int i = 2; i <= s[index]/2 + 1; i++) {
//            if(s[index] % (2 * i - 1) == 0 || (i - 1 + s[index]) % (2 * i - 1) == 0)
//                cout << " " << i << "," << i - 1 << endl;
//            if(s[index] % i == 0)
//                cout << " " << i << "," << i << endl;
//        }
//    }
//
//    return 0;
//}
