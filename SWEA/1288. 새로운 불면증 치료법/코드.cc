#include <bits/stdc++.h>
using namespace std;
 
 
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
 
    int tc;
    cin >> tc;
    for (int T = 1, n; T <= tc; T++) {
        cin >> n;
        int s = 0, ans = 0;
        int i = n, t = 0;
 
        while (1) {
            int k = i;
            while (k) {
                t |= (1 << (k % 10));
                k /= 10;
            }
            if (t == 1023)
                break;
            i += n;
        }
        cout << "#" << T << " " << i << "\n";
    }
    return 0;
}
