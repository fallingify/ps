#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> arr(N, 0);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());

    long long count = 0; // Initialize count

    for (int target_idx = 0; target_idx < N; target_idx++)
    {
        long k = arr[target_idx];
        int start_idx = 0;
        int end_idx = N - 1;

        while (start_idx < end_idx)
        {
            if (arr[start_idx] + arr[end_idx] == k)
            {
                if (end_idx != target_idx && start_idx != target_idx)
                {
                    count++;
                    break;
                }
                else if (start_idx == target_idx)
                {
                    start_idx++;
                }
                else if (end_idx == target_idx)
                {
                    end_idx--;
                }
            }
            else if (arr[start_idx] + arr[end_idx] < k)
            {
                start_idx++;
            }
            else
            {
                end_idx--;
            }
        }
    }
    cout << count << "\n";

    return 0;
}
