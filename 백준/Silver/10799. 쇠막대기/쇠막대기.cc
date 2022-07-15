#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	stack<char> ST;
	string str;
	getline(cin, str);
	int idx = 0;
	int total = 0;
	bool ok = false;
	for (auto c : str) {
		if (c == '(') {
			ST.push(c);
			ok = true;
		}
		else if (c == ')') {
			ST.pop();
			total += 1;
			if (ok == true) {
				total += (ST.size()-1);
			}
			ok = false;
			
		}
	}
	cout << total << "\n";
}