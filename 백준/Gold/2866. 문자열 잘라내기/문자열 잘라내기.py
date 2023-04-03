import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	256 MB

[입력]
1> R과 C (2 ≤ R, C ≤ 1000)
R> C개의 알파벳 소문자

만약 가장 위의 행을 지워도 테이블의 열을 읽어서 문자열이 중복되지 않는다면, 
가장 위의 행을 지워주고, count의 개수를 1 증가시키는, 이 과정을 반복
예제 1은, 가장 위의 행을 지우면 a,d,a,t,a,k가 되므로 a가 중복 => 출력

sol 1)
가장 밑에서부터 확인하면서 중복이 있으면 위로 올라가고 아니라면 현재 cnt를 출력
=> 중복이었던 문자열만 체크하면 됨
해쉬맵으로 key(인덱스) : val(중복문자열)
구현이..

sol 2) 
문제에서 요구하는 그대로 집합으로 구현해도 될듯
맞았습니다가 나왔지만 307504KB 메모리에 1220ms..
줄이자

sol 3)
꼭 전체를 보지않아도 되므로 이분탐색 이용 (+집합)
"""

def solution():
    for c in range(C):
        tmp = ""
        for r in range(R - 1, -1, -1):
            tmp += all[r][c]
        arr.append(tmp)

    s, e, cnt = 0, R, 0
    set_ = set()
    while s <= e:
        mid = (s + e) // 2
        flag = False
        for c in range(C):
            # print(s,mid,e)
            st = arr[c][0:mid]
            if st in set_:
                flag = True
            else:
                set_.add(st)
        if flag:
            s = mid + 1
        else:
            cnt = mid
            e = mid - 1

    print(R - cnt)


if __name__ == "__main__":
    R, C = map(int, input().split())
    all = [input().strip() for _ in range(R)]
    arr = []
    solution()
