#include <iostream>
using namespace std;

int main() {
    int sArr[1024][1024] = {}; 

    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 

    int m, n;
    cin >> n >> m; 

    int tmp; 
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            cin >> tmp;
            sArr[i][j] = sArr[i][j-1] + sArr[i-1][j] - sArr[i-1][j-1] + tmp;
        }
    }

    int res;
    int x1, y1, x2, y2;    
    for(int i=0; i<m; i++){
        cin >> x1 >> y1 >> x2 >> y2;
        res = sArr[x2][y2] - sArr[x2][y1-1] - sArr[x1-1][y2] + sArr[x1-1][y1-1];
        cout << res << "\n";
    }
    return 0; 
}