#include <bits/stdc++.h>
using namespace std;
#define MAX 1000000000

long long X, Y, Z;
int cnt = -1;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> X >> Y;
    Z = (Y * 100 / X);
    
    int left = 0, right = MAX;

    if (Z >= 99) {
        cout << cnt;
        return 0;
    }

    while (left <= right) {
        int mid = (left + right) / 2;
        int tmp = (Y + mid) * 100 / (X + mid);

        if (Z < tmp) right = mid - 1;
        else left = mid + 1;
    }
    cout << left;
}