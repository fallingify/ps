#include <iostream>
#include <queue>
using namespace std;

struct compare {
    bool operator()(int a1, int b1) {
        int a = abs(a1); 
        int b = abs(b1); 
        if(a == b){ // 값이 같을때 
            return a1 > b1; 
        }
        else {
            return a > b; // 절대값을 기준으로 정렬
        }
    }
};

int main(){
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 

    //우선순위큐 : 가장작은 값부터 할 때 
    priority_queue<int, vector<int>, compare> q;

    int n;  cin >> n;
    
    for(int i=0; i<n; i++) {
        int r;
        cin >> r;

        if(r == 0) {
            if(q.empty()){
                cout << "0\n";
            }
            else{
                cout << q.top() << '\n';
                q.pop(); 
            }
        }
        else{
            q.push(r);
        }
    }
}
