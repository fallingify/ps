#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 

    int n, quizNum; 
    cin >> n >> quizNum; 

    vector<int> sum(n + 1, 0);  // 누적합 배열 초기화

    for (int i = 1; i <= n; i++) {
        int ivalue; 
        cin >> ivalue;
        sum[i] = sum[i - 1] + ivalue; 
    }

    for (int i = 0; i < quizNum; i++) {
        int start, end; 
        cin >> start >> end;
        int res = sum[end] - sum[start - 1];
        cout << res << "\n"; 
    }

    return 0;
}
