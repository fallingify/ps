#include <iostream>
#include <vector>
using namespace std;

static vector<vector<int>> A; // 인접리스트
static vector<bool> visited;  // 방문기록 배열
static bool arrive = false;   // 도착 확인 변수

void DFS(int now, int depth);

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N >> M; // 사람수, 관계수
  A.resize(N);
  visited = vector<bool>(N, false);

  for (int i = 0; i < M; i++) {
    int s, e;
    cin >> s >> e;
    A[s].push_back(e);
    A[e].push_back(s); // 양방향 연결
  }

  for (int i = 0; i < N; i++) {
    DFS(i, 1);
    if (arrive) {
      break;
    }
  }

  if (arrive) {
    cout << 1 << "\n";
  } else {
    cout << 0 << "\n";
  }
}

void DFS(int now, int depth) {
  if (depth == 5 || arrive) {
    arrive = true;
    return;
  }
  visited[now] = true;

  for (int i : A[now]) {
    if (!visited[i]) {
      DFS(i, depth + 1);
    }
  }
  visited[now] = false; // 백트래킹
}
