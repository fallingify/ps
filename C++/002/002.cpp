#include <iostream>
using namespace std;

int main() { 
    int n; 
    int score[1000]; 
    double sum; 

    cin >> n; 
    for(int i=0; i<n; i++) {
        cin >> score[i]; 
    }
    
    double max = score[0]; 

    for(int i=0; i<n ;i++) {
        if(max < score[i]) {
            max = score[i]; 
        }
        sum += score[i]; 
    }

    double avg = sum * 100.0 / max / n; 
    cout << avg << "\n";
    
    return 0; 
}