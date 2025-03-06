#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N; // 재료의 개수
    cin >> M; // 번호의 합

    vector<int> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end()); // 오름차순 정렬

    int start_idx = 0;
    int end_idx = N - 1;
    int count = 0; // 합이 M이 되는 경우의 수

    while (start_idx < end_idx) {
        int sum = arr[start_idx] + arr[end_idx];
        if (sum == M) {
            count++;
            start_idx++;
            end_idx--;
        } else if (sum > M) {
            end_idx--;
        } else {
            start_idx++;
        }
    }

    cout << count << "\n";

    return 0;
}
