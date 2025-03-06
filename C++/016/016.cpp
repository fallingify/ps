#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
  ios::sync_with_stdio(false); 
  cin.tie(NULL); 
  cout.tie(NULL); 

  int n; cin >> n; 

  vector<pair<int, int> > v(n); 
  
  for(int i=0; i<n; i++){
    cin >> v[i].first;
    v[i].second = i; 
  }

  sort(v.begin(), v.end());  //v[i].first만 swap한다. 
  int indexMax = 0; 

  for(int i=0; i<n; i++) {
    if(indexMax < v[i].second - i){
      indexMax = v[i].second - i; 
    }
  }

  cout << indexMax + 1;


}