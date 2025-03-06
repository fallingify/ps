#include <iostream>
#include <vector>
using namespace std;

int main(){
  ios::sync_with_stdio(false); 
  cin.tie(NULL); 
  cout.tie(NULL); 

  int n; cin >> n; 
  vector<int> a(n,0); for(int i=0; i<n; i++) { cin >> a[i];}

  for(int i=0; i<n; i++) {
    int index = i; int value = a[i]; 
    for(int j=i-1; j>=0; j--) {
      if(a[j] < a[i]){
        index = j + 1;
        break; 
      }

      if(j==0){
        index = 0; 
      }
      
    }

    for(int j=i; j>index; j--){
      a[j] = a[j-1];
    }

    a[index] =  value; 

  }
  
  vector<int> s(n, 0);

  s[0] = a[0]; 
  for(int i=1; i<n; i++) { s[i] = s[i-1] + a[i]; }

  int sum = 0;  for(int i=0; i<n; i++){ sum = sum + s[i]; } 
  cout << sum; 
  
  
}