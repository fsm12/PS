#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	stack<int> ST;

	int k, total=0;
	cin >> k;
	for (int i = 0; i < k; i++) {
		int in;
		cin >> in;
		if (in != 0) {
			ST.push(in);
			total += in;
		}
		else {
			total -= ST.top();
			ST.pop();
		}
	}
	cout << total;
}