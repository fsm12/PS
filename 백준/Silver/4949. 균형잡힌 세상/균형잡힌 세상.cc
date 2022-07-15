#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	while (true) {
		string str;
		getline(cin, str);
		if (str == ".") break;
		stack<char> ST;
		bool ok = true;
		for (auto c : str) {
			if (c == '(' || c == '[') {
				ST.push(c);
			}
			else if (c == ')') {
				if (ST.empty() || ST.top() != '(') {
					ok = false;
					break;
				}
				ST.pop();
			}
			else if (c == ']') {
				if (ST.empty() || ST.top() != '[') {
					ok = false;
					break;
				}
				ST.pop();
			}
		}
		if (!ST.empty()) ok = false;
		if (ok) {
			cout << "yes" << "\n";
		}
		else {
			cout << "no" << "\n";
		}
	}
}