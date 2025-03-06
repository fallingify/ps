void DFS(int v) {
  if (visited[v]) {
    return;
  }

  visited[v] = true;

for (vector<int>::iterator it = A[v].begin(); it != A[v].end(); ++it) {
    int i = *it;
    if (!visited[i]) {
      DFS(i);
    }
  }


}
