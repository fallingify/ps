#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL);
    cout.tie(NULL); 

    string str;
    cin >> str;
    
    vector<int> a(str.size()); 

    for (int i = 0; i < str.size(); i++) {
        a[i] = str[i] - '0'; 
    }

    // 선택 정렬을 사용하여 배열을 내림차순으로 정렬
    for (int i = 0; i < str.length(); i++) {
        int maxIdx = i; //최대값인덱스 초기화

        // i 이후의 요소중에서 
        for (int j = i + 1; j < str.length(); j++) {
            if (a[j] > a[maxIdx]) {
                maxIdx = j;
            } //일단 값이 크면 max로 잡는다. 이걸 나머지 문자열까지 하면 제일 큰 것으로 max가 잡힌다. 
        }

        // 최댓값을 찾았다면 교환합니다.
        if (maxIdx != i) {
            int temp = a[i];
            a[i] = a[maxIdx];
            a[maxIdx] = temp;
        } //
    }

    for (int i = 0; i < a.size(); i++) {
        cout << a[i];
    }
    
    return 0;
}
