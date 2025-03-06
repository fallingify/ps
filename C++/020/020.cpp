#include <iostream>
#include <vector>
using namespace std;

void merge_sort(int s, int e);
static vector<int> a;
static vector<int> temp;

int main() {
  ios::sync_with_stdio(false); 
  cin.tie(NULL); cout.tie(NULL);

  int n; cin >> n;
  a = vector<int>(n+1, 0); 
  temp = vector<int>(n+1, 0); 

  for(int i=1; i<=n; i++) {
    cin >> a[i]; 
  }

  merge_sort(1, n); 

  for(int i=1; i<=n; i++) {
    cout << a[i] << "\n";
  }

}

void merge_sort(int s, int e) {
  if(e - s < 1) {
      return; 
  }

  int m = s + (e - s) / 2;
  merge_sort(s, m); 
  merge_sort(m+1, e);

  for(int i=s; i<=e; i++) {
    temp[i] = a[i]; 
  }

  int k = s;
  int index1 = s;
  int index2 = m + 1;

  while(index1 <= m && index2 <=e) {
    if(temp[index1] > temp[index2]){
      a[k] = temp[index2];
      k++;
      index2++;
    }
    else {
      a[k] = temp[index1];
      k++;
      index1++;

    }
  }

  while(index1 <= m) {
    a[k] = temp[index1];
    k++;
    index1++;
  }

  while(index2 <= e) {
    a[k] = temp[index2];
    k++;
    index2++;
  }
}