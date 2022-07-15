#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	deque<int> dq;
	int n;
	cin >> n;
	while (n--) {
		string str;
		cin >> str;
		if (str == "push_front") {
			int val;
			cin >> val;
			dq.push_front(val);
		}
		else if (str == "push_back") {
			int val;
			cin >> val;
			dq.push_back(val);
		}
		else if (str == "pop_front") {
			if (dq.empty()) {
				cout << -1 << "\n";
			}
			else {
				cout << dq.front() << "\n";
				dq.pop_front();
			}
		}
		else if (str == "pop_back") {
			if (dq.empty()) {
				cout << -1 << "\n";
			}
			else {
				cout << dq.back() << "\n";
				dq.pop_back();
			}
		}
		else if (str == "size") 
			cout << dq.size() << "\n";
		else if (str == "empty") {
			cout << (int)dq.empty() << "\n";
		}
		else if (str == "front") {
			if (dq.empty()) {
				cout << -1 << "\n";
			}
			else
				cout << dq.front() << "\n";
		}
		else {
			if (dq.empty()) {
				cout << -1 << "\n";
			}
			else
				cout << dq.back() << "\n";
		}
	}
}