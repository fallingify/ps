#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL); 

  int N; cin >> N;  //입력받을 수열의 크기 
  
  vector<int> A(N, 0); 
  for (int i = 0; i < N; i++) { cin >> A[i]; }

  vector<int> res(N, -1); //출력, 큰 수 없으면 -1로
  stack<int> stk; 


  for(int j=0; j<N ;j++) {
     while(!stk.empty() && A[j] > A[stk.top()]) { //empty()확인안하고 돌리면 런타임에러발생함
      res[stk.top()] = A[j]; // 오큰수 설정
      stk.pop(); // 스택에서 제거
    }
    stk.push(j); 
     

  }
  for(int i=0; i<N; i++) {
    cout << res[i] << ' '; 
  }
}
