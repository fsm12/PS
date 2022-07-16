#include <bits/stdc++.h>
using namespace std;
int board[500][500];
int vis[500][500];
int n, m;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
		}
	}
	int mx = 0;
	int num = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (board[i][j] == 0 || vis[i][j])
				continue;
			num += 1;
			queue<pair<int, int>> Q;
			vis[i][j] = 1;
			Q.push({ i,j });
			int area = 0;
			while (!Q.empty()) {
				area += 1;
				pair<int, int> p = Q.front();
				Q.pop();
				for (int dir = 0; dir < 4; dir++) {
					int x = p.first + dx[dir];
					int y = p.second + dy[dir];
					if (x < 0 || x >= n || y < 0 || y >= m)
						continue;
					if (vis[x][y] || board[x][y] != 1)
						continue;
					vis[x][y] = 1;
					Q.push({ x,y });
				}
			}
			mx = max(mx, area);
		}
	}
	cout << num << "\n" << mx;
}