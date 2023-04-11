import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
2 초 (추가 시간 없음)	128 MB

[입력]
1> 문자열 (길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.)
1> 폭발 문자열 (길이는 1보다 크거나 같고, 36보다 작거나 같다.)
=> 모든 폭발이 끝난 후 남은 문자열을 출력 (없으면 "FRULA")

폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발
폭발은 폭발 문자열이 문자열에 없을 때까지

sol) replace
메모리 초과 예상

sol) 스택
한글자씩 넣고 bomb 문자열을 발견하면 삭제

"""

def solution():
    stack = []

    for c in string:
        stack.append(c)
        if stack[-len(bomb):] == bomb:
            del stack[-len(bomb):]

    if stack:
        print("".join(stack))
    else:
        print("FRULA")


if __name__ == '__main__':
    string = list(input().strip())
    bomb = list(input().strip())
    solution()
