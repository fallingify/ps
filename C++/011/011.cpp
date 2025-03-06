#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL); 

  int k;  cin >> k;
  vector<int> A(k, 0); for(int i=0; i<k; i++) {cin >> A[i];}

  int n = 1; stack<int> stk; vector<char> res; 
  bool boo = true;
  for(int i=0; i<A.size(); i++) { 
    int now = A[i]; 
    if(now >= n){ while(now >= n){stk.push(n++); res.push_back('+'); } stk.pop(); res.push_back('-'); } 
    else{int top = stk.top(); stk.pop(); if(top > now) { cout << "NO"; boo = false; break;}else{res.push_back('-');}} //now < n 
  }

  if(boo){
    for(int i=0; i<res.size(); i++){ cout << res[i] << '\n'; }
  }

}