#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int tc;
	int n, m;
	int prio;
	int cnt;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		cnt = 0;
		cin >> n >> m;

		priority_queue<int> pq;
		queue<pair<int, int>> q;

		for (int j = 0; j < n; j++) {
			cin >> prio;
			q.push({ j, prio });
			pq.push(prio);
		}

		while (!q.empty()) {
			int location = q.front().first;
			int value = q.front().second;
			q.pop();

			if (pq.top() == value) {
				pq.pop();
				++cnt;
				if (m == location) {
					cout << cnt << "\n";
					break;
				}
			}

			else q.push({ location, value });
		}
	}
	return 0;
}