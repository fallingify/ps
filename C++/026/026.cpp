#include <iostream>
#include <vector>
#include <queue>

using namespace std;

static bool arrive;
static vector<vector <int>> A; //인접리스트
static vector<bool> visited; //방문기록

void DFS(int node);
void BFS(int node);

int main(){
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M, Start;
  arrive = false;
  cin >> N >> M >> Start; //노드 ,엣지, 시작점
  
  A.resize(N + 1); //

  for(int i; i<M; i++){
    int s, e;
    cin >> s >> e;
    A[s].push_back(e);
    A[e].push_back(s);
  }

  for(int i=1; i<=N; i++){
    sort(A[i].begin(), A[i].end()); //increase
  }

  visited = vector<bool>(N+1, false);

  DFS(Start);
  cout << "\n";
  fill(visited.begin(), visited.end(), false);
  BFS(Start);
  cout << "\n";



  return;
}

void DFS(int node){
  cout << node << " ";
  visited[node]  = true;

  for(int i : A[node]){
    if(!visited[i]) {
      DFS(i);
    }
  }
}

void BFS(int node){
  queue<int> myqueue;
  myqueue.push(node);
  visited[node] = true;

  while(!myqueue.empty()) {
    int now_node = myqueue.front();
    myqueue.pop();
    cout << now_node << " ";
    
    for(int i: A[now_node]) {
      if(!visited[i]) {
        visited[i] = true;
        myqueue.push(i);
      }
    }
  }
}