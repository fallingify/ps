#include <iostream>
#include <vector>
#include <algorithm> // sort 함수를 사용하기 위해 필요
using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 

    int N; 
    cin >> N; // 입력받을 수의 개수

    vector<int> numbers(N); // 입력받은 수를 저장할 벡터

    // 수 입력받기
    for (int i = 0; i < N; ++i) {
        cin >> numbers[i];
    }

    // 오름차순으로 정렬
    sort(numbers.begin(), numbers.end());

    // 정렬된 수 출력
    for (int i = 0; i < N; ++i) {
        cout << numbers[i] << '\n';
    }

    return 0;
}
