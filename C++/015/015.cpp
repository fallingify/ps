#include<iostream>
#include<vector>

using namespace std;

int main(){
  ios::sync_with_stdio(false); 
  cin.tie(NULL);
  cout.tie(NULL); 
  
  int n; cin>>n; 
  vector<int> v(n,0); 
  for(int i=0; i<n; i++) {
    cin >> v[i]; 
  }
  for(int i=0; i<n-1; i++) {  
    for(int j=i+1; j<n; j++) {
      if(v[i] > v[j]){
        int temp = v[j];
        v[j] = v[i]; 
        v[i] = temp; 
      }
    }

  }

  for(int i=0; i<n; i++) {
    cout << v[i] << '\n';
  }

}
