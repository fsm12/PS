#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n; cin >> n;
	stack<int> ST;
	stringstream out;
	for (int i = 0, t = 0; i < n; i++) {
		int x; cin >> x;
		while (t < x) ST.push(++t), out << "+\n";
		if (ST.empty() || ST.top() != x)
			return !(cout << "NO" << '\n');
		ST.pop(), out << "-\n";
	}
	cout << out.str();
}