#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 

    int n, m;  cin >> n >> m; 
    vector<long> s(n, 0); 
    vector<long> c(m, 0); 
    long answer = 0; 
    cin >> s[0]; 

    for(int i=1; i<n; i++) {
        int temp = 0; 
        cin >> temp; 
        s[i] = s[i-1] + temp; 
    }

    for(int i=0; i<n; i++){
        int remainderr = s[i] % m; 

        if(remainderr == 0){ answer++; }
        c[remainderr]++;
    }
    for(int i=0; i<m; i++){
        if(c[i] > 1) {
            answer = answer + (c[i] * (c[i]-1)/2); 
        }
    }
    cout << answer << '\n';


}